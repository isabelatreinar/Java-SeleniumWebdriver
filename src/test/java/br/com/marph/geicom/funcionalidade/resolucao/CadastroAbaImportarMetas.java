package br.com.marph.geicom.funcionalidade.resolucao;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAbaImportarMetas {

	private WebDriver driver;

	public CadastroAbaImportarMetas(WebDriver driver) {
		this.driver = driver;
	}

	public void importarMetas() throws InterruptedException {

		WebElement importarPlanilha = driver.findElement(By.id("buttonImportarPlanilha"));
		importarPlanilha.click();

		File planilha = new File("./data/Geicom/importacaoMetasExport.xlsx");

		if (planilha.exists()) {
			WebElement selecionarPlanilha = driver.findElement(By.id("uploadMetasPactuadas"));
			selecionarPlanilha.sendKeys(planilha.getAbsolutePath());
		} else {
			System.out.println("Arquivo não encontrado!!");
		}

		WebElement importar = driver.findElement(By.id("buttonImportar"));
		importar.click();
		Thread.sleep(5000);

		WebElement proximo = driver.findElement(By.id("btnProximo"));
		proximo.click();

	}
}
