package br.com.marph.selenium.usuario;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagens;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.LogUtils;

public class EditarUsuario {
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
	public void realizaBusca() throws Exception {

		LogUtils.log(EnumMensagens.INICIO, this.getClass());

		long timestart = System.currentTimeMillis();

		MenuUsuarioTemplate.prepararAcessoUsuario(driver);

		PesquisarUsuario.pesquisar(driver);

		VisualizarUsuario.visualizar(driver);

		cadastrar();

		if(driver.findElement(By.xpath("//ol[@class='breadcrumb small']")).getText()
				.equalsIgnoreCase("Você está em: Usuário > Visualizar Usuário > Editar Usuário")){
			validacao();
		}

		boolean validar = driver.findElement(By.id("toast-container")).isDisplayed();

		if (validar == true) {
			LogUtils.log(EnumMensagens.USUARIO_VALIDADO, this.getClass());
		} else {
			throw new TesteAutomatizadoException(EnumMensagens.USUARIO_NAO_VALIDADO, this.getClass());
		}

		float tempoGasto = (System.currentTimeMillis() - timestart);
		float tempoSegundos = tempoGasto / 1000;

		StringBuilder sb = new StringBuilder();
		sb.append("Entrada no sistema - ").append(tempoSegundos).append(" segundos - FINALIZADO COM SUCESSO\n");

		if (tempoSegundos > 5000) {
			log.warn(sb.toString() + "\n");
		} else {
			log.info(sb.toString() + "\n");
		}

	}

	private void validacao() throws TesteAutomatizadoException {
		if (StringUtils.isBlank(driver.findElement(By.id("usuarioNome")).getAttribute("value"))) {
			//usuario
			driver.findElement(By.id("usuarioNome")).click();
			if (driver.findElement(By.xpath("//*[@id='usuarioNome_maindiv']/div")).isDisplayed()
					&& driver.findElement(By.xpath("//*[@id='usuarioNome_maindiv']/div")).getText()
							.equalsIgnoreCase("Preenchimento obrigatório!")) {
				throw new TesteAutomatizadoException(EnumMensagens.VALIDACAO_NOME, this.getClass());
			}
		}

		if (driver.findElement(By.id("cargo_maindiv")).isDisplayed()
				&& driver.findElement(By.xpath("//*[@class='form-group has-error']")).isDisplayed()) {
			//cargo
			driver.findElement(By.id("cargo_chosen")).click();
			if (driver.findElement(By.xpath("//*[@id='cargo_maindiv']/div[2]")).getText()
					.equalsIgnoreCase("Preenchimento obrigatório!")) {
				throw new TesteAutomatizadoException(EnumMensagens.CARGO_EM_BRANCO, this.getClass());
			}
		}
	}

	private void cadastrar() {

		//btn editar
		driver.findElement(By.id("btnEditar1")).click();

		//nome
		driver.findElement(By.id("usuarioNome")).clear();
		//nome.sendKeys("Isabela");

		//cargo
		driver.findElement(By.id("cargo_chosen")).click();
		driver.findElement(By.xpath("//*[@id='cargo_chosen']/div/div/input")).sendKeys("Prefeito");
		driver.findElement(By.xpath("//*[@id='cargo_chosen']/div/div/input")).sendKeys(Keys.TAB);

		//salvar
		driver.findElement(By.id("btnSalvar")).click();
	}
}
