package br.com.marph.geicom.funcionalidade.baseLegalTest;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.baseLegalPage.FormularioCadastroBaseLegalP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroBaseLegalT {

	private WebDriver driver;
	private FormularioCadastroBaseLegalP cadastroBaseLegal;


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

		AcessoUtils.acessarSistemaAdmin(driver);

		Menus.MenuCadastros(driver);
		Menus.subMenuBaseLegal(driver);
			

		cadastroBaseLegal = new FormularioCadastroBaseLegalP(driver);
		cadastroBaseLegal.preencherCadastro();

	}
}
