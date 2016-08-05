package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAbaPeriodos {

	private WebDriver driver;
	private String periodos = "1";
	private String period = "1";
	private String dataIni = "01012016";

	public CadastroAbaPeriodos(WebDriver driver) {
		this.driver = driver;
	}

	public void abaPeriodos() throws InterruptedException {

		// WebDriverWait wait = new WebDriverWait(driver,
		// IConstante.Parametro.LONG_WAIT);

		WebElement editar = driver.findElement(By.xpath("//*[@class='panel-heading']/ul/li[3]/a"));
		editar.click();

		WebElement numeroPeriodos = driver.findElement(By.id("numeroPeriodoMonitoramento"));
		numeroPeriodos.clear();
		numeroPeriodos.click();
		numeroPeriodos.sendKeys(periodos);

		WebElement periodicidade = driver.findElement(By.id("periodicidade"));
		periodicidade.click();
		periodicidade.sendKeys(period);

		WebElement dataInicial = driver.findElement(By.name("dataInicial"));
		dataInicial.click();
		dataInicial.clear();
		dataInicial.sendKeys(dataIni);

		WebElement atualizar = driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[1]/div[4]/a"));
		atualizar.click();
		Thread.sleep(3000);

		// focar no grid onde tem o botão Salvar
		WebElement foco = driver.findElement(By.className("panel-heading"));
		foco.click();

		WebElement salvar = driver.findElement(By.xpath("//*[@class='panel-heading']/ul/li[1]/a"));
		salvar.click();
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnProximo")));

		WebElement proximo = driver.findElement(By.id("btnProximo"));
		proximo.click();
	}
}
