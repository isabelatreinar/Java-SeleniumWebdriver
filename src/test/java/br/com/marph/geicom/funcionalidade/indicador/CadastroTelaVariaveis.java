package br.com.marph.geicom.funcionalidade.indicador;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroTelaVariaveis {

	private WebDriver driver;
	private String nome = "Taxa";
	private String descr = "Taxa de Adesao";

	public CadastroTelaVariaveis(WebDriver driver) {

		this.driver = driver;
	}
	
	public void cadastrarVariaveis(){
		
		WebElement criarVariavel = driver.findElement(By.id("criar"));
		criarVariavel.click();
		
		WebElement nomeVariavel = driver.findElement(By.xpath(".//*[@class='form-control-tit _nome']"));
		nomeVariavel.click();
		nomeVariavel.sendKeys(nome);
		
		WebElement descricao = driver.findElement(By.name("descricao"));
		descricao.click();
		descricao.sendKeys(descr);
		
		WebElement salvar = driver.findElement(By.xpath(".//*[@class='_salvarVariavel']"));
		salvar.click();
		
		//Clicar no botão Avançar
		WebElement avancar = driver.findElement(By.id("btnSalvar1"));
		avancar.click();
		
	}

}
