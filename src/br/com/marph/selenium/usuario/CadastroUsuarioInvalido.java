package br.com.marph.selenium.usuario;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.conexao.AcessoSistema;
import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagensLog;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.LogUtils;

public class CadastroUsuarioInvalido {

	private final String LOG_NAME = System.getProperty("user.name");
	private WebDriver driver;
	private Logger log = LogManager.getLogger(LOG_NAME);

	@Before
	public void startBrowser() {
		driver = new FirefoxDriver();
		Conexao.ip(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void realizaBusca() throws TesteAutomatizadoException {

		LogUtils.log(EnumMensagensLog.INICIO, this.getClass());

		long timestart = System.currentTimeMillis();
		
		AcessoSistema.perfilAdministrador(driver);

		MenuUsuarioTemplate.prepararAcessoUsuario(driver);

		WebElement botaoCadastrar = driver.findElement(By.id("btnNovoUsuario"));
		botaoCadastrar.click();

		cadastro();

		if (driver.findElement(By.xpath("//ol[@class='breadcrumb small']")).getText()
				.equalsIgnoreCase("Você está em: Usuário > Novo Usuário")) {
			validacaoToolTip();
		} // Só valida se permanecer na página de novo usuário

		perfilCadastra();

		if (driver.findElement(By.xpath("//ol[@class='breadcrumb small']")).getText()
				.equalsIgnoreCase("Você está em: Usuário > Novo Usuário > Novo Perfil")) {
			validacaoToolTipPerfil();
		} // Só valida se permanecer na página de novo perfil

		float tempoGasto = (System.currentTimeMillis() - timestart);
		float tempoSegundos = tempoGasto / 1000;

		StringBuilder sb = new StringBuilder();
		sb.append("Entrada no sistema - ").append(tempoSegundos).append(" segundos");

		if (tempoSegundos > 5000) {
			log.warn(sb.toString() + "\n");
		} else {
			log.info(sb.toString() + "\n");
		}

	}

	protected void cadastro() {

		//nome
		driver.findElement(By.id("usuarioNome")).sendKeys("TESTEE");

		//cpf
		driver.findElement(By.id("usuarioCpf")).sendKeys("-86168321225");

		//cargo
		driver.findElement(By.id("cargo_chosen")).click();
		driver.findElement(By.xpath("//*[@id='cargo_chosen']/div/div/input")).sendKeys("Prefeito");
		driver.findElement(By.xpath("//*[@id='cargo_chosen']/div/div/input")).sendKeys(Keys.TAB);

		//avançar
		driver.findElement(By.id("btnSalvar")).click();
	}

	protected void validacaoToolTip() throws TesteAutomatizadoException {
		if (StringUtils.isBlank(driver.findElement(By.id("usuarioNome")).getAttribute("value"))) {
			driver.findElement(By.id("usuarioNome")).click();
			if (driver.findElement(By.xpath("//*[@id='usuarioNome_maindiv']/div")).isDisplayed()
					&& driver.findElement(By.xpath("//*[@id='usuarioNome_maindiv']/div")).getText()
							.equalsIgnoreCase("Preenchimento obrigatório!")) {
				throw new TesteAutomatizadoException(EnumMensagensLog.CAMPO_OBRIGATORIO, this.getClass());
			}
		}

		boolean present = true;
		try {
			//cpf
			driver.findElement(By.id("usuarioCpf")).click();
			driver.findElement(By.xpath("//*[@id='usuarioCpf_maindiv']/div")).isDisplayed();
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if (present == true) {
			//cpf
			driver.findElement(By.id("usuarioCpf")).click();
			if (driver.findElement(By.xpath("//*[@id='usuarioCpf_maindiv']/div")).getText()
					.equalsIgnoreCase("Preenchimento obrigatório!")) {
				throw new TesteAutomatizadoException(EnumMensagensLog.CPF_EM_BRANCO, this.getClass());
			}

			if (driver.findElement(By.xpath("//*[@id='usuarioCpf_maindiv']/div")).getText()
					.equalsIgnoreCase("CPF já cadastrado.")) {
				throw new TesteAutomatizadoException(EnumMensagensLog.CPF_JA_CADASTRADO, this.getClass());
			}

			if (driver.findElement(By.xpath("//*[@id='usuarioCpf_maindiv']/div")).getText()
					.equalsIgnoreCase("CPF inválido!")) {
				throw new TesteAutomatizadoException(EnumMensagensLog.CPF_INVALIDO, this.getClass());
			}
		}

		if (driver.findElement(By.id("cargo_maindiv")).isDisplayed()
				&& driver.findElement(By.xpath("//*[@class='form-group has-error']")).isDisplayed()) {
			//cargo
			driver.findElement(By.id("cargo_chosen")).click();
			if (driver.findElement(By.xpath("//*[@id='cargo_maindiv']/div[2]")).getText()
					.equalsIgnoreCase("Preenchimento obrigatório!")) {
				throw new TesteAutomatizadoException(EnumMensagensLog.CARGO_EM_BRANCO, this.getClass());
			}
		}
	}

	public void perfilCadastra() {
		//perfil
		driver.findElement(By.id("modalPerfil_chosen")).click();
		driver.findElement(By.xpath("//*[@id='modalPerfil_chosen']/div/div/input")).sendKeys("Gestor do Beneficiário");
		driver.findElement(By.xpath("//*[@id='modalPerfil_chosen']/div/div/input")).sendKeys(Keys.TAB);

		//extensão
		driver.findElement(By.id("modalExtensaoPerfilId")).sendKeys("uni");
		driver.findElement(By.id("ui-id-2")).click();

		//salvar
		driver.findElement(By.id("btnSalvar")).click();

	}

	protected void validacaoToolTipPerfil() throws TesteAutomatizadoException {
		if (driver.findElement(By.id("modalPerfil_maindiv")).isDisplayed()
				&& driver.findElement(By.xpath("//*[@class='form-group has-error']")).isDisplayed()) {
			WebElement perfil = driver.findElement(By.id("modalPerfil_chosen"));
			perfil.click();
			if (driver.findElement(By.xpath("//*[@id='modalPerfil_maindiv']/div[2]")).getText()
					.equalsIgnoreCase("Obrigatório!")) {
				throw new TesteAutomatizadoException(EnumMensagensLog.PERFIL_EM_BRANCO, this.getClass());
			}
		}

		// FAZER VALIDAÇÃO DE EXTENSÃO,POIS ESTÁ SENDO CORRIGIDO O ERRO.
	}

}
