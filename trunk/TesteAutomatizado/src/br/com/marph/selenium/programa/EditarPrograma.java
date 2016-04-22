package br.com.marph.selenium.programa;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagens;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.LogOut;
import br.com.marph.selenium.utils.LogUtils;

public class EditarPrograma {
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
		LogUtils.log(EnumMensagens.INICIO, this.getClass());

		long timestart = System.currentTimeMillis();

		MenuProgramaTemplate.prepararAcessoPrograma(driver);

		PesquisarPrograma.pesquisar(driver);

		VisualizarPrograma.visualizar(driver);

		editar();

		if (driver.findElement(By.xpath("//ol[@class='breadcrumb small']")).getText()
				.equalsIgnoreCase("Você está em: Programa > Visualizar Programa > Editar Programa")) {
			validar();
		}

		LogOut.logOut(driver);

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

	private void editar() {
		driver.findElement(By.id("btnEditar1")).click();

		driver.findElement(By.id("nome")).clear();
		driver.findElement(By.id("nome")).sendKeys("TeesteSD");

		driver.findElement(By.id("blocoFinanciamento_chosen")).click();
		driver.findElement(By.xpath("//*[@id='blocoFinanciamento_chosen']/div/div/input")).sendKeys("Atenção Básica");
		driver.findElement(By.xpath("//*[@id='blocoFinanciamento_chosen']/div/div/input")).sendKeys(Keys.TAB);
		
		driver.findElement(By.id("subsecretaria_chosen")).click();
		driver.findElement(By.xpath("//*[@id='subsecretaria_chosen']/div/div/input")).sendKeys("Subsecretaria de BH");
		driver.findElement(By.xpath("//*[@id='subsecretaria_chosen']/div/div/input")).sendKeys(Keys.TAB);

		driver.findElement(By.id("descricao")).clear();
		driver.findElement(By.id("descricao")).sendKeys("TESTE TESTE TESTE ");

		driver.findElement(By.id("btnSalvar")).click();
	}

	private void validar() throws TesteAutomatizadoException {
		if(StringUtils.isBlank(driver.findElement(By.id("nome")).getAttribute("value"))){
			throw new TesteAutomatizadoException(EnumMensagens.VALIDACAO_NOME, this.getClass());
		} else if(driver.findElement(By.id("subsecretaria_chosen")).getText()
				.equalsIgnoreCase("Subsecretaria")){
			throw new TesteAutomatizadoException(EnumMensagens.SUBSECRETARIA_EM_BRANCO, this.getClass());
		}else if(driver.findElement(By.id("blocoFinanciamento_chosen")).getText()
				.equalsIgnoreCase("Bloco de Financiamento")){
			throw new TesteAutomatizadoException(EnumMensagens.BLOCO_EM_BRANCO, this.getClass());
		}else if(StringUtils.isBlank(driver.findElement(By.id("descricao")).getAttribute("value"))){
			throw new TesteAutomatizadoException(EnumMensagens.DESCRICAO_EM_BRANCO, this.getClass());
		}// else  throw new TesteAutomatizadoException(EnumMensagens.PROGRAMA_JA_CADASTRADO, this.getClass());
	}	
}
