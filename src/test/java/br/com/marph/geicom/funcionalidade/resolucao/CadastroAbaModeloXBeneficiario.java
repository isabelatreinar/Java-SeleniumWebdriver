package br.com.marph.geicom.funcionalidade.resolucao;

import java.awt.AWTException;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroAbaModeloXBeneficiario {

	private static final String BTN_PROXIMO = "btnProximo";
	private static final String BTN_IMPORTAR = "buttonImportar";
	private static final String SELECIONAR_MODEL_INDICADOR = ".//*[@id='modeloIndicadorImportar_chosen']/div/div/input";
	private static final String MODELO_INDICADOR = ".//*[@id='modeloIndicadorImportar_chosen']/a/span";
	private static final String BTN_IMPORTAR_PLANILHA = "buttonImportarPlanilha";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String modeloIndic = "Primeiro";

	public CadastroAbaModeloXBeneficiario(WebDriver driver) {
		this.driver = driver;
	}

	public void associarModeloBeneficiario() throws AWTException, InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		Thread.sleep(6000);

		seleniumUtil.clickElementId(driver, BTN_IMPORTAR_PLANILHA);

		seleniumUtil.clickElementXpath(driver, MODELO_INDICADOR);

		seleniumUtil.clickElementXpath(driver, SELECIONAR_MODEL_INDICADOR);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_MODEL_INDICADOR, modeloIndic);
		driver.findElement(By.xpath(SELECIONAR_MODEL_INDICADOR)).sendKeys(Keys.ENTER);

		File planilha = new File("./data/Geicom/modeloBeneficiarioExport.xlsx");

		// TODO substituir por um Assert
		if (planilha.exists()) {
			WebElement selecionarPlanilha = driver.findElement(By.id("uploadBeneficiariosContemplados"));
			selecionarPlanilha.sendKeys(planilha.getAbsolutePath());
		} else {
			System.out.println("Arquivo não encontrado!");
		}

		seleniumUtil.clickElementId(driver, BTN_IMPORTAR);
		Thread.sleep(8000);

		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

	}
}
