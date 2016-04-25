package br.com.marph.selenium.beneficiario;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.enums.EnumMensagens;
import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.testeExclusao.VisualizarBeneficiario;
import br.com.marph.selenium.utils.LogUtils;

public class EditarBeneficiario {
	/**
	 * Esta classe valida a funcionalidade de seleção edição de beneficiario
	 * Para realizar este teste o CNPJ editado deve estar cadastrado no CAGEC
	 **/
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
	public void editarBeneficiario() throws TesteAutomatizadoException, InterruptedException {

		LogUtils.log(EnumMensagens.INICIO, this.getClass());
		long timestart = System.currentTimeMillis();

		// Acessar menu
		MenuBeneficiarioTemplate.menuBeneficiario(driver);

		// Pesquisar Beneficiario
		PesquisarBeneficiarioMozilla.pesquisar(driver);

		// Acessa a tela de visualização do beneficiário
		VisualizarBeneficiario.visualizar(driver);

		// Acessar tela de edição e editar beneficiario
		driver.findElement(By.id("btnEditar1")).click();
		editar();

		// se o toast for exibido e a mensagem estiver correta o teste se
		// encerra
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

	private void editar() throws TesteAutomatizadoException {
		/*
		 * Verifica se a tela de edição acessada corresponde ao beneficiário
		 * selecionado O sinal de - é colocado devido a máscara no componente
		 */

		WebElement cnpj = driver.findElement(By.id("cnpj"));
		cnpj.clear();
		cnpj.sendKeys("-13064113000101");
		cnpj.sendKeys(Keys.TAB);

		WebElement justificativa = driver.findElement(By.id("justificativa"));
		justificativa.sendKeys("Teste");

		if (driver.findElement(By.id("cnpj_maindiv")).isDisplayed()
				&& driver.findElement(By.xpath("//*[@class='form-group has-error']")).isDisplayed()) {
			cnpj.click();
			if (driver.findElement(By.xpath("//*[@id='cnpj_maindiv']/div")).getText()
					.equalsIgnoreCase("CNPJ Inválido!")) {
				throw new TesteAutomatizadoException(EnumMensagens.CNPJ_INVALIDO, getClass());
			}
		} else {

			WebElement salvar = driver.findElement(By.id("btnSalvar1"));
			salvar.click();
		}
		/*
		 * cnpj.click(); System.out.println(driver.findElement(By.xpath(
		 * "//*[@id='cnpj_maindiv']/div")).getText());
		 */

		// valida exibição do toast
		if (driver.findElement(By.id("toast-conteiner")).isDisplayed()) {
			throw new TesteAutomatizadoException(EnumMensagens.TOAST_DESABILITADO, this.getClass());
		}
		// valida mensagem exibida
		else if (!driver.findElement(By.xpath("/div/div[2]")).getText()
				.equalsIgnoreCase("Beneficiário salvo com sucesso.")) {
			throw new TesteAutomatizadoException(EnumMensagens.MENSAGEM_INCORRETA, this.getClass());
		}
	}
}
