package br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PesquisaTelaValidacaoP {

	private static final String FILTRO_BENEFICIARIO = ".//*[@id='comboBeneficiarioPesquisa_chosen']/ul/li/input";
	private static final String REGISTRO_LISTAGEM = ".//*[@class='odd']/td[1]";
	private static final String BTN_PESQUISAR = "btnPesquisar";
	private static final String FILTRO_UNIDADE_REGIONAL = ".//*[@id='comboUnidadeRegionalPesquisa_chosen']/ul";
	private static final String BTN_EXPANDIR_PESQUISA_AVANCADA = "btnExpandirPesquisaAvancada";
	private static final String FILTRO_SELECIONAR_PERIODO_MONIT = ".//*[@id='comboModeloPeriodoMonitoramentoPesquisa_chosen']/div/div/input";
	private static final String FILTRO_PERIODO_MONIT = ".//*[@id='comboModeloPeriodoMonitoramentoPesquisa_chosen']/a";
	private static final String FILTRO_SELECIONAR_MOD_INDIC = ".//*[@id='comboModeloResolucaoPesquisa_chosen']/div/div/input";
	private static final String FILTRO_MODELO_INDICADOR = ".//*[@id='comboModeloResolucaoPesquisa_chosen']/a";
	private static final String FILTRO_SELECIONAR_RESOLUCAO = ".//*[@id='comboResolucaoPesquisa_chosen']/div/div/input";
	private static final String FILTRO_RESOLUCAO = ".//*[@id='comboResolucaoPesquisa_chosen']/a";
	private static final String FILTRO_SELECIONAR_PROGRAMA = ".//*[@id='comboProgramaPesquisa_chosen']/div/div/input";
	private static final String FILTRO_PROGRAMA = ".//*[@id='comboProgramaPesquisa_chosen']/a";
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String opcaoPrograma = "Samu";
	private final String opcaoResolucao = "1235";
	private final String opcaoModelo = "Primeiro";
	private final String opcaoPeriodo = "01/01/2016";
	private final String opcaoUnidadeRegional = "BELO HORIZONTE";
	private final String opcaoBeneficiario = "APAE DE ALÉM PARAIBA";
	
	public PesquisaTelaValidacaoP(WebDriver driver) {
		this.driver = driver;
	}

	public void pesquisarValidacao() throws InterruptedException{
		
		seleniumUtil = SeleniumUtil.getInstance();
		
		
		seleniumUtil.clickElementXpath(driver, FILTRO_PROGRAMA);
		seleniumUtil.clickElementXpath(driver, FILTRO_SELECIONAR_PROGRAMA);
		seleniumUtil.sendKeysXpath(driver, FILTRO_SELECIONAR_PROGRAMA, opcaoPrograma);
		driver.findElement(By.xpath(FILTRO_SELECIONAR_PROGRAMA)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, FILTRO_RESOLUCAO);
		seleniumUtil.clickElementXpath(driver, FILTRO_SELECIONAR_RESOLUCAO);
		seleniumUtil.sendKeysXpath(driver, FILTRO_SELECIONAR_RESOLUCAO, opcaoResolucao );
		driver.findElement(By.xpath(FILTRO_SELECIONAR_RESOLUCAO)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, FILTRO_MODELO_INDICADOR);
		seleniumUtil.clickElementXpath(driver, FILTRO_SELECIONAR_MOD_INDIC);
		seleniumUtil.sendKeysXpath(driver, FILTRO_SELECIONAR_MOD_INDIC, opcaoModelo);
		driver.findElement(By.xpath(FILTRO_SELECIONAR_MOD_INDIC)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, FILTRO_PERIODO_MONIT);
		seleniumUtil.clickElementXpath(driver, FILTRO_SELECIONAR_PERIODO_MONIT);
		seleniumUtil.sendKeysXpath(driver, FILTRO_SELECIONAR_PERIODO_MONIT, opcaoPeriodo );
		driver.findElement(By.xpath(FILTRO_SELECIONAR_PERIODO_MONIT)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementId(driver, BTN_EXPANDIR_PESQUISA_AVANCADA);
		Thread.sleep(2000);
		
//		seleniumUtil.clickElementXpath(driver, FILTRO_UNIDADE_REGIONAL);
//		seleniumUtil.sendKeysXpath(driver, FILTRO_UNIDADE_REGIONAL, opcaoUnidadeRegional);
//		driver.findElement(By.xpath(FILTRO_UNIDADE_REGIONAL)).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, FILTRO_BENEFICIARIO);
		seleniumUtil.sendKeysXpath(driver, FILTRO_BENEFICIARIO, opcaoBeneficiario );
		driver.findElement(By.xpath(FILTRO_BENEFICIARIO)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementId(driver, BTN_PESQUISAR);
		Thread.sleep(3000);
		
		/**clica no primeiro registro da listagem**/
		seleniumUtil.clickElementXpath(driver, REGISTRO_LISTAGEM);
		Thread.sleep(2000);
//		seleniumUtil.clickElementId(driver, BTN_ATALHO);
//		seleniumUtil.clickElementId(driver, BTN_EDITAR_ATALHO);
		
	}
}
