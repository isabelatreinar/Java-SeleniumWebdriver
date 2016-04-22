package br.com.marph.selenium.base;

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
import br.com.marph.selenium.enums.EnumMensagens;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.LogUtils;

public class ValidarBotoesVoltarBaseLegal {
	/**
	 * Esta classe valida o botão 'Voltar' da tela 'Visualizar Base Legal' e
	 * 'Histórico de Base Legal'
	 **/
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
	public void qtdeRegistrosBaseLegal() throws TesteAutomatizadoException {

		LogUtils.log(EnumMensagens.INICIO, this.getClass());
		long timestart = System.currentTimeMillis();

		// Acessar Sistema
		AcessoSistema.perfilAdministrador(driver);
		
		// Acessar menu
		MenuBaseLegalTemplate.menuBaseLegal(driver);

		// Validação dos botões
		// Acessar tela Visualizar Base Legal
		VisualizarBaseLegal.visualizar(driver);

		// Acessar tela de Histórico de Base Legal
		VisualizarHistoricoBaseLegal.visualizar(driver);

		/**
		 * Validar botão 'Voltar' Histórico de Base Legal 
		 * Tela corrente: Histórico de Base Legal 
		 * Tela futura: Visualizar Base Legal
		 **/
		driver.findElement(By.id("btnVoltar")).click();
		if (!driver.findElement(By.id("gridSystemModalLabel")).getText().equalsIgnoreCase("Visualizar base legal")) {
			throw new TesteAutomatizadoException(EnumMensagens.TELA_INCORRETA, this.getClass());
		}

		/**
		 * Validar botão 'Voltar' Visualizar Base Legal 
		 * Tela corrente: Visualizar Base Legal 
		 * Tela futura: Listagem de Base Legal 
		 * A validação vefifica se existe um botão de cadastrar nova base legal, pois esse
		 * botão só existe na tela de listagem.
		 **/
		driver.findElement(By.id("btnVoltar1")).click();
		if (!driver.findElement(By.id("btnNovaBaseLegal")).getText().equalsIgnoreCase("Cadastrar Nova Base Legal")) {
			throw new TesteAutomatizadoException(EnumMensagens.TELA_INCORRETA, this.getClass());
		}

		
		// se as telas estiverem corretas o teste é finalizado com sucesso
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
}
