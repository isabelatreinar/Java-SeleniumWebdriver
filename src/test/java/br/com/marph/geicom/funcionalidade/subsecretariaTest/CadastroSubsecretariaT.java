package br.com.marph.geicom.funcionalidade.subsecretariaTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.subsecretariaPage.FormularioCadastroSubsecretariaP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroSubsecretariaT {

	private WebDriver driver;
	private FormularioCadastroSubsecretariaP cadastro;

	@Before
	public void startUp() {

		driver = new FirefoxDriver();
	}

	@Test
	public void cadastrarSubsecretaria() {

		driver.get(IConstante.Url.LOGIN);

		AcessoUtils.acessarSistemaAdmin(driver);

		Menus.MenuCadastros(driver);
		Menus.subMenuSubsecretaria(driver);

		cadastro = new FormularioCadastroSubsecretariaP(driver);
		cadastro.preencherCadastro();

	}
}
