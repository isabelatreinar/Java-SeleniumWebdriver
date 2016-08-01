package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.marph.geicom.util.IConstante;

public class CadastroAbaPeriodos {

	private WebDriver driver;

	public CadastroAbaPeriodos(WebDriver driver) {
		this.driver = driver;
	}

	public void abaPeriodos() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, IConstante.Parametro.DEFAULT_WAIT);
		
		WebElement editar = driver.findElement(By.xpath("//*[@class='panel-heading']/ul/li[3]/a"));
		editar.click();

		WebElement numeroPeriodos = driver.findElement(By.id("numeroPeriodoMonitoramento"));
		numeroPeriodos.clear();
		numeroPeriodos.click();
		numeroPeriodos.sendKeys("1");

		WebElement periodicidade = driver.findElement(By.id("periodicidade"));
		periodicidade.click();
		periodicidade.sendKeys("1");

		WebElement dataInicial = driver.findElement(By.name("dataInicial"));
		dataInicial.click();
		dataInicial.clear();
		dataInicial.sendKeys("01012015");

		WebElement atualizar = driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[1]/div[4]/a"));
		atualizar.click();
		Thread.sleep(3000);
	

		//focar no grid onde tem o botão Salvar
		WebElement foco = driver.findElement(By.className("panel-heading"));
		foco.click();

		WebElement salvar = driver.findElement(By.xpath("//*[@class='panel-heading']/ul/li[1]/a"));
		salvar.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnProximo")));
		
		WebElement proximo = driver.findElement(By.id("btnProximo"));
		proximo.click();
	}
}
