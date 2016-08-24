package br.com.marph.geicom.funcionalidade.resolucaoTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.resolucaoPage.CadastroModeloTermoP;
import br.com.marph.geicom.funcionalidade.resolucaoPage.PesquisaTermoFormalizacaoP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class FormalizacaoTermoT {

	private WebDriver driver;
	private PesquisaTermoFormalizacaoP pesquisa;
	private CadastroModeloTermoP modelo;

	@Before
	public void startUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void formalizarResolucao() throws InterruptedException {

		driver.get(IConstante.Url.LOGIN);

		AcessoUtils.acessarSistemaScss(driver);

		Menus.MenuResolucoes(driver);
		Menus.subMenuTermosAditivosV1(driver);

		pesquisa = new PesquisaTermoFormalizacaoP(driver);
		pesquisa.pesquisarResolucao();

		modelo = new CadastroModeloTermoP(driver);
		modelo.cadastrarModeloTermo();
		modelo.formalizarTermo();
		modelo.tornarVigente();

	}

}
