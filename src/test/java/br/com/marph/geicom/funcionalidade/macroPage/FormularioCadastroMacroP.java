package br.com.marph.geicom.funcionalidade.macroPage;

import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class FormularioCadastroMacroP {

	private static final String BARRA_FERRAMENTAS = ".//*[@id='divBotoesAtalho']/ul";
	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String CAMPO_NOME = "nome";
	private static final String BTN_CADASTRAR_MACRO = "btnNovaMacro";
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	public final String opcaoNome = "CENTRO TESTE";
	
	public FormularioCadastroMacroP(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preencherCadastro() throws InterruptedException{
		
		seleniumUtil = SeleniumUtil.getInstance();
		
		seleniumUtil.clickElementId(driver, BTN_CADASTRAR_MACRO);
		
		seleniumUtil.clickElementId(driver, CAMPO_NOME);
		seleniumUtil.sendKeysId(driver, CAMPO_NOME, opcaoNome );
		Thread.sleep(2000);
		
		/**Foi necessário inserir um comando para clicar na barra de ferramentas antes de clicar no botão salvar,
		 * pois quando o cursor está no campo nome, e clica no botão Salvar, o botão não retorna nenhum ação; é necessário
		 * tirar o foco do campo**/
		seleniumUtil.clickElementXpath(driver, BARRA_FERRAMENTAS);
		seleniumUtil.clickElementId(driver, BTN_SALVAR);
		
		
	}
}
