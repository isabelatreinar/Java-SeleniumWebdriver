package br.com.marph.geicom.funcionalidade.baseLegal;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroBaseLegal {

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
	public void cadastrarBaseLegal() throws InterruptedException, AWTException {

		driver.get(IConstante.Url.LOGIN);

		AcessoUtils.acessarSistema(driver);

		Menus.MenuCadastros(driver);
		Menus.subMenuBaseLegal(driver);
			

		PreenchimentoCadastroBaseLegal cadastroBaseLegal = new PreenchimentoCadastroBaseLegal(driver);
		cadastroBaseLegal.preencherCadastro();

	}
}
