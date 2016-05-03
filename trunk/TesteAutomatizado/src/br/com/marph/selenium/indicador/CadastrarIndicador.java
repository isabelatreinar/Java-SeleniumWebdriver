package br.com.marph.selenium.indicador;

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
import br.com.marph.selenium.enums.EnumMensagensLog;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.LogOut;
import br.com.marph.selenium.utils.LogUtils;

public class CadastrarIndicador {
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

		MenuIndicadorTemplate.prepararAcessoIndicador(driver);

		cadastro();

		if (driver.findElement(By.xpath("//ol[@class='breadcrumb']")).getText()
				.equalsIgnoreCase("Você está em: Indicador > Novo Indicador")) {
			validarCadastro();
		}

		variavel();

		if (driver.findElement(By.xpath("//ol[@class='breadcrumb']")).getText()
				.equalsIgnoreCase("Você está em: Indicador > Novo Indicador > Nova Variável")) {
			validarVariavel();
		}

		formula();

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

	public void cadastro() {

		driver.findElement(By.id("btnNovoIndicador")).click();

		// tipo de indicador
		driver.findElement(By.id("tipoIndicador_chosen")).click();
		driver.findElement(By.xpath("//*[@id='tipoIndicador_chosen']/div/div/input")).sendKeys("Finalístico");
		driver.findElement(By.xpath("//*[@id='tipoIndicador_chosen']/div/div/input")).sendKeys(Keys.TAB);

		// tipo de fonte
		driver.findElement(By.id("tipoFonte_chosen")).click();
		driver.findElement(By.xpath("//*[@id='tipoFonte_chosen']/div/div/input")).sendKeys("Oficial");
		driver.findElement(By.xpath("//*[@id='tipoFonte_chosen']/div/div/input")).sendKeys(Keys.TAB);

		// polaridade
		driver.findElement(By.id("polaridade_chosen")).click();
		driver.findElement(By.xpath("//*[@id='polaridade_chosen']/div/div/input")).sendKeys("Quanto maior, melhor");
		driver.findElement(By.xpath("//*[@id='polaridade_chosen']/div/div/input")).sendKeys(Keys.TAB);

		// media movel
		driver.findElement(By.id("mesesDaMediaMovel")).sendKeys("12");

		// meses de defasagem
		driver.findElement(By.id("mesesDeDefasagem")).sendKeys("21");

		// nome do indicador
		driver.findElement(By.id("nomeIndicador")).sendKeys("Indicador3");

		// nome da fonte
		driver.findElement(By.id("nomeFonte")).sendKeys("marph");

		// programa
		driver.findElement(By.id("programa_chosen")).click();
		driver.findElement(By.xpath("//*[@id='programa_chosen']/div/div/input")).sendKeys("Farmácia de minas");
		driver.findElement(By.xpath("//*[@id='programa_chosen']/div/div/input")).sendKeys(Keys.TAB);

		// descrição
		driver.findElement(By.id("descricao")).sendKeys("TESTEEE");

		// avançar
		driver.findElement(By.id("btnSalvar1")).click();
	}

	private void validarCadastro() throws TesteAutomatizadoException {

		if (driver.findElement(By.xpath("//*[@id='tipoIndicador_chosen']/a/span")).getText()
				.equalsIgnoreCase("Tipo de Indicador")) {
			throw new TesteAutomatizadoException(EnumMensagensLog.TIPO_INDICADOR_EM_BRANCO, this.getClass());
		} else if (driver.findElement(By.xpath("//*[@id='tipoFonte_chosen']/a/span")).getText()
				.equalsIgnoreCase("Tipo de Fonte")) {
			throw new TesteAutomatizadoException(EnumMensagensLog.TIPO_DE_FONTE_EM_BRANCO, this.getClass());
		} else if (driver.findElement(By.xpath("//*[@id='polaridade_chosen']/a/span")).getText()
				.equalsIgnoreCase("Polaridade")) {
			throw new TesteAutomatizadoException(EnumMensagensLog.POLARIDADE_EM_BRANCO, this.getClass());
		} else if (StringUtils.isBlank(driver.findElement(By.id("mesesDaMediaMovel")).getAttribute("value"))) {
			throw new TesteAutomatizadoException(EnumMensagensLog.MESES_DA_MEDIA_MOVEL_EM_BRANCO, this.getClass());
		} else if (StringUtils.isBlank(driver.findElement(By.id("mesesDaMediaMovel")).getAttribute("value"))) {
			throw new TesteAutomatizadoException(EnumMensagensLog.MESES_DE_DEFASAGEM_EM_BRANCO, this.getClass());
		} else if (StringUtils.isBlank(driver.findElement(By.id("nomeIndicador")).getAttribute("value"))) {
			throw new TesteAutomatizadoException(EnumMensagensLog.NOME_INDICADOR_EM_BRANCO, this.getClass());
		} else if (StringUtils.isBlank(driver.findElement(By.id("nomeFonte")).getAttribute("value"))) {
			throw new TesteAutomatizadoException(EnumMensagensLog.NOME_DA_FONTE_EM_BRANCO, this.getClass());
		} else if (driver.findElement(By.xpath("//*[@id='programa_chosen']/a/span")).getText()
				.equalsIgnoreCase("Programa")) {
			throw new TesteAutomatizadoException(EnumMensagensLog.PROGRAMA_EM_BRANCO, this.getClass());
		} else if (StringUtils.isBlank(driver.findElement(By.id("descricao")).getAttribute("value"))) {
			throw new TesteAutomatizadoException(EnumMensagensLog.DESCRICAO_EM_BRANCO, this.getClass());
		} else
			throw new TesteAutomatizadoException(EnumMensagensLog.INDICADOR_JA_CADASTRADO, this.getClass());
	}

	public void variavel() {
		// clica no botão criar
		driver.findElement(By.id("criar")).click();

		driver.findElement(By.xpath("//*[@class='panel-heading']/span/input")).sendKeys("testa");

		// Preenche o campo descrição
		driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[2]/div/p/textarea"))
				.sendKeys("huahauhau");

		// clica em salvar
		driver.findElement(By.xpath("//*[@class='panel-heading']/ul/li[1]/a")).click();

		// avança
		driver.findElement(By.id("btnSalvar1")).click();

	}

	public void validarVariavel() throws TesteAutomatizadoException {
		if (StringUtils.isBlank(
				driver.findElement(By.xpath("//*[@class='panel-heading']/span/input")).getAttribute("value"))) {
			throw new TesteAutomatizadoException(EnumMensagensLog.NOME_DO_MODELO_EM_BRANCO, this.getClass());
		} else if (StringUtils.isBlank(
				driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[2]/div/p/textarea"))
						.getAttribute("value"))) {
			throw new TesteAutomatizadoException(EnumMensagensLog.DESCRICAO_EM_BRANCO, this.getClass());
		}
	}

	public void formula() throws InterruptedException {

		Thread.sleep(2000);

		// clica para adicionar
		driver.findElement(By.xpath("//*[@id='heading0']/div[3]/ul/li/a")).click();

		// clica para salvar
		driver.findElement(By.id("btnSalvar1")).click();

		driver.findElement(By.xpath("//*[@id='toast-container']/div/button")).click();

		LogOut.logOut(driver);

	}
}
