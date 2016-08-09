package br.com.marph.geicom.funcionalidade.resolucao;

import java.awt.AWTException;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAbaModeloXBeneficiario {

	private WebDriver driver;

	public CadastroAbaModeloXBeneficiario(WebDriver driver) {
		this.driver = driver;
	}

	public void associarModeloBeneficiario() throws AWTException, InterruptedException {

		Thread.sleep(6000);

		WebElement importarPlanilha = driver.findElement(By.id("buttonImportarPlanilha"));
		importarPlanilha.click();

		WebElement modeloIndicador = driver.findElement(By.xpath(".//*[@id='modeloIndicadorImportar_chosen']/a/span"));
		modeloIndicador.click();

		WebElement selecionarModelo = driver
				.findElement(By.xpath(".//*[@id='modeloIndicadorImportar_chosen']/div/div/input"));
		selecionarModelo.click();
		selecionarModelo.sendKeys("Primeiro");
		selecionarModelo.sendKeys(Keys.ENTER);

		File planilha = new File("./data/Geicom/modeloBeneficiarioExport.xlsx");

		// TODO substituir por um Assert
		if (planilha.exists()) {
			WebElement selecionarPlanilha = driver.findElement(By.id("uploadBeneficiariosContemplados"));
			selecionarPlanilha.sendKeys(planilha.getAbsolutePath());
		} else {
			System.out.println("Arquivo não encontrado!");
		}

		WebElement importar = driver.findElement(By.id("buttonImportar"));
		importar.click();
		Thread.sleep(8000);
		
		WebElement proximo = driver.findElement(By.id("btnProximo"));
		proximo.click();

	}
}
