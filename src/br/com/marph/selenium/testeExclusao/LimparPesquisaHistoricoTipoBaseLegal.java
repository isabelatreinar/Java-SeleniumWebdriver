package br.com.marph.selenium.testeExclusao;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagens;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.tipoBaseLegal.MenuTipoBaseLegalTemplate;
import br.com.marph.selenium.tipoBaseLegal.PesquisarHistoricoTipoBaseLegal;
import br.com.marph.selenium.tipoBaseLegal.PesquisarTipoBaseLegal;
import br.com.marph.selenium.utils.LogUtils;

public class LimparPesquisaHistoricoTipoBaseLegal {
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
	public void limparPesquisaHistoricoTipoBaseLegal() throws TesteAutomatizadoException {

		LogUtils.log(EnumMensagens.INICIO, this.getClass());
		long timestart = System.currentTimeMillis();

		// Acessar Menu Cadastro > Tipo Base Legal
		MenuTipoBaseLegalTemplate.prepararAcessoTipoBaseLegal(driver);
		
		// Pesquisar Tipo Base Legal
		PesquisarTipoBaseLegal.pesquisar(driver);
		
		// Visualizar Tipo de Base Legal
		VisualizarTipoBaseLegal.visualizar(driver);
		
		// Visualizar histórico de tipo de base legal
		VisualizarHistoricoTipoBaseLegal.visualizar(driver);
		
		PesquisarHistoricoTipoBaseLegal.pesquisar(driver);
		
		limpar(driver);
		
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
	
	private void limpar(WebDriver driver) throws TesteAutomatizadoException{
		WebElement btnLimpar = driver.findElement(By.id("btnLimparPesquisa"));
		btnLimpar.click();
		
		WebElement pesquisar = driver.findElement(By.id("btnPesquisar"));
		pesquisar.click();
		
		// validar exclusão de dados dos campos 
		if (StringUtils.isNotBlank(driver.findElement(By.id("dataInicialHistorico")).getText())
				|| StringUtils.isNotBlank(driver.findElement(By.id("dataFinalHistorico")).getText())
				|| StringUtils.isNotBlank(driver.findElement(By.id("camposTipoBaseLegal_chosen")).getText())
				|| !driver.findElement(By.id("usuariosAlteracao_chosen")).getText().equalsIgnoreCase("Modificado Por:")) {
			throw new TesteAutomatizadoException(EnumMensagens.CAMPO_PREENCHIDO, LimparPesquisaHistoricoMunicipio.class);
		}
	}
}
