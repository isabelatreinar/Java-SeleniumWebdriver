package br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresTest;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage.PesquisaTelaValidacaoP;
import br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage.PreenchimentoValidacaoResultP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;


public class ValidacaoResultadosT {

	private WebDriver driver;

	@Before
	public void startUp() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void cadastrarPeriodoValidacao() throws InterruptedException {

		driver.get(IConstante.Url.LOGIN);
		AcessoUtils.acessarSistemaAdmin(driver);

		Menus.MenuProcessos(driver);
		Menus.subMenuValidacao(driver);
		Thread.sleep(8000);
		
		PesquisaTelaValidacaoP pesquisar = new PesquisaTelaValidacaoP(driver);
		pesquisar.pesquisarValidacao();
		
		PreenchimentoValidacaoResultP cadastro = new PreenchimentoValidacaoResultP(driver);
		cadastro.preencherValidacaoResult();
		

	}
}
