package br.com.marph.geicom.funcionalidade.indicadorTest;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.indicadorPage.CadastroTelaFormulaP;
import br.com.marph.geicom.funcionalidade.indicadorPage.CadastroTelaIndicadorP;
import br.com.marph.geicom.funcionalidade.indicadorPage.CadastroTelaVariaveisP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroIndicadorT {

	private WebDriver driver;
	private CadastroTelaIndicadorP indicador;
	private CadastroTelaVariaveisP variaveis;
	private CadastroTelaFormulaP formula;

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

		AcessoUtils.acessarSistemaAdmin(driver);

		Menus.MenuCadastros(driver);
		Menus.subMenuIndicador(driver);

		indicador = new CadastroTelaIndicadorP(driver);
		indicador.cadastrarTelaIndicador();
		Thread.sleep(5000);

		variaveis = new CadastroTelaVariaveisP(driver);
		variaveis.cadastrarVariaveis();

		formula = new CadastroTelaFormulaP(driver);
		formula.cadastrarFormula();

	}
}
