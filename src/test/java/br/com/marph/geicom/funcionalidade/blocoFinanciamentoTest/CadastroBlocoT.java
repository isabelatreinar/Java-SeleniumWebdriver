package br.com.marph.geicom.funcionalidade.blocoFinanciamentoTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.blocoFinanciamentoPage.FormularioCadastroBlocoP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroBlocoT {

	private WebDriver driver;
	private FormularioCadastroBlocoP cadastro;
	
	@Before
	public void startUp() {
		
		driver = new FirefoxDriver();
		
	}
	
	@Test
	public void cadastrarBloco(){
		
		driver.get(IConstante.Url.LOGIN);
		
		AcessoUtils.acessarSistemaAdmin(driver);
		
		Menus.MenuCadastros(driver);
		Menus.subMenuBloco(driver);
		
		cadastro = new FormularioCadastroBlocoP(driver);
		cadastro.preencherCadastro();
		
	}
	
}
