package br.com.marph.selenium.subSecretaria;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.conexao.AcessoSistema;
import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagensLog;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.testeExclusao.VisualizarHistoricoSubSecretaria;
import br.com.marph.selenium.testeExclusao.VisualizarSubSecretaria;
import br.com.marph.selenium.utils.LogUtils;

public class PesquisarHistoricoSubSecretaria {
	private final String LOG_NAME = System.getProperty("user.name");
	private WebDriver driver;
	private Logger log = LogManager.getLogger(LOG_NAME);

	@Before
	public void startBrowser() {
		driver = new FirefoxDriver();
		Conexao.ip(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void realizaBusca() throws InterruptedException, TesteAutomatizadoException {
		LogUtils.log(EnumMensagensLog.INICIO, this.getClass());

		long timestart = System.currentTimeMillis();
		
		AcessoSistema.perfilAdministrador(driver);

		MenuSubSecretariaTemplate.prepararAcessoSubSecretaria(driver);

		PesquisarSubSecretaria.pesquisar(driver);

		VisualizarSubSecretaria.visualizar(driver);
		
		VisualizarHistoricoSubSecretaria.visualizarHistorico(driver);
		
		pesquisarHistorico(driver);

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
	
	public static void pesquisarHistorico(WebDriver driver){
		
		driver.findElement(By.id("btnExpandirPesquisaAvancada")).click();
		
		driver.findElement(By.id("dataInicialHistorico")).sendKeys("-24122015");
		
		driver.findElement(By.id("dataFinalHistorico")).sendKeys("-25122015");
		
		driver.findElement(By.id("btnPesquisar")).click();		
		
	}
}
