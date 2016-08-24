package br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage.PesquisaSolicitacaoPagamentoP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class SolicitacaoPagamentoT {

	private WebDriver driver;
	private PesquisaSolicitacaoPagamentoP solicitacaoPagamento;

	@Before
	public void startUp() {

		driver = new FirefoxDriver();
	}

	@Test
	public void solicitarPagamento() throws InterruptedException {

		driver.get(IConstante.Url.LOGIN);

		AcessoUtils.acessarSistemaAdmin(driver);

		Menus.MenuProcessos(driver);
		Menus.subMenuSolicitacaoPagamento(driver);

		solicitacaoPagamento = new PesquisaSolicitacaoPagamentoP(driver);
		solicitacaoPagamento.pesquisarParcela();

	}

}
