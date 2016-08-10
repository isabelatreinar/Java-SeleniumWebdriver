package br.com.marph.geicom.funcionalidade.indicador;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroIndicador {

	private WebDriver driver;

	@Before
	public void startUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

	}

	// @After
	// public void driverClose() {
	// driver.quit();
	// }

	@Test
	public void cadastroIndicador() throws InterruptedException {

		driver.get(IConstante.Url.LOGIN);

		AcessoUtils.acessarSistema(driver);

		Menus.MenuCadastros(driver);
		Menus.subMenuIndicador(driver);

		CadastroTelaIndicador indicador = new CadastroTelaIndicador(driver);
		indicador.cadastrarTelaIndicador();
		Thread.sleep(5000);

		CadastroTelaVariaveis variaveis = new CadastroTelaVariaveis(driver);
		variaveis.cadastrarVariaveis();

		CadastroTelaFormula formula = new CadastroTelaFormula(driver);
		formula.cadastrarFormula();

	}
}
