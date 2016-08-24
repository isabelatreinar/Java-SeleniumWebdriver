package br.com.marph.geicom.funcionalidade.microPage;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.funcionalidade.macroPage.FormularioCadastroMacroP;
import br.com.marph.geicom.util.SeleniumUtil;

public class FormularioCadastroMicroP {

	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String CAMPO_SELECIONAR_MACRO = ".//*[@id='macro_chosen']/div/div/input";
	private static final String CAMPO_MACRO = ".//*[@id='macro_chosen']/a";
	private static final String CAMPO_NOME = "nome";
	private static final String BTN_NOVA_MICRO = "btnNovaMicro";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String opcaoNome = "MICRO TESTE";
	private static FormularioCadastroMacroP macro;
	
	public FormularioCadastroMicroP(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preencherCadastro(){
		
		seleniumUtil = SeleniumUtil.getInstance();
		
		seleniumUtil.clickElementId(driver, BTN_NOVA_MICRO);
		
		seleniumUtil.clickElementId(driver, CAMPO_NOME);
		seleniumUtil.sendKeysId(driver, CAMPO_NOME, opcaoNome);
		
		/**Instanciando o cadastro de macro para usar o atributo nome da macro para cadastro da micro**/
		macro = new FormularioCadastroMacroP(driver);
		
		seleniumUtil.clickElementXpath(driver, CAMPO_MACRO);
		seleniumUtil.clickElementXpath(driver, CAMPO_SELECIONAR_MACRO);
		seleniumUtil.sendKeysXpath(driver, CAMPO_SELECIONAR_MACRO, macro.opcaoNome);
		driver.findElement(By.xpath(CAMPO_SELECIONAR_MACRO)).sendKeys(Keys.ENTER);
		
		seleniumUtil.clickElementId(driver, BTN_SALVAR);
	}
}
