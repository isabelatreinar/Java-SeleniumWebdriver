package br.com.marph.geicom.funcionalidade.resolucao;

import java.awt.AWTException;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAbaBeneficiario {

	private WebDriver driver;

	public CadastroAbaBeneficiario(WebDriver driver) {
		this.driver = driver;
	}

	public void abaBeneficiarios() throws AWTException, InterruptedException {

		WebElement importarPlanilha = driver.findElement(By.id("buttonImportarPlanilha"));
		importarPlanilha.click();

		File planilha = new File("./data/Geicom/beneficiarioExport.xlsx");

		// TODO substituir por um Assert
		if (planilha.exists()) {
			WebElement selecionarArquivo = driver.findElement(By.id("uploadBeneficiariosContemplados"));
			selecionarArquivo.sendKeys(planilha.getAbsolutePath());
		} else {
			System.out.println("Arquivo não encontrado!");
		}

		WebElement botaoImportar = driver.findElement(By.id("buttonImportar"));
		botaoImportar.click();
		Thread.sleep(8000);

		WebElement proximo = driver.findElement(By.id("btnProximo"));
		proximo.click();

		// objeto que guarda na memória (ctrl+c) o caminho
		// C:\\GEICOM\\beneficiarioExport
		// StringSelection ss = new
		// StringSelection("C:\\arquivoselenium\\beneficiarioExport");
		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,
		// null);

		// // comandos robot para selecionar na máquina o arquivo
		// // beneficiarioExport
		// Robot robot = new Robot();
		// // Press pressiona a tecla passada por parâmetro
		// robot.keyPress(KeyEvent.VK_ENTER);
		// // Release solta a tecla passada por parâmetro
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// robot.keyPress(KeyEvent.VK_CONTROL);
		// robot.keyPress(KeyEvent.VK_V);
		// robot.keyRelease(KeyEvent.VK_CONTROL);
		// robot.keyRelease(KeyEvent.VK_V);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);

	}
}
