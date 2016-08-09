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

	public void importarMetas() {

		WebElement importarPlanilha = driver.findElement(By.id("buttonImportarPlanilha"));
		importarPlanilha.click();

		File planilha = new File("./data/Geicom/importacaoMetasExport.xlsx");

		if (planilha.exists()) {
			WebElement selecionarPlanilha = driver.findElement(By.id("uploadMetasPactuadas"));
			selecionarPlanilha.sendKeys(planilha.getAbsolutePath());
		} else {
			System.out.println("Arquivo não encontrado!!");
		}

	}
}
