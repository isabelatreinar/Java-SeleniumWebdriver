package br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage.PesquisaReuniaoRegionalP;
import br.com.marph.geicom.funcionalidade.monitoramentoIndicadoresPage.FormularioReuniaoRegionalP;
import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class ExecucaoReuniaoRegionalT {

	private WebDriver driver;
	private PesquisaReuniaoRegionalP pesquisaReuniao;
	private FormularioReuniaoRegionalP realizarReuniao;

	@Before
	public void startUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void realizarReunião() throws InterruptedException {

		driver.get(IConstante.Url.LOGIN);
		
		AcessoUtils.acessarSistemaAdmin(driver);
		
		Menus.MenuProcessos(driver);
		Menus.subMenuReuniao(driver);
		Thread.sleep(6000);
		
		pesquisaReuniao = new PesquisaReuniaoRegionalP(driver);
		pesquisaReuniao.pesquisarReuniao();
		
		realizarReuniao = new FormularioReuniaoRegionalP(driver);
		realizarReuniao.preencherReuniao();
	
	}
}
