package br.com.marph.geicom.funcionalidade.resolucao;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.Menus;


public class CadastrarResolucao {

	private WebDriver driver;

	@Before
	public void startUp() {
		driver = new FirefoxDriver();
	}

	/*
	 * @After public void driverClose(){ driver.quit(); }
	 */

	@Test
	public void abreMenu() throws AWTException {

		AcessoUtils.acessarUrl(driver);

		AcessoUtils.acessarSistema(driver);

		Menus.menuResolucao(driver);

		cadastrarResolucao();
		cadastrarBeneficiarios();
	}

	private void cadastrarResolucao() {


		// Preencher campo Programa/Outros
		driver.findElement(By.id("btnNovaResolucao")).click();
		driver.findElement(By.xpath(".//*[@id='programa_chosen']/a")).click();
		driver.findElement(By.xpath(".//*[@id='programa_chosen']/a")).sendKeys("Samu");
		driver.findElement(By.xpath(".//*[@id='programa_chosen']/a")).sendKeys(Keys.TAB);

		// Selecionar Número da Resolução
		driver.findElement(By.xpath(".//*[@id='baseLegal_chosen']/a")).click();
		driver.findElement(By.xpath(".//*[@id='baseLegal_chosen']/a")).sendKeys("1235");
		driver.findElement(By.xpath(".//*[@id='baseLegal_chosen']/a")).sendKeys(Keys.TAB);

		// Selecionar Base Legal

		driver.findElement(By.xpath(".//*[@id='termosBaseLegal_chosen']/ul")).click();
		driver.findElement(By.xpath(".//*[@id='termosBaseLegal_chosen']/ul")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='termosBaseLegal_chosen']/div/ul/li[4]")).click();
		driver.findElement(By.xpath(".//*[@id='termosBaseLegal_chosen']/ul")).sendKeys(Keys.TAB);

		// Preencher Tempo de Vigência
		WebElement vigencia = driver.findElement(By.id("tempoVigencia"));
		vigencia.sendKeys("12");

		// Verifica se campos de Recursos estão habilitados
		if (!driver.findElement(By.id("recursoMunicipal")).isEnabled()) {
			driver.findElement(By.id("recursoMunicipal")).click();
			driver.findElement(By.id("recursoMunicipal")).sendKeys("120000");

			driver.findElement(By.id("recursoEstadual")).click();
			driver.findElement(By.id("recursoEstadual")).sendKeys("140000");

			driver.findElement(By.id("recursoFederal")).click();
			driver.findElement(By.id("recursoFederal")).sendKeys("150000");
		}

		driver.findElement(By.id("descricao")).click();
		WebElement descricao = driver.findElement(By.id("descricao"));
		descricao.sendKeys("Testeeeee");

		AcessoUtils.idClick(driver, "btnSalvar1", "btnProximo");

	}

	public void cadastrarBeneficiarios() throws AWTException {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(2, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		driver.findElement(By.id("buttonImportarPlanilha")).click();
		driver.findElement(By.id("uploadBeneficiariosContemplados")).click();

		// objeto que guarda na memória (ctrl+c) o caminho
		// C:\\GEICOM\\beneficiarioExport
		StringSelection ss = new StringSelection("C:\\GEICOM\\beneficiarioExport");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// comandos robot para selecionar na máquina o arquivo
		// beneficiarioExport
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// espera até 2 segundos até encontrar o elemento na página
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("buttonImportar")));
		
		//TODO
		driver.findElement(By.id("buttonImportar")).click();

	}

}
