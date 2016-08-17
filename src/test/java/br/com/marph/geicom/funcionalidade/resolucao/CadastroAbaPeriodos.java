package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroAbaPeriodos {

	private static final String BTN_PROXIMO = "btnProximo";
	private static final String SALVAR = "//*[@class='panel-heading']/ul/li[1]/a";
	private static final String FOCO_GRID = "panel-heading";
	private static final String ATUALIZAR = "//*[@class='panel-collapse collapse in']/div/div[1]/div[4]/a";
	private static final String DATA_INICIAL = "dataInicial";
	private static final String PERIODICIDADE = "periodicidade";
	private static final String NUMERO_PERIODOS = "numeroPeriodoMonitoramento";
	private static final String BTN_EDITAR = "//*[@class='panel-heading']/ul/li[3]/a";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private String periodos = "1";
	private String period = "1";
	private String dataIni = "01012016";

	public CadastroAbaPeriodos(WebDriver driver) {
		this.driver = driver;
	}

	public void abaPeriodos() throws InterruptedException {

		// WebDriverWait wait = new WebDriverWait(driver,
		// IConstante.Parametro.LONG_WAIT);

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementXpath(driver, BTN_EDITAR);

		driver.findElement(By.id(NUMERO_PERIODOS)).clear();
		seleniumUtil.clickElementId(driver, NUMERO_PERIODOS);
		seleniumUtil.sendKeysId(driver, NUMERO_PERIODOS, periodos);

		seleniumUtil.clickElementId(driver, PERIODICIDADE);
		seleniumUtil.sendKeysId(driver, PERIODICIDADE, period);

		seleniumUtil.clickElementName(driver, DATA_INICIAL);
		driver.findElement(By.name(DATA_INICIAL)).clear();
		seleniumUtil.sendKeysName(driver, DATA_INICIAL, dataIni);

		seleniumUtil.clickElementXpath(driver, ATUALIZAR);
		Thread.sleep(3000);

		// focar no grid onde tem o botão Salvar
		seleniumUtil.clickElementClassName(driver, FOCO_GRID);

		seleniumUtil.clickElementXpath(driver, SALVAR);
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnProximo")));

		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

	}
}
