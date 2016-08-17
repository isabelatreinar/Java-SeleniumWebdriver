package br.com.marph.geicom.funcionalidade.resolucao;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroResolucao {

	private WebDriver driver;

	@Before
	public void startUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

	}
	/*
	 * @After public void driverClose(){ driver.quit(); } //
	 */

	@Test
	public void cadastroResolucao() throws AWTException, InterruptedException {

		driver.get(IConstante.Url.LOGIN);

		AcessoUtils.acessarSistema(driver);

		Menus.MenuCadastros(driver);
		Menus.subMenuResolucao(driver);

//		 PesquisaResolucao pesquisa = new PesquisaResolucao(driver);
//		 pesquisa.parametrosPesquisa();
//		 Thread.sleep(3000);

		CadastroAbaResolucao resolucao = new CadastroAbaResolucao(driver);
		resolucao.abaResolucao();

		CadastroAbaBeneficiario beneficiario = new CadastroAbaBeneficiario(driver);
		beneficiario.abaBeneficiarios();

		CadastroAbaIndicadores indicadores = new CadastroAbaIndicadores(driver);
		indicadores.abaIndicadores();

		CadastroAbaPeriodos periodos = new CadastroAbaPeriodos(driver);
		periodos.abaPeriodos();

		CadastroAbaCronograma cronograma = new CadastroAbaCronograma(driver);
		cronograma.abaCronograma();

		CadastroAbaIndicXConograma abaIndicXCrono = new CadastroAbaIndicXConograma(driver);
		abaIndicXCrono.associarIndicadoresCronograma();

		CadastroAbaModeloXBeneficiario abaModeloXCronograma = new CadastroAbaModeloXBeneficiario(driver);
		abaModeloXCronograma.associarModeloBeneficiario();

		CadastroAbaImportarMetas abaImportacaoMetas = new CadastroAbaImportarMetas(driver);
		abaImportacaoMetas.importarMetas();

		CadastroAbaImportarParcelas abaImportacaoParcelas = new CadastroAbaImportarParcelas(driver);
		abaImportacaoParcelas.importarParcelas();
	}

}
