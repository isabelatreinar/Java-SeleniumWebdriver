package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroAbaIndicXConograma {

	private static final String BTN_PROXIMO = "btnProximo";
	private static final String BTN_SALVAR = ".//*[@class='panel-heading']/ul/li[1]/a";
	private static final String FOCO_GRID = "panel-heading";
	private static final String BTN_CONCLUIR = ".//*[@class='navbar barraPeriodosMonitoramento top10']/ul[2]/li[1]/a";
	private static final String SELECIONAR_PARCELA = ".//*[@class='chosen-container chosen-container-multi chosen-with-drop chosen-container-active']/ul/li/input";
	private static final String EXPANDIR_GRID_PARCELA = ".//*[@class='chosen-container chosen-container-multi']/ul/li/input";
	private static final String BTN_ALTERAR = ".//*[@class='navbar barraPeriodosMonitoramento top10']/ul[2]/li[3]/a";
	private static final String SELECIONAR_MODELO_INDICADOR = "//*[@class='chosen-container chosen-container-single chosen-with-drop chosen-container-active']/div/div/input";
	private static final String EXPANDIR_GRID = ".//*[@class='chosen-container chosen-container-single']/a/span";
	private static final String BTN_EDITAR = ".//*[@class='panel-heading']/ul/li[3]/a";
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String modeloIndic = "Primeiro";
	private final String dtParcela = "01/10/2016";

	public CadastroAbaIndicXConograma(WebDriver driver) {
		this.driver = driver;
	}

	public void associarIndicadoresCronograma() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementXpath(driver, BTN_EDITAR);

		seleniumUtil.clickElementXpath(driver, EXPANDIR_GRID);

		seleniumUtil.clickElementXpath(driver, SELECIONAR_MODELO_INDICADOR);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_MODELO_INDICADOR, modeloIndic);
		driver.findElement(By.xpath(SELECIONAR_MODELO_INDICADOR)).sendKeys(Keys.ENTER);

		seleniumUtil.clickElementXpath(driver, BTN_ALTERAR);

		seleniumUtil.clickElementXpath(driver, EXPANDIR_GRID_PARCELA);

		seleniumUtil.clickElementXpath(driver, SELECIONAR_PARCELA);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_PARCELA, dtParcela);
		driver.findElement(By.xpath(SELECIONAR_PARCELA)).sendKeys(Keys.ENTER);

		seleniumUtil.clickElementXpath(driver, BTN_CONCLUIR);

		// focar no grid onde tem o botão Salvar
		seleniumUtil.clickElementClassName(driver, FOCO_GRID);

		seleniumUtil.clickElementXpath(driver, BTN_SALVAR);
		Thread.sleep(8000);

		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

	}
}
