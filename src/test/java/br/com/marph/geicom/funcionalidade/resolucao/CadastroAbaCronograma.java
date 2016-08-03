package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAbaCronograma {

	private WebDriver driver;
	private String modelo = "Primeiro Cronograma";
	private String parcelas = "1";
	private String period = "1";
	private String dataIni = "01102016";
	private String valorParcela = "100000";
	private String percentFixo = "50000";
	private String percentCusteio = "10000";

	public CadastroAbaCronograma(WebDriver driver) {
		this.driver = driver;
	}

	public void abaCronograma() throws InterruptedException {

		WebElement criarCronograma = driver.findElement(By.id("criarCronograma"));
		criarCronograma.click();

		WebElement nomeModelo = driver.findElement(By.xpath(".//*[@id='accordion']/div/div[1]/span/input"));
		nomeModelo.click();
		nomeModelo.sendKeys(modelo);

		WebElement numeroParcelas = driver.findElement(By.id("numeroParcelas"));
		numeroParcelas.click();
		numeroParcelas.sendKeys(parcelas);

		WebElement periodicidade = driver.findElement(By.id("periodicidade"));
		periodicidade.click();
		periodicidade.sendKeys(period);

		WebElement dataInicial = driver.findElement(By.xpath("//*[@id='dataInicial_maindiv']/div/input"));
		dataInicial.click();
		dataInicial.clear();
		dataInicial.sendKeys(dataIni);

		WebElement atualizar = driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[2]/div[4]/a"));
		atualizar.click();
		Thread.sleep(3000);

		WebElement valorPadrao = driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[3]/div[2]/div[3]/div/input"));
		valorPadrao.click();
		valorPadrao.sendKeys(valorParcela);

		WebElement percentualFixo = driver.findElement(By.xpath(".//*[@class='panel-collapse collapse in']/div/div[3]/div[2]/div[4]/div/input"));
		percentualFixo.click();
		percentualFixo.sendKeys(percentFixo);

		WebElement percentualCusteio = driver.findElement(By.xpath(".//*[@class='panel-collapse collapse in']/div/div[3]/div[2]/div[5]/div/input"));
		percentualCusteio.click();
		percentualCusteio.sendKeys(percentCusteio);

	}
}
