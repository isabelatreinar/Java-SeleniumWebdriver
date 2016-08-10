package br.com.marph.geicom.funcionalidade.indicador;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroTelaFormula {

	private WebDriver driver;
	
	
	public CadastroTelaFormula(WebDriver driver) {
		
		this.driver = driver;
	}

	public void cadastrarFormula() throws InterruptedException{
		
		Thread.sleep(3000);
		WebElement adicionar = driver.findElement(By.xpath(".//*[@class='row rowPanel']/div[3]/ul/li/a"));
		adicionar.click();
		
		WebElement salvar = driver.findElement(By.id("btnSalvar1"));
		salvar.click();
		
	}

}
