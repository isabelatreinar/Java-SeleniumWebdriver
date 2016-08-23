package br.com.marph.geicom.funcionalidade.resolucaoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PesquisaTermoFormalizacaoP {

	private static final String SELECIONAR_REGISTRO_LISTAGEM = ".//*[@class='dataGrid']/tbody/tr/td[1]";
	private static final String BTN_PESQUISAR = ".//*[@id='filtroPesquisa']/div/button";
	private static final String FILTRO_PROGRAMA = ".//*[@id='filtroPesquisa']/table/tbody/tr[4]/td[2]/select";
	private static final String FILTRO_NUMERO = ".//*[@id='filtroPesquisa']/table/tbody/tr[2]/td[2]/input";

	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String opcaoNumero = "1235";
	private final String opcaoPrograma = "Samu";

	public PesquisaTermoFormalizacaoP(WebDriver driver) {
		this.driver = driver;

	}

	public void pesquisarResolucao() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementXpath(driver, FILTRO_NUMERO);
		seleniumUtil.sendKeysXpath(driver, FILTRO_NUMERO, opcaoNumero);

		seleniumUtil.clickElementXpath(driver, FILTRO_PROGRAMA);
		seleniumUtil.sendKeysXpath(driver, FILTRO_PROGRAMA, opcaoPrograma);
		driver.findElement(By.xpath(FILTRO_PROGRAMA)).sendKeys(Keys.ENTER);

		seleniumUtil.clickElementXpath(driver, BTN_PESQUISAR);
		Thread.sleep(1000);

		seleniumUtil.clickElementXpath(driver, SELECIONAR_REGISTRO_LISTAGEM);

	}

}
