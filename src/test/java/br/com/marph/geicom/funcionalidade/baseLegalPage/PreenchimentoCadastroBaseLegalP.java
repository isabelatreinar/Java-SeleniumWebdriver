package br.com.marph.geicom.funcionalidade.baseLegalPage;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.marph.geicom.funcionalidade.tipoBaseLegalPage.PreenchimentoCadastroTipoBaseP;
import br.com.marph.geicom.util.SeleniumUtil;

public class PreenchimentoCadastroBaseLegalP {
	

	// elementos declarados como constantes pq o valor não muda
	private static final String DATA_PUBLICACAO_VISUALIZACAO = "dataPublicacao";
	private static final String NUMERO_VISUALIZACAO = "numero";
	private static final String TIPO_VISUALIZACAO = "tipo";
	private static final String BOTAO_SALVAR = "btnSalvar1";
	private static final String SELECIONAR_ARQUIVO = "textoPublicado_span_button_progress_bar";
	private static final String SELECIONAR_ANO_VIGENCIA = ".//*[@id='dataVigencia_chosen']/div/div/input";
	private static final String ANO_VIGENCIA = ".//*[@id='dataVigencia_chosen']/a";
	private static final String DATA_PUBLICACAO = DATA_PUBLICACAO_VISUALIZACAO;
	private static final String NUMERO_BASE = NUMERO_VISUALIZACAO;
	private static final String SELECIONAR_TIPO_BASE = ".//*[@id='tipoBaseLegal_chosen']/div/div/input";
	private static final String COMBO_TIPO = ".//*[@id='tipoBaseLegal_chosen']/a";
	private static final String BTN_CADASTRAR_NOVA_BASE = "btnNovaBaseLegal";

	// Variáveis que são os valores que serão inseridos nos campos (constantes)
	SeleniumUtil seleniumUtil;
	private WebDriver driver;
	private final String numeroBase = "1235";
	private final String anoVig = "2016";
	private final String dtPublic = "01012016";
	

	//construtor
	public PreenchimentoCadastroBaseLegalP(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherCadastro() throws InterruptedException, AWTException {

		seleniumUtil = SeleniumUtil.getInstance();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		seleniumUtil.clickElementId(driver, BTN_CADASTRAR_NOVA_BASE);

		seleniumUtil.clickElementXpath(driver, COMBO_TIPO);

		// instanciar a classe PreenchimentoCadastroTipoBase para utilizar
		// oatributo do nome do tipo de base legal
		PreenchimentoCadastroTipoBaseP tipoBaseLegal = new PreenchimentoCadastroTipoBaseP(driver);

		seleniumUtil.clickElementXpath(driver, SELECIONAR_TIPO_BASE);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_TIPO_BASE, tipoBaseLegal.nomeTipo);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECIONAR_TIPO_BASE)));
		driver.findElement(By.xpath(SELECIONAR_TIPO_BASE)).sendKeys(Keys.ENTER);

		seleniumUtil.clickElementId(driver, NUMERO_BASE);
		seleniumUtil.sendKeysId(driver, NUMERO_BASE, numeroBase);

		seleniumUtil.clickElementId(driver, DATA_PUBLICACAO);
		driver.findElement(By.id(DATA_PUBLICACAO)).clear();
		seleniumUtil.sendKeysId(driver, DATA_PUBLICACAO, dtPublic);

		// selecionar campo de data de vigência
		seleniumUtil.clickElementXpath(driver, ANO_VIGENCIA);
		// selecionar ano de vigência
		seleniumUtil.clickElementXpath(driver, SELECIONAR_ANO_VIGENCIA);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_ANO_VIGENCIA, anoVig);
		driver.findElement(By.xpath(SELECIONAR_ANO_VIGENCIA)).sendKeys(Keys.ENTER);

		// File planilha = new File("./data/Geicom/BaseLegal.pdf");

		// WebElement selecionarArquivo =
		// driver.findElement(By.id("textoPublicado_maindiv"));
		// selecionarArquivo.sendKeys(planilha.getAbsolutePath());
		//
		seleniumUtil.clickElementId(driver, SELECIONAR_ARQUIVO);

		// objeto que guarda na memória (ctrl+c) o caminho C:\\GEICOM\\BaseLegal
		StringSelection ss = new StringSelection("C:\\GEICOM\\BaseLegal");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// comandos robot para selecionar na máquina o arquivo
		Robot robot = new Robot();
		// Press pressiona a tecla passada por parâmetro
		robot.keyPress(KeyEvent.VK_ENTER);
		// Release solta a tecla passada por parâmetro
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		seleniumUtil.clickElementId(driver, BOTAO_SALVAR);

		assertEquals(tipoBaseLegal.nomeTipo, driver.findElement(By.id(TIPO_VISUALIZACAO)).getText());
		assertEquals(numeroBase, driver.findElement(By.id(NUMERO_VISUALIZACAO)).getText());
	}

}
