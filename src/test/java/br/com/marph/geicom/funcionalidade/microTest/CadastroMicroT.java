package br.com.marph.geicom.funcionalidade.microTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.microPage.PreenchimentoCadastroMicroP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroMicroT {

	private WebDriver driver;
	private PreenchimentoCadastroMicroP cadastro;

	@Before
	public void StartUp() {

		driver = new FirefoxDriver();
	}

	@Test
	public void cadastrarMicro(){
		
		driver.get(IConstante.Url.LOGIN);
		
		AcessoUtils.acessarSistemaAdmin(driver);
		
		Menus.MenuCadastros(driver);
		Menus.subMenuMicro(driver);
		
		cadastro = new PreenchimentoCadastroMicroP(driver);
		cadastro.preencherCadastro();
		
		
		
	}
}
