package br.com.marph.geicom.funcionalidade.monitoramentoIndicadores;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;
import br.com.marph.geicom.util.Menus;

public class CadastroPeriodoValidacao {

	private WebDriver driver;

	@Before
	public void startUp() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void cadastrarPeriodoMonitoramento() throws InterruptedException{
		
		driver.get(IConstante.Url.LOGIN);
		AcessoUtils.acessarSistema(driver);
		
		Menus.MenuProcessos(driver);
		Menus.subMenuMonitoramento(driver);
		
		PesquisaRegistroMonitoramento pesquisaMonitoramento = new PesquisaRegistroMonitoramento(driver);
		pesquisaMonitoramento.pesquisar();
		
//		PreenchimentoCadastroPeriodoValidacao cadastro = new PreenchimentoCadastroPeriodoValidacao(driver);
//		cadastro.preencherCadastro();
		
	}
}
