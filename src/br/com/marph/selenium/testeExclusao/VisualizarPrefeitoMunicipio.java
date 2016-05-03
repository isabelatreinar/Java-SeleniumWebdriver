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
import br.com.marph.selenium.enums.EnumMensagensLog;
import br.com.marph.selenium.municipio.MenuMunicipioTemplate;
import br.com.marph.selenium.municipio.PesquisarMunicipio;
import br.com.marph.selenium.utils.LogUtils;

public class VisualizarPrefeitoMunicipio {
	private final String LOG_NAME = System.getProperty("user.name");
	private WebDriver driver;
	private Logger log = LogManager.getLogger(LOG_NAME);	
	
	@Before
	public void startBrowser(){
		driver = new FirefoxDriver();
		Conexao.ip(driver);  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}	

	@Test
	public void realizaBusca(){			
		
		LogUtils.log(EnumMensagensLog.INICIO, this.getClass());
		
		long timestart = System.currentTimeMillis();		
		
		MenuMunicipioTemplate.prepararAcessoMunicipio(driver);
			
		PesquisarMunicipio.pesquisar(driver);
		
		VisualizarMunicipio.visualizar(driver);
			
		visualizar(driver);		 		
		
		float tempoGasto = (System.currentTimeMillis() - timestart );
		float tempoSegundos = tempoGasto/1000;
		
		StringBuilder sb = new StringBuilder();
		sb.append("Entrada no sistema - ").append(tempoSegundos).append(" segundos - FINALIZADO COM SUCESSO\n");
	
		if(tempoSegundos>5000){
			log.warn(sb.toString()+"\n");
		}else{
			log.info(sb.toString()+"\n");
		}		
	}

	public static void visualizar(WebDriver driver) {
		driver.findElement(By.id("btnVisualizarPrefeito")).click();
	}
}
