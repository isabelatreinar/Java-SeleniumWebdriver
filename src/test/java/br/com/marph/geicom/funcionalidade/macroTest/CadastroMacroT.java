package br.com.marph.geicom.funcionalidade.macroTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.macroPage.PreenchimentoCadastroMacroP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroMacroT {

	private WebDriver driver;
	private PreenchimentoCadastroMacroP cadastroMacro;
		
	@Before
	public void startUp() {
		driver = new FirefoxDriver();

	}
	
	@Test
	public void cadastrarMacro() throws InterruptedException{
		
		driver.get(IConstante.Url.LOGIN);
		
		AcessoUtils.acessarSistemaAdmin(driver);
		
		Menus.MenuCadastros(driver);
		Menus.subMenuMacro(driver);
		
		cadastroMacro = new PreenchimentoCadastroMacroP(driver);
		cadastroMacro.preencherCadastro();
		
	}

}
