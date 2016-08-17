package br.com.marph.geicom.funcionalidade.resolucao;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroAbaImportarParcelas {

	private static final String BTN_PROXIMO = "btnProximo";
	private static final String CONFIRMACAO_MSG = ".//*[@class='jconfirm-box']/div[4]/button";
	private static final String BTN_IMPORTAR = "buttonImportar";
	private static final String PESQUISA_MODELO = ".//*[@id='modeloPagamentoImportarPlanilha_chosen']/div/div/input";
	private static final String MODELO_PAGAMENTO = ".//*[@id='modeloPagamentoImportarPlanilha_chosen']/a/span";
	private static final String BTN_IMPORTAR_PLANILHA = "buttonImportarPlanilha";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String nomeModelo = "Primeiro";

	public CadastroAbaImportarParcelas(WebDriver driver) {
		this.driver = driver;
	}

	public void importarParcelas() throws InterruptedException {

		// CÓDIGO PARA IMPORTAÇÃO DA PLANILHA:

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, BTN_IMPORTAR_PLANILHA);

		seleniumUtil.clickElementXpath(driver, MODELO_PAGAMENTO);

		seleniumUtil.clickElementXpath(driver, PESQUISA_MODELO);
		seleniumUtil.sendKeysXpath(driver, PESQUISA_MODELO, nomeModelo);
		driver.findElement(By.xpath(PESQUISA_MODELO)).sendKeys(Keys.ENTER);

		File planilha = new File("./data/Geicom/importacaoParcelasExport.xlsx");

		if (planilha.exists()) {
			WebElement selecionarPlanilha = driver.findElement(By.id("uploadValorParcelas"));
			selecionarPlanilha.sendKeys(planilha.getAbsolutePath());
		} else {
			System.out.println("Arquivo não encontrado!!");
		}

		seleniumUtil.clickElementId(driver, BTN_IMPORTAR);

		// driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/div/div")).click();
		seleniumUtil.clickElementXpath(driver, CONFIRMACAO_MSG);
		Thread.sleep(8000);

		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

	}
}
