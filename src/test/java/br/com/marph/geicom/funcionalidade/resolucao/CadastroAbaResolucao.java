package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroAbaResolucao {

	private static final String DESCRICAO = "descricao";
	private static final String RECURSO_FEDERAL = "recursoFederal";
	private static final String RECURSO_ESTADUAL = "recursoEstadual";
	private static final String RECURSO_MUNICIPAL = "recursoMunicipal";
	private static final String BTN_PROXIMO = "btnProximo";
	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String TEMPO_VIGENCIA = "tempoVigencia";
	private static final String SELECIONAR_BASE = "//*[@id='termosBaseLegal_chosen']/div/ul/li[4]";
	private static final String BASE_LEGAL = ".//*[@id='termosBaseLegal_chosen']/ul";
	private static final String NUMERO_RESOLUCAO = ".//*[@id='baseLegal_chosen']/a";
	private static final String PROGRAMA = ".//*[@id='programa_chosen']/a";
	private static final String BTN_NOVA_RESOLUCAO = "btnNovaResolucao";

	private WebDriver driver;
	SeleniumUtil seleniumUtil;
	private String nomePrograma = "Samu";
	private String numeroResolucao = "1235";
	private String tempoVigencia = "12";
	private String descr = "Teste";

	public CadastroAbaResolucao(WebDriver driver) {
		this.driver = driver;
	}

	public void abaResolucao() throws InterruptedException {
		
		// instanciando a classe SeleniumUtil
		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, BTN_NOVA_RESOLUCAO);

		// Preencher campo Programa/Outros
		seleniumUtil.clickElementXpath(driver, PROGRAMA);
		seleniumUtil.sendKeysXpath(driver, PROGRAMA, nomePrograma);
		driver.findElement(By.xpath(PROGRAMA)).sendKeys(Keys.TAB);

		// Selecionar Número da Resolução
		seleniumUtil.clickElementXpath(driver, NUMERO_RESOLUCAO);
		seleniumUtil.sendKeysXpath(driver, NUMERO_RESOLUCAO, numeroResolucao);
		driver.findElement(By.xpath(NUMERO_RESOLUCAO)).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		// Selecionar base legal
		seleniumUtil.clickElementXpath(driver, BASE_LEGAL);
		driver.findElement(By.xpath(BASE_LEGAL)).sendKeys(Keys.ENTER);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_BASE);
		driver.findElement(By.xpath(BASE_LEGAL)).sendKeys(Keys.TAB);

		// Preencher Tempo de Vigência
		seleniumUtil.clickElementId(driver, TEMPO_VIGENCIA);
		seleniumUtil.sendKeysId(driver, TEMPO_VIGENCIA, tempoVigencia);

		// declarando variável do tipo WebElement recebendo os elementos, para
		// fazer a comparação do if se o elemento está desabilitado (sintaxe:
		// !elemento.isEnable)
		// Se o recurso municipal estiver habilitado todos os outros campos
		// estarão, por isso criei um WebElement apenas para o campo Recurso
		// Municipal.
		WebElement recursoMun = driver.findElement(By.id(RECURSO_MUNICIPAL));

		// Verifica se campos de Recursos estão habilitados
		if (recursoMun.isEnabled()) {
			seleniumUtil.clickElementId(driver, RECURSO_MUNICIPAL);
			String recMunicipal = "120000";
			seleniumUtil.sendKeysId(driver, RECURSO_MUNICIPAL, recMunicipal);

			seleniumUtil.clickElementId(driver, RECURSO_ESTADUAL);
			String recEstadual = "140000";
			seleniumUtil.sendKeysId(driver, RECURSO_ESTADUAL, recEstadual);

			seleniumUtil.clickElementId(driver, RECURSO_FEDERAL);
			String recFederal = "150000";
			seleniumUtil.sendKeysId(driver, RECURSO_FEDERAL, recFederal);

		}

		// Preencher campo descrição
		seleniumUtil.clickElementId(driver, DESCRICAO);
		seleniumUtil.sendKeysId(driver, DESCRICAO, descr);

		seleniumUtil.clickElementId(driver, BTN_SALVAR);
		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

	}
}
