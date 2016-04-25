package br.com.marph.selenium.testeExclusao;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagens;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.usuario.MenuUsuarioTemplate;
import br.com.marph.selenium.utils.LogUtils;

public class ValidarBotoesVoltarUsuario {
	/**
	 * Esta classe valida o botão 'Voltar' da tela 'Visualizar Usuário' e
	 * 'Histórico de Usuário'
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

		// Acessar menu
		MenuUsuarioTemplate.prepararAcessoUsuario(driver);

		// Validação dos botões SUPERIORES
		// Acessar tela Visualizar Usuário
		VisualizarUsuario.visualizar(driver);

		// Acessar tela de Histórico de Usuário
		VisualizarHistoricoUsuario.visualizar(driver);

		/**
		 * Validar botão 'Voltar' Histórico de Usuário 
		 * Tela corrente: Histórico de Usuário 
		 * Tela futura: Visualizar Usuário
		 **/
		driver.findElement(By.id("btnVoltar")).click();
		if (!driver.findElement(By.id("gridSystemModalLabel")).getText().equalsIgnoreCase("Visualizar Usuário")) {
			throw new TesteAutomatizadoException(EnumMensagens.TELA_INCORRETA, this.getClass());
		}

		/**
		 * Validar botão 'Voltar' Visualizar Usuário 
		 * Tela corrente: Visualizar Usuário 
		 * Tela futura: Listagem de Usuário
		 * A validação vefifica se existe um botão de cadastrar novo Usuário, pois esse
		 * botão só existe na tela de listagem.
		 **/
		driver.findElement(By.id("btnVoltar1")).click();
		if (!driver.findElement(By.id("btnNovoUsuario")).getText().equalsIgnoreCase("Cadastrar novo usuário")) {
			throw new TesteAutomatizadoException(EnumMensagens.TELA_INCORRETA, this.getClass());
		}

		// Validação dos botões INFERIORES
		VisualizarUsuario.visualizar(driver);

		// Acessar tela de Histórico de Usuário
		VisualizarHistoricoUsuario.visualizar(driver);

		/**
		 * Validar botão 'Voltar' Histórico de Usuário 
		 * Tela corrente: Histórico de Usuário
		 * Tela futura: Visualizar Usuário
		 **/
		driver.findElement(By.id("btnVoltar")).click();
		if (!driver.findElement(By.id("gridSystemModalLabel")).getText().equalsIgnoreCase("Visualizar Usuário")) {
			throw new TesteAutomatizadoException(EnumMensagens.TELA_INCORRETA, this.getClass());
		}

		/**
		 * Validar botão 'Voltar' Visualizar Usuário 
		 * Tela corrente: Visualizar Usuário
		 * Tela futura: Listagem de Usuário A validação
		 * vefifica se existe um botão de cadastrar novo Usuário, pois esse
		 * botão só existe na tela de listagem.
		 **/
		driver.findElement(By.id("btnVoltar")).click();
		if (!driver.findElement(By.id("btnNovoUsuario")).getText().equalsIgnoreCase("Cadastrar novo usuário")) {
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
