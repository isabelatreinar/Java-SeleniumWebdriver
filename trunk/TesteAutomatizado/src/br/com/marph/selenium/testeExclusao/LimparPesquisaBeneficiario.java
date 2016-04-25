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

import br.com.marph.selenium.beneficiario.MenuBeneficiarioTemplate;
import br.com.marph.selenium.beneficiario.PesquisarBeneficiarioMozilla;
import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagens;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.LogUtils;

public class LimparPesquisaBeneficiario {
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
	public void limparPesquisaBeneficiario() throws TesteAutomatizadoException, InterruptedException {

		LogUtils.log(EnumMensagens.INICIO, this.getClass());
		long timestart = System.currentTimeMillis();
		
		// Acessar menu
		MenuBeneficiarioTemplate.menuBeneficiario(driver);
		
		// Preencher os filtros de pesquisa
		PesquisarBeneficiarioMozilla.pesquisar(driver);
		
		//Limpar os filtros
		limpar();
		
		// validar exclusão de dados dos campos
		if(StringUtils.isNotBlank(driver.findElement(By.id("buscaNome")).getText()) || 
				StringUtils.isNotBlank(driver.findElement(By.id("unidadeRegional")).getText()) ||
				StringUtils.isNotBlank(driver.findElement(By.id("buscaCnpj")).getText()) || 
				StringUtils.isNotBlank(driver.findElement(By.id("buscaTipoBeneficiario")).getText()) || 
				StringUtils.isNotBlank(driver.findElement(By.id("buscaMunicipio")).getText())){
			throw new TesteAutomatizadoException(EnumMensagens.CAMPO_PREENCHIDO, this.getClass());
		}
		
		// se todos os campo estiverem vazios o teste é finalizado com sucesso
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
	
	public void limpar(){	
		WebElement btnLimpar = driver.findElement(By.id("btnLimparPesquisa"));
		btnLimpar.click();
	}

}
