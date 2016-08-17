package br.com.marph.geicom.funcionalidade.resolucao;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PesquisaResolucao {

	private static final String REGISTRO_RESOLUCAO = ".//*[@id='rowId337']/td[1]";
	private static final String BTN_PESQUISAR = "btnPesquisar";
	private static final String NUMERO = "numero";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private String numeroResolucao = "1235";

	public PesquisaResolucao(WebDriver driver) {
		this.driver = driver;
	}

	public void parametrosPesquisa() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, NUMERO);
		seleniumUtil.sendKeysId(driver, NUMERO, numeroResolucao);

		seleniumUtil.clickElementId(driver, BTN_PESQUISAR);
		Thread.sleep(2000);
		
		assertEquals(numeroResolucao, driver.findElement(By.xpath(REGISTRO_RESOLUCAO)).getText());

		seleniumUtil.clickElementXpath(driver, REGISTRO_RESOLUCAO);

	}

}

/*
 * @Before public void startUp() { driver = new FirefoxDriver(); }
 * 
 * @Test public void pesquisarResolucao() {
 * 
 * driver.get(IConstante.Url.LOGIN);
 * 
 * AcessoUtils.acessarSistema(driver);
 * 
 * Menus.menuResolucao(driver);
 * 
 * }
 */
