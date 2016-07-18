package br.com.marph.selenium.tipoBaseLegal;

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

import br.com.marph.selenium.conexao.AcessoSistema;
import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagensLog;
import br.com.marph.selenium.utils.LogUtils;

public class CadastrarTipoBaseLegal {
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
	public void cadastroTipoBaseLegal() {

		LogUtils.log(EnumMensagensLog.INICIO, this.getClass());

		long timestart = System.currentTimeMillis();

		AcessoSistema.perfilAdministrador(driver);
		
		MenuTipoBaseLegalTemplate.menuTipoBaseLegal(driver);

		cadastro();

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
	
	public void cadastro() {
		WebElement cadastrar = driver.findElement(By.id("btnNovoTipoBaseLegal"));
		cadastrar.click();

		WebElement nome = driver.findElement(By.id("nomeTipoBaseLegal"));
		nome.sendKeys("Testeiw");

		WebElement transferencia = driver.findElement(By.id("transferenciaRecursosFinanceiros_chosen"));
		transferencia.click();
		WebElement transferenciaSeleciona = driver
				.findElement(By.xpath("//*[@id='transferenciaRecursosFinanceiros_chosen']/div/div/input"));
		transferenciaSeleciona.sendKeys("Sim");
		transferenciaSeleciona.sendKeys(Keys.TAB);

		WebElement prestacao = driver.findElement(By.id("prestacaoMetas_chosen"));
		prestacao.click();
		WebElement prestacaoSeleciona = driver.findElement(By.xpath("//*[@id='prestacaoMetas_chosen']/div/div/input"));
		prestacaoSeleciona.sendKeys("Sim");
		prestacaoSeleciona.sendKeys(Keys.TAB);

		WebElement prestacaoContas = driver.findElement(By.id("prestacaoContas_chosen"));
		prestacaoContas.click();
		WebElement prestacaoContasSeleciona = driver
				.findElement(By.xpath("//*[@id='prestacaoContas_chosen']/div/div/input"));
		prestacaoContasSeleciona.sendKeys("Sim");
		prestacaoContasSeleciona.sendKeys(Keys.TAB);

		WebElement salvar = driver.findElement(By.id("btnSalvar"));
		salvar.click();
	}
}