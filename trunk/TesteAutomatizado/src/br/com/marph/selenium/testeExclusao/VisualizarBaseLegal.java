package br.com.marph.selenium.testeExclusao;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.base.MenuBaseLegalTemplate;
import br.com.marph.selenium.conexao.AcessoSistema;
import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagensLog;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.LogUtils;

public class VisualizarBaseLegal {
	private final String LOG_NAME = System.getProperty("user.name");
	private WebDriver driver;
	private Logger log = LogManager.getLogger(LOG_NAME);
	private static String baseSelecionada;

	@Before
	public void startBrowser() {
		driver = new FirefoxDriver();
		Conexao.ip(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void visualizarBaseLegal() throws TesteAutomatizadoException {

		LogUtils.log(EnumMensagensLog.INICIO, this.getClass());
		long timestart = System.currentTimeMillis();

		//Acessar Sistema
		AcessoSistema.perfilAdministrador(driver);
		
		// Acessar menu
		MenuBaseLegalTemplate.menuBaseLegal(driver);

		// Preencher os filtros de pesquisa
		PesquisarBaseLegal.pesquisar(driver);

		// visualizar base legal
		visualizar(driver);
		
		
		// valida se a tela acessada é a correta
		if (!driver.findElement(By.id("gridSystemModalLabel")).getText().equalsIgnoreCase("Visualizar base legal")) {
			throw new TesteAutomatizadoException(EnumMensagensLog.TELA_INCORRETA, this.getClass());
		}
		// validar se a tela corresponde a base legal acessada
		if (!baseSelecionada.equalsIgnoreCase(driver.findElement(By.id("numero")).getText())) {
			throw new TesteAutomatizadoException(EnumMensagensLog.BASE_LEGAL_INCORRETA, this.getClass());
		}

		// Se a tela e a base legal forem os corretos o teste se encerra
		float tempoGasto = (System.currentTimeMillis() - timestart);
		float tempoSegundos = tempoGasto / 1000;

		StringBuilder sb = new StringBuilder();
		sb.append("Entrada no sistema - ").append(tempoSegundos).append(" segundos - FINALIZADO COM SUCESSO\n");

		if (tempoSegundos > 5000) {
			log.warn(sb.toString() + "\n");
		} else {
			log.info(sb.toString() + "\n");
		}

	}

	public static void visualizar(WebDriver driver) {
		driver.findElement(By.xpath("//td[@class='sorting_1']"));
		baseSelecionada = driver.findElement(By.xpath("//td[@class='sorting_1']")).getText();
		driver.findElement(By.xpath("//td[@class='sorting_1']")).click();
	}


}