package br.com.marph.selenium.testesExcell;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.maph.selenium.enums.EnumMensagens;
import br.com.marph.selenium.beneficiario.MenuBeneficiarioTemplate;
import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.LogUtils;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class BeneficiarioPesquisar {
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
	public void teste() throws Exception {
		LogUtils.log(EnumMensagens.INICIO, this.getClass());
		long timestart = System.currentTimeMillis();
		MenuBeneficiarioTemplate.prepararAcessoBaseLegal(driver);

		pesquisa();
		
		validar();
		
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

	protected void validar() throws TesteAutomatizadoException {
		boolean validar = driver.findElement(By.id("toast-container")).isDisplayed();

		if (validar == true) {
			LogUtils.log(EnumMensagens.CADASTRO_BASE_VALIDADO, this.getClass());
		} else {
			throw new TesteAutomatizadoException(EnumMensagens.CADASTRO_BASE_NAO_VALIDADO, this.getClass());
		}
	}

	protected void pesquisa() {
		try {
			WorkbookSettings workbookSettings = new WorkbookSettings();
			workbookSettings.setEncoding("ISO-8859-1");
			Workbook wb = Workbook.getWorkbook(new File("./data/beneficiarioPesquisa.xls"), workbookSettings);
			Sheet sheet = wb.getSheet(0);
			String nome = sheet.getCell(0, 1).getContents();
			String unidade = sheet.getCell(1, 1).getContents();

			if (!"".equals(nome)) {
				WebElement nome1 = driver.findElement(By.id("buscaNome"));
				nome1.sendKeys(nome);
			}

			if (!"".equals(unidade)) {
				WebElement unidadePesquisa = driver.findElement(By.id("unidadeRegional_chosen"));
				unidadePesquisa.click();
				WebElement unidadeDigita = driver
						.findElement(By.xpath("//*[@id='unidadeRegional_chosen']/div/div/input"));
				unidadeDigita.sendKeys(unidade);
				unidadeDigita.sendKeys(Keys.TAB);
			}

			WebElement pesquisar = driver.findElement(By.id("btnPesquisar"));
			pesquisar.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
