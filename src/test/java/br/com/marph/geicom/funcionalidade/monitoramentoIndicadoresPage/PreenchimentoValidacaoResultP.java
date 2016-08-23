package br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PreenchimentoValidacaoResultP {

	private static final String BTN_SALVAR = ".//*[@class='acoesAccordion pull-right']/li/a";
	private static final String CAMPO_RESULTADO_VARIAVEL = ".//*[@class='decimal inputBorder']";
	private static final String BTN_EDITAR = ".//*[@class='acoesAccordion pull-right']/li[3]/a"; 
	private static final String BTN_SALVAR_SOLICITACAO = ".//*[@class='panel-heading']/ul/li[1]/a";
	private static final String ABA_INFORMACOES_GERAIS = ".//*[@id='ulWizard']/li[1]/a";
	private static final String CABECALHO_INDIC_OFICIAL = ".//*[@id='divEtapaIndicadores']/div/div/div/p/strong";
	private static final String TEXTAREA_JUSTIFICATIVA_REUNIAO = ".//*[@class='panel-body']/div/div[2]/div[2]/textarea";
	private static final String BTN_SOLICITAR_REUNIAO = ".//*[@class='panel panel-default panel-Geicom _collapse']/div/ul/li[3]/a";
	private static final String BTN_PROXIMO = "btnProximo";

	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String textoJustificativa = "Teste";
	private final String reuniaoSolicitada = "Sim";
	private final String resultadoVariavel = "9600";

	public PreenchimentoValidacaoResultP(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherValidacaoResult() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		/** INDICADOR OFICIAL!!!!!! **/

		// Clica sempre na primeira aba, isso porque pode ser que o foco esteja
		// em outras abas. Tentei usar o isDisplayed(), porém o selenium não
		// encontra o elemento, parece ser limitação do Geicom. Ver código
		// comentado no final.
		seleniumUtil.clickElementXpath(driver, ABA_INFORMACOES_GERAIS);

		seleniumUtil.clickElementId(driver, BTN_PROXIMO);
		// valida se existe o cabeçalho para os indicadores oficiais
		

		/**
		 * INDICADOR DECLARATÓRIO - CASO NÃO TENHA COMENTAR O CÓDIGO ABAIXO ATÉ
		 * A DESCRIÇÃO "FIM"
		 **/
		
		seleniumUtil.clickElementXpath(driver, BTN_EDITAR);
		
		seleniumUtil.clickElementXpath(driver, CAMPO_RESULTADO_VARIAVEL);
		driver.findElement(By.xpath(CAMPO_RESULTADO_VARIAVEL)).clear();
		seleniumUtil.sendKeysXpath(driver, CAMPO_RESULTADO_VARIAVEL, resultadoVariavel );
		
		seleniumUtil.clickElementXpath(driver, BTN_SALVAR);
		Thread.sleep(3000);
		
		/**FIM**/
		
		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

		/** Solicitar reunião do primeiro registro**/
		seleniumUtil.clickElementXpath(driver, BTN_SOLICITAR_REUNIAO);
		seleniumUtil.clickElementXpath(driver, TEXTAREA_JUSTIFICATIVA_REUNIAO);
		seleniumUtil.sendKeysXpath(driver, TEXTAREA_JUSTIFICATIVA_REUNIAO, textoJustificativa);

		seleniumUtil.clickElementXpath(driver, BTN_SALVAR_SOLICITACAO);
		Thread.sleep(2000);

		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

		/** Validar se a reunião foi solicitada para o primeiro indicador**/
		assertEquals(reuniaoSolicitada,driver.findElement(By.xpath(".//*[@id='divEtapaInformacoesGerais']/div/div[2]/div/table/tbody/tr[1]/td[3]")).getText());

	}

}

// INDICADOR OFICIAL
// if
// (driver.findElement(By.xpath(".//*[@id='divEtapaInformacoesGerais']/div")).isDisplayed())
// {
// seleniumUtil.clickElementId(driver, BTN_PROXIMO);
// // valida se existe o cabeçalho para os indicadores oficiais
// assertEquals(cabecalho,
// driver.findElement(By.xpath(CABECALHO_INDIC_OFICIAL)).getText());
//
// seleniumUtil.clickElementId(driver, BTN_PROXIMO);
//
// // Solicitar reunião do primeiro registro
// seleniumUtil.clickElementXpath(driver, BTN_SOLICITAR_REUNIAO);
// seleniumUtil.clickElementId(driver, TEXTAREA_JUSTIFICATIVA_REUNIAO);
// seleniumUtil.sendKeysXpath(driver, TEXTAREA_JUSTIFICATIVA_REUNIAO,
// textoJustificativa);
//
// } else if (driver.findElement(By.xpath(cabecalho)).isDisplayed()) {
//
// assertEquals(cabecalho,
// driver.findElement(By.xpath(CABECALHO_INDIC_OFICIAL)).getText());
// seleniumUtil.clickElementId(driver, BTN_PROXIMO);
//
// // Solicitar reunião do primeiro registro
// seleniumUtil.clickElementXpath(driver, BTN_SOLICITAR_REUNIAO);
// seleniumUtil.clickElementId(driver, TEXTAREA_JUSTIFICATIVA_REUNIAO);
// seleniumUtil.sendKeysXpath(driver, TEXTAREA_JUSTIFICATIVA_REUNIAO,
// textoJustificativa);
//
// } else if (driver.findElement(By.xpath(BTN_SOLICITAR_REUNIAO)).isDisplayed())
// {
// // Solicitar reunião do primeiro registro
// seleniumUtil.clickElementXpath(driver, BTN_SOLICITAR_REUNIAO);
// seleniumUtil.clickElementId(driver, TEXTAREA_JUSTIFICATIVA_REUNIAO);
// seleniumUtil.sendKeysXpath(driver, TEXTAREA_JUSTIFICATIVA_REUNIAO,
// textoJustificativa);
//
// } else if
// (driver.findElement(By.xpath(".//*[@id='divEtapaInformacoesGerais']/div/div[1]/div/p")).isDisplayed())
// {
//
// System.out.println("oiiii");
// }
