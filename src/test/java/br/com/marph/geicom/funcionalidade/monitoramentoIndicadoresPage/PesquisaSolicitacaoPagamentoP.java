package br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PesquisaSolicitacaoPagamentoP {

	private static final String BTN_SOLICITAR_PGTO = "btnComandarPagamento";
	private static final String MARCAR_CHECKBOX_SOLICITAR_PGTO = ".//*[@class='dt-body-center cursorPointer']";
	private static final String CAMPO_BENEFICIARIO = ".//*[@id='comboBeneficiarioPesquisa_chosen']/ul/li/input";
	private static final String BTN_PESQUISAR = "btnPesquisar";
	private static final String CAMPO_DATA_PGTO = ".//*[@id='comboDataParaPagamentoPesquisa_chosen']/ul/li/input";
	private static final String CAMPO_SELECIONAR_MODELO_PGTO = ".//*[@id='comboModeloPagamentoPesquisa_chosen']/div/div/input";
	private static final String CAMPO_MODELO_PGTO = ".//*[@id='comboModeloPagamentoPesquisa_chosen']/a";
	private static final String BTN_EXPANDIR_PESQUISA_AVANCADA = "btnExpandirPesquisaAvancada";
	private static final String CAMPO_SELECIONAR_RESOLUCAO = ".//*[@id='comboResolucaoPesquisa_chosen']/a";
	private static final String CAMPO_RESOLUCAO = CAMPO_SELECIONAR_RESOLUCAO;
	private static final String CAMPO_SELECIONAR_PROGRAMA = ".//*[@id='comboProgramaPesquisa_chosen']/div/div/input";
	private static final String CAMPO_PROGRAMA = ".//*[@id='comboProgramaPesquisa_chosen']/a";
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String opcaoPrograma = "Samu";
	private final String opcaoResolucao = "1235";
	private final String opcaoModelo = "Primeiro";
	private final String opcaoDataPgto = "01/10/2016";
	private final String opcaoBeneficiario = "ARCOS";
	
	
	public PesquisaSolicitacaoPagamentoP(WebDriver driver) {
		this.driver = driver;
	}

	public void pesquisarParcela() throws InterruptedException{
		
		seleniumUtil = SeleniumUtil.getInstance();
		
		seleniumUtil.clickElementXpath(driver, CAMPO_PROGRAMA);
		seleniumUtil.clickElementXpath(driver, CAMPO_SELECIONAR_PROGRAMA);
		seleniumUtil.sendKeysXpath(driver, CAMPO_SELECIONAR_PROGRAMA, opcaoPrograma );
		driver.findElement(By.xpath(CAMPO_SELECIONAR_PROGRAMA)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, CAMPO_RESOLUCAO);
		seleniumUtil.clickElementXpath(driver, CAMPO_SELECIONAR_RESOLUCAO);
		seleniumUtil.sendKeysXpath(driver, CAMPO_SELECIONAR_RESOLUCAO, opcaoResolucao );
		driver.findElement(By.xpath(CAMPO_SELECIONAR_RESOLUCAO)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementId(driver, BTN_EXPANDIR_PESQUISA_AVANCADA);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, CAMPO_MODELO_PGTO);
		seleniumUtil.clickElementXpath(driver, CAMPO_SELECIONAR_MODELO_PGTO);
		seleniumUtil.sendKeysXpath(driver, CAMPO_SELECIONAR_MODELO_PGTO, opcaoModelo );
		driver.findElement(By.xpath(CAMPO_SELECIONAR_MODELO_PGTO)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, CAMPO_DATA_PGTO);
		seleniumUtil.sendKeysXpath(driver, CAMPO_DATA_PGTO, opcaoDataPgto );
		driver.findElement(By.xpath(CAMPO_DATA_PGTO)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementXpath(driver, CAMPO_BENEFICIARIO);
		seleniumUtil.sendKeysXpath(driver, CAMPO_BENEFICIARIO, opcaoBeneficiario);
		driver.findElement(By.xpath(CAMPO_BENEFICIARIO)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementId(driver, BTN_PESQUISAR);
		Thread.sleep(5000);
		
		seleniumUtil.clickElementXpath(driver, MARCAR_CHECKBOX_SOLICITAR_PGTO);
		
		seleniumUtil.clickElementId(driver, BTN_SOLICITAR_PGTO);
	}
}

