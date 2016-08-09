package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAbaImportarParcelas {

	private WebDriver driver;

	public CadastroAbaImportarParcelas(WebDriver driver) {
		this.driver = driver;
	}

	public void importarParcelas() throws InterruptedException {

		//CÓDIGO PARA IMPORTAÇÃO DA PLANILHA:
		
//		WebElement importarPlanilha = driver.findElement(By.id("buttonImportarPlanilha"));
//		importarPlanilha.click();
//		
//		WebElement modeloPagamento = driver.findElement(By.xpath(".//*[@id='modeloPagamentoImportarPlanilha_chosen']/a/span"));
//		modeloPagamento.click();
//
//		WebElement pesquisaModelo = driver.findElement(By.xpath(".//*[@id='modeloPagamentoImportarPlanilha_chosen']/div/div/input"));
//		pesquisaModelo.click();
//		pesquisaModelo.sendKeys("Primeiro");
//		pesquisaModelo.sendKeys(Keys.ENTER);
//
//		File planilha = new File("./data/Geicom/importacaoParcelasExport.xlsx");
//
//		if (planilha.exists()) {
//			WebElement selecionarPlanilha = driver.findElement(By.id("uploadValorParcelas"));
//			selecionarPlanilha.sendKeys(planilha.getAbsolutePath());
//		} else {
//			System.out.println("Arquivo não encontrado!!");
//		}
//
//		WebElement importar = driver.findElement(By.id("buttonImportar"));
//		importar.click();
//		
//		//driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/div/div")).click();
//		WebElement confirmacaoMensagem = driver.findElement(By.xpath(".//*[@class='jconfirm-box']/div[4]/button"));
//		confirmacaoMensagem.click();
//			
//		Thread.sleep(8000);

		WebElement proximo = driver.findElement(By.id("btnProximo"));
		proximo.click();
		
		
	}
}
