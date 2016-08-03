package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAbaIndicadores {

	private WebDriver driver;
	private String modelo = "Primeiro";
	private String nomeIndic = "dias";
	private String ptcorte = "50000";
	private String pesoInd = "10000";

	public CadastroAbaIndicadores(WebDriver driver) {

		this.driver = driver;
	}

	public void abaIndicadores() throws InterruptedException {

		/*
		 * if(driver.findElement(By.id("mensagemNaoPrestacaoMetas")).getText().
		 * equalsIgnoreCase("Não é necessário inserir informações nesta aba.")){
		 * 
		 * }
		 */

		// driver.findElement(By.xpath(".//*[@id='divBotoesAtalho']/ul")).click();

		WebElement criarModelo = driver.findElement(By.id("criar"));
		criarModelo.click();

		WebElement nomeModelo = driver.findElement(By.id("nome"));
		nomeModelo.click();
		nomeModelo.sendKeys(modelo);

		WebElement adcIndFinalistico = driver.findElement(By.xpath(".//*[@id='collapseNovo']/div/ul/li[1]/a"));
		adcIndFinalistico.click();

		WebElement nomeIndicador = driver.findElement(By.xpath("//*[@data-label-field='nomeIndicador']"));
		nomeIndicador.sendKeys(nomeIndic);

		WebElement selecionarIndicador = driver.findElement(By.xpath(".//*[@id='ui-id-2']"));
		selecionarIndicador.click();

		WebElement pontoCorte = driver.findElement(By.xpath(".//*[@id='tabelaIndicadoresNovo']/div[2]/div[3]/input"));
		pontoCorte.sendKeys(ptcorte);

		WebElement peso = driver.findElement(By.xpath(".//*[@id='tabelaIndicadoresNovo']/div[2]/div[4]/input"));
		peso.sendKeys(pesoInd);

		WebElement salvarIndicador = driver.findElement(By.xpath(".//*[@id='headingNovo']/ul/li[1]/a"));
		salvarIndicador.click();
		Thread.sleep(8000);

		WebElement proximo = driver.findElement(By.id("btnProximo"));
		proximo.click();

	}
}
