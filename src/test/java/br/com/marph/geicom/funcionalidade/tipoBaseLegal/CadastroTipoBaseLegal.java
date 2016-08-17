package br.com.marph.geicom.funcionalidade.tipoBaseLegal;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroTipoBaseLegal {

	private WebDriver driver;

	@Before
	public void startUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	// @After
	// public void driverClose() {
	// driver.quit();
	// }

	@Test
	public void cadastrarTipoBase() throws InterruptedException {

		driver.get(IConstante.Url.LOGIN);

		AcessoUtils.acessarSistema(driver);

		Menus.MenuCadastros(driver);
		Menus.subMenuTipoBase(driver);

		// Instância da classe que preenche os elementos no cadastro de tipo de
		// base
		PreenchimentoCadastroTipoBase cadastroTipoBase = new PreenchimentoCadastroTipoBase(driver);
		cadastroTipoBase.preencherCadastro();
	}

}
