package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAbaCronograma {

	private WebDriver driver;

	public CadastroAbaCronograma(WebDriver driver) {
		this.driver = driver;
	}
	
	public void abaCronograma(){
		
		WebElement criarCronograma = driver.findElement(By.id("criarCronograma"));
		criarCronograma.click();
		
		WebElement nomeModelo = driver.findElement(By.xpath(".//*[@id='accordion']/div/div[1]/span/input"));
		nomeModelo.click();
		nomeModelo.sendKeys("Primeiro Cronograma");
		
		WebElement numeroParcelas = driver.findElement(By.id("numeroParcelas"));
		numeroParcelas.click();
		numeroParcelas.sendKeys("1");
		
		WebElement periodicidade = driver.findElement(By.id("periodicidade"));
		periodicidade.click();
		periodicidade.sendKeys("1");
		
		WebElement dataInicial = driver.findElement(By.xpath("//*[@id='dataInicial_maindiv']/div/input"));
		dataInicial.click();
		dataInicial.clear();
		dataInicial.sendKeys("01102016");
		
		WebElement atualizar = driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[2]/div[4]/a"));
		atualizar.click();
		
	}
}
