package br.com.marph.geicom.funcionalidade.resolucaoPage;

import java.awt.AWTException;
import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.enums.EnumMensagemLog;
import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroAbaBeneficiarioP {

	private static final String BTN_PROXIMO = "btnProximo";
	private static final String BTN_IMPORTAR = "buttonImportar";
	 private static final String SELECIONAR_ARQUIVO = "uploadBeneficiariosContemplados";
	private static final String BTN_IMPORTAR_PLANILHA = "buttonImportarPlanilha";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;

	// contrutor
	public CadastroAbaBeneficiarioP(WebDriver driver) {
		this.driver = driver;
	}

	public void abaBeneficiarios() throws AWTException, InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, BTN_IMPORTAR_PLANILHA);

		// caminho onde está a planilha para importação - este caminho é da
		// pasta data no projeto TesteAutomatizado aqui no eclipse
		File planilha = new File("./data/Geicom/beneficiarioExport.xlsx");

		// TODO substituir por um Assert
		// Verificação se a planilha está na pasta
		if (planilha.exists()) {
			WebElement selecionarArquivo = driver.findElement(By.id(SELECIONAR_ARQUIVO));
			selecionarArquivo.sendKeys(planilha.getAbsolutePath());

		} else {
			Assert.fail(EnumMensagemLog.ARQUIVO_NÃO_ENCONTRADO.getMensagem());
		}

		seleniumUtil.clickElementId(driver, BTN_IMPORTAR);
		Thread.sleep(8000);

		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

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
