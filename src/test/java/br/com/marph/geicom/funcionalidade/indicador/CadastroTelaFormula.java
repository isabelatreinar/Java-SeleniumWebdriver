package br.com.marph.geicom.funcionalidade.indicador;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.util.IConstante;

import static org.junit.Assert.*;

public class CadastroTelaFormula {

	private WebDriver driver;
	private String valorFormula = "*1200";

	public CadastroTelaFormula(WebDriver driver) {

		this.driver = driver;
	}

	public void cadastrarFormula() throws InterruptedException {

		Thread.sleep(3000);
		// adicionar a variável no textarea de formula
		WebElement adicionar = driver.findElement(By.xpath(".//*[@class='row rowPanel']/div[3]/ul/li/a"));
		adicionar.click();

		WebElement preencherFormula = driver.findElement(By.id("formula"));
		preencherFormula.sendKeys(valorFormula);

		WebElement salvar = driver.findElement(By.id("btnSalvar1"));
		salvar.click();

		// instanciar a classe CadastroTelaIndicador para usar a variável 'nome'
		// (nome do indicador) para validação no assertEquals
		CadastroTelaIndicador indicador = new CadastroTelaIndicador(driver);

		// Validação para saber se o cadastro está correto, se o indicador
		// apresentado após o cadastro tem o mesmo nome inserido no cadastro
		assertEquals(indicador.fonte, driver.findElement(By.id("nomeFonte")).getText());
		assertEquals(indicador.nome, driver.findElement(By.id("nomeIndicador")).getText());
		assertEquals(IConstante.parametrosIndicador.PROGRAMA, driver.findElement(By.id("programa")).getText());
		assertEquals(indicador.desc, driver.findElement(By.id("descricao")).getText());

	}

}
