package br.com.marph.geicom.funcionalidade.macroPage;

import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PreenchimentoCadastroMacroP {

	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String CAMPO_NOME = "nome";
	private static final String BTN_CADASTRAR_MACRO = "btnNovaMacro";
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	public final String opcaoNome = "CENTRO TESTE";
	
	public PreenchimentoCadastroMacroP(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preencherCadastro() throws InterruptedException{
		
		seleniumUtil = SeleniumUtil.getInstance();
		
		seleniumUtil.clickElementId(driver, BTN_CADASTRAR_MACRO);
		
		seleniumUtil.clickElementId(driver, CAMPO_NOME);
		seleniumUtil.sendKeysId(driver, CAMPO_NOME, opcaoNome );
		Thread.sleep(2000);
		
		/**Sistema não salvou com apenas um clique**/
		seleniumUtil.clickElementId(driver, BTN_SALVAR);
		seleniumUtil.clickElementId(driver, BTN_SALVAR);
		
		
	}
}
