package br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PreencherReuniaoRegionalP {

	private static final String COLUNA_STATUS_LISTAGEM = ".//*[@class='sorting_1']";
	private static final String BTN_CONFIRMAR_CONCLUSAO_REUNIAO = "html/body/div[8]/div[2]/div/div/div/div/div[4]/button[1]";
	private static final String BTN_CONCLUIR_VALIDACAO = "btnConcluirValidacao";
	private static final String BTN_SALVAR = ".//*[@class='_save _defaultButton']";
	private static final String CAMPO_JUSTIFICATIVA = ".//*[@class='panel-collapse component-collapse collapse in']/div/div[1]/div[3]/div[2]/textarea";
	private static final String CAMPO_PERCENTUAL_ATING = ".//*[@class='panel-collapse component-collapse collapse in']/div/div[1]/div[1]/div[1]/div/input";
	private static final String CAMPO_SELECIONAR_RECURSO = ".//*[@class='panel-collapse component-collapse collapse in']/div/div[1]/div[1]/div[2]/div/div/div/div/input";
	private static final String CAMPO_RECURSO = ".//*[@class='panel-collapse component-collapse collapse in']/div/div[1]/div[1]/div[2]/div/div/a";
	private static final String BTN_EDITAR = ".//*[@class='_edit _defaultButton']";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String opcaoRecurso = "Deferido";
	private final String opcaoPercentual = "10000";
	private final String textoJustificativa = "Teste Justificativa!";
	private final String statusReuniao = "Reunião realizada";
	
	public PreencherReuniaoRegionalP(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherReuniao() throws InterruptedException{
		
		seleniumUtil = SeleniumUtil.getInstance();
		
		seleniumUtil.clickElementXpath(driver, BTN_EDITAR);
		
		seleniumUtil.clickElementXpath(driver, CAMPO_RECURSO);
		seleniumUtil.clickElementXpath(driver, CAMPO_SELECIONAR_RECURSO);
		seleniumUtil.sendKeysXpath(driver, CAMPO_SELECIONAR_RECURSO, opcaoRecurso );
		driver.findElement(By.xpath(CAMPO_SELECIONAR_RECURSO)).sendKeys(Keys.ENTER);
		
		/**SE O RECURSO FOR 'INDEFERIDO' COMENTAR O CÓDIGO ABAIXO ATÉ O TRECHO 'FIM'**/
		seleniumUtil.clickElementXpath(driver, CAMPO_PERCENTUAL_ATING);
		seleniumUtil.sendKeysXpath(driver, CAMPO_PERCENTUAL_ATING, opcaoPercentual );
		/**FIM**/
		
		seleniumUtil.clickElementXpath(driver, CAMPO_JUSTIFICATIVA);
		seleniumUtil.sendKeysXpath(driver, CAMPO_JUSTIFICATIVA, textoJustificativa );
		
		seleniumUtil.clickElementXpath(driver, BTN_SALVAR);
		Thread.sleep(2000);
		
		seleniumUtil.clickElementId(driver, BTN_CONCLUIR_VALIDACAO);
		
		seleniumUtil.clickElementXpath(driver, BTN_CONFIRMAR_CONCLUSAO_REUNIAO);
		
		//Valida se o status da reunião foi alterado para Reunião Realizada
		assertEquals(statusReuniao , driver.findElement(By.xpath(COLUNA_STATUS_LISTAGEM)).getText());
		
	}
	
}

