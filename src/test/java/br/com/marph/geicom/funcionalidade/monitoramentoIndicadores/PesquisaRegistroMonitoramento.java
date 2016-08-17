package br.com.marph.geicom.funcionalidade.monitoramentoIndicadores;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PesquisaRegistroMonitoramento {

	private static final String SELECIONAR_UNIDADE_REGIONAL = ".//*[@id='comboUnidadeRegionalPesquisa_chosen']/ul/li/input";
	private static final String BTN_EXPANDIR_PESQUISA_AVANCADA = "btnExpandirPesquisaAvancada";
	private static final String BTN_PESQUISAR = "btnPesquisar";
	private static final String SELECIONAR_PERIODO = ".//*[@id='comboModeloPeriodoMonitoramentoPesquisa_chosen']/div/div/input";
	private static final String FILTRO_PERIODO = ".//*[@id='comboModeloPeriodoMonitoramentoPesquisa_chosen']/a";
	private static final String SELECIONAR_MODELO = ".//*[@id='comboModeloResolucaoPesquisa_chosen']/div/div/input";
	private static final String FILTRO_MODELO = ".//*[@id='comboModeloResolucaoPesquisa_chosen']/a";
	private static final String SELECIONAR_RESOLUCAO = ".//*[@id='comboResolucaoPesquisa_chosen']/div/div/input";
	private static final String FILTRO_RESOLUCAO = ".//*[@id='comboResolucaoPesquisa_chosen']/a";
	private static final String SELECIONAR_PROGRAMA = ".//*[@id='comboProgramaPesquisa_chosen']/div/div/input";
	private static final String FILTRO_PROGRAMA = ".//*[@id='comboProgramaPesquisa_chosen']/a";

	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String nomePrograma = "Cofinanciamento";
	private final String numResolucao = "4215";
	private final String modelo = "4215";
	private final String periodo = "01/09/2015";
	private final String descrUnidade = "BELO HORIZONTE";

	// construtor
	public PesquisaRegistroMonitoramento(WebDriver driver) {
		this.driver = driver;
	}

	public void pesquisar() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementXpath(driver, FILTRO_PROGRAMA);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_PROGRAMA);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_PROGRAMA, nomePrograma);
		driver.findElement(By.xpath(SELECIONAR_PROGRAMA)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, FILTRO_RESOLUCAO);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_RESOLUCAO);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_RESOLUCAO, numResolucao);
		driver.findElement(By.xpath(SELECIONAR_RESOLUCAO)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, FILTRO_MODELO);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_MODELO);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_MODELO, modelo);
		driver.findElement(By.xpath(SELECIONAR_MODELO)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, FILTRO_PERIODO);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_PERIODO);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_PERIODO, periodo);
		driver.findElement(By.xpath(SELECIONAR_PERIODO)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementId(driver, BTN_EXPANDIR_PESQUISA_AVANCADA);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, SELECIONAR_UNIDADE_REGIONAL);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_UNIDADE_REGIONAL, descrUnidade);
		driver.findElement(By.xpath(SELECIONAR_UNIDADE_REGIONAL)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementId(driver, BTN_PESQUISAR);
		Thread.sleep(4000);
		
	}
}
