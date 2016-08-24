package br.com.marph.geicom.funcionalidade.unidadeRegionalTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.unidadeRegionalPage.FormularioCadastroUnidadeRegionalP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroUnidadeRegionalT {

	private WebDriver driver;
	private FormularioCadastroUnidadeRegionalP cadastro;
	
	@Before
	public void startUp(){
		
		driver = new FirefoxDriver();
	}
	
	@Test
	public void cadastrarUnidadeRegional(){
		
		driver.get(IConstante.Url.LOGIN);
		
		AcessoUtils.acessarSistemaAdmin(driver);
		
		Menus.MenuCadastros(driver);
		Menus.subMenuUnidadeRegional(driver);
		
		cadastro = new FormularioCadastroUnidadeRegionalP(driver);
		cadastro.preencherCadastro();
	}
	
}
