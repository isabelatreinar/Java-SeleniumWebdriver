package br.com.marph.geicom.funcionalidade.resolucaoPage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PesquisaResolucaoP {

	private static final String FILTRO_SELECIONAR_PROGRAMA = ".//*[@id='programa_chosen']/div/div/input";
	private static final String FILTRO_PROGRAMA = ".//*[@id='programa_chosen']/a";
	private static final String REGISTRO_RESOLUCAO = ".//*[@class='odd']/td[1]";
	private static final String BTN_PESQUISAR = "btnPesquisar";
	private static final String FILTRO_NUMERO = "numero";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String opcaoNumResolucao = "1235";
	private final String opcaoPrograma = "Samu";

	public PesquisaResolucaoP(WebDriver driver) {
		this.driver = driver;
	}

	public void parametrosPesquisa() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, FILTRO_NUMERO);
		seleniumUtil.sendKeysId(driver, FILTRO_NUMERO, opcaoNumResolucao);
		
		seleniumUtil.clickElementXpath(driver, FILTRO_PROGRAMA);
		seleniumUtil.clickElementXpath(driver, FILTRO_SELECIONAR_PROGRAMA);
		seleniumUtil.sendKeysXpath(driver, FILTRO_SELECIONAR_PROGRAMA, opcaoPrograma);
		driver.findElement(By.xpath(FILTRO_SELECIONAR_PROGRAMA)).sendKeys(Keys.ENTER);;

		seleniumUtil.clickElementId(driver, BTN_PESQUISAR);
		Thread.sleep(2000);
		
		assertEquals(opcaoNumResolucao, driver.findElement(By.xpath(REGISTRO_RESOLUCAO)).getText());

		//clica no primeiro registro da listagem
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
