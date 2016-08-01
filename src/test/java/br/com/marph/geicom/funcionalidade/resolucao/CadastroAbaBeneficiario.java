package br.com.marph.geicom.funcionalidade.resolucao;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.util.AcessoUtils;

public class CadastroAbaBeneficiario {

	private WebDriver driver;

	public CadastroAbaBeneficiario(WebDriver driver) {
		this.driver = driver;
	}

	public void abaBeneficiarios() throws AWTException, InterruptedException {

		AcessoUtils.idClick(driver, "buttonImportarPlanilha", "uploadBeneficiariosContemplados");
		// objeto que guarda na memória (ctrl+c) o caminho
		// C:\\GEICOM\\beneficiarioExport
		StringSelection ss = new StringSelection("C:\\GEICOM\\beneficiarioExport");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// comandos robot para selecionar na máquina o arquivo
		// beneficiarioExport
		Robot robot = new Robot();
		// Press pressiona a tecla passada por parâmetro
		robot.keyPress(KeyEvent.VK_ENTER);
		// Release solta a tecla passada por parâmetro
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		//clicando na página, para selecionar o botão Importar - perda de foco
		driver.findElement(By.xpath("html/body")).click();
		Thread.sleep(5000);

		WebElement botaoImportar = driver.findElement(By.id("buttonImportar"));
		botaoImportar.click();
		Thread.sleep(8000);

		WebElement proximo = driver.findElement(By.id("btnProximo"));
		proximo.click();

	}
}
