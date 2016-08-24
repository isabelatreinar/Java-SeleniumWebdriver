package br.com.marph.geicom.funcionalidade.resolucaoTest;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroAbaBeneficiarioP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroAbaCronogramaP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroAbaImportarMetasP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroAbaImportarParcelasP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroAbaIndicXConogramaP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroAbaIndicadoresP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroAbaModeloXBeneficiarioP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroAbaPeriodosP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroAbaResolucaoP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.PesquisaResolucaoP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroResolucaoT {

	private WebDriver driver;
	private CadastroAbaResolucaoP resolucao;
	private CadastroAbaBeneficiarioP beneficiario;
	private CadastroAbaIndicadoresP indicadores;
	private CadastroAbaPeriodosP periodos;
	private CadastroAbaCronogramaP cronograma;
	private CadastroAbaIndicXConogramaP abaIndicXCrono;
	private CadastroAbaModeloXBeneficiarioP abaModeloXCronograma;
	private CadastroAbaImportarMetasP abaImportacaoMetas;
	private CadastroAbaImportarParcelasP abaImportacaoParcelas;
	private PesquisaResolucaoP pesquisa;

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

		AcessoUtils.acessarSistemaAdmin(driver);

		Menus.MenuCadastros(driver);
		Menus.subMenuResolucao(driver);

//		pesquisa = new PesquisaResolucaoP(driver);
//		pesquisa.parametrosPesquisa();
//		Thread.sleep(3000);

		resolucao = new CadastroAbaResolucaoP(driver);
		resolucao.abaResolucao();

		beneficiario = new CadastroAbaBeneficiarioP(driver);
		beneficiario.abaBeneficiarios();

		indicadores = new CadastroAbaIndicadoresP(driver);
		indicadores.abaIndicadores();

		periodos = new CadastroAbaPeriodosP(driver);
		periodos.abaPeriodos();

		cronograma = new CadastroAbaCronogramaP(driver);
		cronograma.abaCronograma();

		abaIndicXCrono = new CadastroAbaIndicXConogramaP(driver);
		abaIndicXCrono.associarIndicadoresCronograma();

		abaModeloXCronograma = new CadastroAbaModeloXBeneficiarioP(driver);
		abaModeloXCronograma.associarModeloBeneficiario();

		abaImportacaoMetas = new CadastroAbaImportarMetasP(driver);
		abaImportacaoMetas.importarMetas();

		abaImportacaoParcelas = new CadastroAbaImportarParcelasP(driver);
		abaImportacaoParcelas.importarParcelas();
	}

}
