package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAbaIndicXConograma {

	private WebDriver driver;
	
	public CadastroAbaIndicXConograma(WebDriver driver){
		this.driver = driver;
	}
	
	public void associarIndicadoresCronograma() throws InterruptedException{
		
		WebElement editar = driver.findElement(By.xpath(".//*[@class='panel-heading']/ul/li[3]/a"));
		editar.click();
		
		WebElement expandirGridModelo = driver.findElement(By.xpath(".//*[@class='chosen-container chosen-container-single']/a/span"));
		expandirGridModelo.click();
		
		WebElement selecionarModelo = driver.findElement(By.xpath("//*[@class='chosen-container chosen-container-single chosen-with-drop chosen-container-active']/div/div/input"));
		selecionarModelo.sendKeys("Primeiro");
		selecionarModelo.sendKeys(Keys.ENTER);
		
		WebElement alterar = driver.findElement(By.xpath(".//*[@class='navbar barraPeriodosMonitoramento top10']/ul[2]/li[3]/a"));
		alterar.click();
		
		WebElement expandirGridParcela = driver.findElement(By.xpath(".//*[@class='chosen-container chosen-container-multi']/ul/li/input"));
		expandirGridParcela.click();
		
		WebElement selecionarParcela = driver.findElement(By.xpath(".//*[@class='chosen-container chosen-container-multi chosen-with-drop chosen-container-active']/ul/li/input"));
		selecionarParcela.sendKeys("01/10/2016");
		selecionarParcela.sendKeys(Keys.ENTER);
		
		WebElement concluir = driver.findElement(By.xpath(".//*[@class='navbar barraPeriodosMonitoramento top10']/ul[2]/li[1]/a"));
		concluir.click();
		
		//focar no grid onde tem o botão Salvar
		WebElement foco = driver.findElement(By.className("panel-heading"));
		foco.click();
		
		WebElement salvar = driver.findElement(By.xpath(".//*[@class='panel-heading']/ul/li[1]/a"));
		salvar.click();
		Thread.sleep(8000);	
		
		WebElement proximo = driver.findElement(By.id("btnProximo"));
		proximo.click();
	}
}
