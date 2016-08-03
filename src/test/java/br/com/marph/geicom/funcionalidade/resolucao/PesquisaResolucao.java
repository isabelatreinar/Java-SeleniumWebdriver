package br.com.marph.geicom.funcionalidade.resolucao;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PesquisaResolucao {

	private WebDriver driver;
	String numeroResolucao = "1235";

	public PesquisaResolucao(WebDriver driver) {
		this.driver = driver;
	}

	public void parametrosPesquisa() {

		WebElement resolucao = driver.findElement(By.id("numero"));
		resolucao.click();
		resolucao.sendKeys(numeroResolucao);

		WebElement botaoPesquisar = driver.findElement(By.id("btnPesquisar"));
		botaoPesquisar.click();

		assertEquals(numeroResolucao, driver.findElement(By.xpath(".//*[@id='rowId459']/td[1]")).getText());

		WebElement selecionarResolucao =driver.findElement(By.xpath(".//*[@id='rowId459']/td[1]"));
		selecionarResolucao.click();
		 
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

}
