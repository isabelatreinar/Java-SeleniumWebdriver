package br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.enums.EnumMensagemLog;
import br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage.PesquisaTelaMonitoramentoP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;
import br.com.marph.geicom.util.SeleniumUtil;

public class ImportacaoResultadosT {

	private static final String BTN_IMPORTAR = "buttonImportar";
	private static final String FILTRO_SELECIONAR_ARQUIVO = "uploadMonitoramentoIndicadores";
	private static final String FILTRO_SELECIONAR_CONTEUDO = ".//*[@id='comboConteudoImportarPlanilha_chosen']/div/div/input";
	private static final String FILTRO_CONTEUDO = ".//*[@id='comboConteudoImportarPlanilha_chosen']/a";
	private static final String BTN_IMPORTAR_PLANILHA = "buttonImportarPlanilha";

	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String opcaoConteudo = "Importação";

//	public ImportacaoResultados(WebDriver driver) {
//		this.driver = driver;
//	}

	@Before
	public void startUp() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void importarResultados() throws InterruptedException {

		driver.get(IConstante.Url.LOGIN);
		AcessoUtils.acessarSistemaAdmin(driver);

		Menus.MenuProcessos(driver);
		Menus.subMenuMonitoramento(driver);
		
		PesquisaTelaMonitoramentoP pesquisaMonitoramento = new PesquisaTelaMonitoramentoP(driver);
		pesquisaMonitoramento.pesquisar();

		importarPlanilha();

	}

	public void importarPlanilha() {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, BTN_IMPORTAR_PLANILHA);

		seleniumUtil.clickElementXpath(driver, FILTRO_CONTEUDO);
		seleniumUtil.clickElementXpath(driver, FILTRO_SELECIONAR_CONTEUDO);
		seleniumUtil.sendKeysXpath(driver, FILTRO_SELECIONAR_CONTEUDO, opcaoConteudo);
		driver.findElement(By.xpath(FILTRO_SELECIONAR_CONTEUDO)).sendKeys(Keys.ENTER);

		File planilha = new File("./data/Geicom/resultadosExport.xlsx");

		// TODO substituir por um Assert
		// Verificação se a planilha está na pasta
		if (planilha.exists()) {

			WebElement selecionarArquivo = driver.findElement(By.id(FILTRO_SELECIONAR_ARQUIVO));
			selecionarArquivo.sendKeys(planilha.getAbsolutePath());

		} else {
			Assert.fail(EnumMensagemLog.ARQUIVO_NÃO_ENCONTRADO.getMensagem());
		}

		seleniumUtil.clickElementId(driver, BTN_IMPORTAR);
	}

}
