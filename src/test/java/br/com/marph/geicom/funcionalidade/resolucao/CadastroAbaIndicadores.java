package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroAbaIndicadores {

	private static final String BTN_PROXIMO = "btnProximo";
	private static final String SALVAR_INDICADOR = ".//*[@id='headingNovo']/ul/li[1]/a";
	private static final String PESO = ".//*[@id='tabelaIndicadoresNovo']/div[2]/div[4]/input";
	private static final String PONTO_CORTE = ".//*[@id='tabelaIndicadoresNovo']/div[2]/div[3]/input";
	private static final String SELECIONAR_INDICADOR = ".//*[@id='ui-id-2']";
	private static final String INDICADOR = "//*[@data-label-field='nomeIndicador']";
	private static final String BTN_ADC_INDIC_FINALISTICO = ".//*[@id='collapseNovo']/div/ul/li[1]/a";
	private static final String NOME_MODELO = "nome";
	private static final String CADASTRAR_MODELO = "criar";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private String modelo = "Primeiro";
	private String nomeIndic = "dias";
	private String ptcorte = "5000";
	private String pesoInd = "10000";

	public CadastroAbaIndicadores(WebDriver driver) {

		this.driver = driver;
	}

	public void abaIndicadores() throws InterruptedException {

		/*
		 * if(driver.findElement(By.id("mensagemNaoPrestacaoMetas")).getText().
		 * equalsIgnoreCase("Não é necessário inserir informações nesta aba.")){
		 * 
		 * }
		 */

		// driver.findElement(By.xpath(".//*[@id='divBotoesAtalho']/ul")).click();

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, CADASTRAR_MODELO);

		seleniumUtil.clickElementId(driver, NOME_MODELO);
		seleniumUtil.sendKeysId(driver, NOME_MODELO, modelo);

		seleniumUtil.clickElementXpath(driver, BTN_ADC_INDIC_FINALISTICO);

		seleniumUtil.clickElementXpath(driver, INDICADOR);
		seleniumUtil.sendKeysXpath(driver, INDICADOR, nomeIndic);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_INDICADOR);

		seleniumUtil.clickElementXpath(driver, PONTO_CORTE);
		seleniumUtil.sendKeysXpath(driver, PONTO_CORTE, ptcorte);

		seleniumUtil.clickElementXpath(driver, PESO);
		seleniumUtil.sendKeysXpath(driver, PESO, pesoInd);

		seleniumUtil.clickElementXpath(driver, SALVAR_INDICADOR);
		Thread.sleep(8000);

		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

	}
}
