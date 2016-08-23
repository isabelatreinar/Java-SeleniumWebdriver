package br.com.marph.geicom.funcionalidade.resolucaoPage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroAbaIndicadoresP {

	private static final String BTN_PROXIMO = "btnProximo";
	private static final String SALVAR_INDICADOR = ".//*[@class='_salvarModelo']";
	private static final String PESO_PRIMEIRO_INDIC = ".//*[@id='tabelaIndicadoresNovo']/div[2]/div[4]/input";
	private static final String PTO_CORTE_PRIMEIRO_INDIC = ".//*[@id='tabelaIndicadoresNovo']/div[2]/div[3]/input";
	private static final String PESO_SEGUNDO_INDIC = ".//*[@class='_tabelaIndicadores']/div[3]/div[4]/input";
	private static final String PTO_CORTE_SEGUNDO_INDIC = ".//*[@class='_tabelaIndicadores']/div[3]/div[3]/input";
	private static final String SELECIONAR_INDICADOR = ".//*[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/li";
	private static final String INDICADOR = "//*[@data-label-field='nomeIndicador']";
	private static final String BTN_ADC_INDIC_FINALISTICO = ".//*[@class='panel-collapse collapse in']/div/ul/li[1]/a";
	private static final String EDITAR_MODELO = ".//*[@class='_editarModelo']";
	private static final String NOME_MODELO = "nome";
	private static final String CADASTRAR_MODELO = "criar";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private String modelo = "Primeiro";
	private String nomeIndic1 = "Taxa de Adesao";
	private String nomeIndic2 = "Taxa de Adesao Oficial";
	private String ptcorte = "5000";
	private String pesoInd = "10000";
	private String pesoInd2 = "5000";
	

	public CadastroAbaIndicadoresP(WebDriver driver) {

		this.driver = driver;
	}

	public void abaIndicadores() throws InterruptedException, AWTException {

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
		seleniumUtil.sendKeysXpath(driver, INDICADOR, nomeIndic2);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_INDICADOR);
		
		seleniumUtil.clickElementXpath(driver, PTO_CORTE_PRIMEIRO_INDIC);
		seleniumUtil.sendKeysXpath(driver, PTO_CORTE_PRIMEIRO_INDIC, ptcorte);

		seleniumUtil.clickElementXpath(driver, PESO_PRIMEIRO_INDIC);
		seleniumUtil.sendKeysXpath(driver, PESO_PRIMEIRO_INDIC, pesoInd);
				
		seleniumUtil.clickElementXpath(driver, SALVAR_INDICADOR);
		Thread.sleep(5000);

		/**Editar modelo para criar um novo indicador pois ao tentar criar um novo indicador na criação do modelo, o selenium clica no nome do primeiro indicador.
		 * Não consigo clicar no nome do segundo a não ser que pegue o numero dinâmico do campo, porém não é viável pois toda vez que o teste roda é um novo código.
		 * Ao editar, o nome do indicador já vinculado fica desabilitado, daí consigo clicar no campo do novo indicador!**/
		
		
		/**Inserir novo indicador - CASO QUEIRA CRIAR APENAS UM INDICADOR COMENTAR O CÓDIGO ABAIXO ATÉ O BOTÃO SALVAR MODELO**/
		seleniumUtil.clickElementXpath(driver, EDITAR_MODELO);
		
		seleniumUtil.clickElementXpath(driver, PESO_PRIMEIRO_INDIC);
		driver.findElement(By.xpath(PESO_PRIMEIRO_INDIC)).clear();
		seleniumUtil.sendKeysXpath(driver, PESO_PRIMEIRO_INDIC, pesoInd2);
		
		seleniumUtil.clickElementXpath(driver, BTN_ADC_INDIC_FINALISTICO);
		
		seleniumUtil.clickElementXpath(driver, INDICADOR);
		seleniumUtil.sendKeysXpath(driver, INDICADOR, nomeIndic1);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_INDICADOR);
		
		seleniumUtil.clickElementXpath(driver, PTO_CORTE_SEGUNDO_INDIC);
		seleniumUtil.sendKeysXpath(driver, PTO_CORTE_SEGUNDO_INDIC, ptcorte);

		seleniumUtil.clickElementXpath(driver, PESO_SEGUNDO_INDIC);
		seleniumUtil.sendKeysXpath(driver, PESO_SEGUNDO_INDIC, pesoInd2);
		
		seleniumUtil.clickElementXpath(driver, SALVAR_INDICADOR);
		Thread.sleep(3000);
		
		seleniumUtil.clickElementId(driver, BTN_PROXIMO);
		Thread.sleep(5000);

	}
}
