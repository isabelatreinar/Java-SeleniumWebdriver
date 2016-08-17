package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroAbaCronograma {

	private static final String BTN_PROXIMO = "btnProximo";
	private static final String BTN_SALVAR_MODELO = ".//*[@id='accordion']/div/div[1]/ul/li[1]/a";
	private static final String PERCENTUAL_CUSTEIO = ".//*[@class='panel-collapse collapse in']/div/div[3]/div[2]/div[5]/div/input";
	private static final String PERCENTUAL_FIXO = ".//*[@class='panel-collapse collapse in']/div/div[3]/div[2]/div[4]/div/input";
	private static final String VALOR_PADRAO = "//*[@class='panel-collapse collapse in']/div/div[3]/div[2]/div[3]/div/input";
	private static final String BTN_ATUALIZAR = "//*[@class='panel-collapse collapse in']/div/div[2]/div[4]/a";
	private static final String DATA_INICIAL = "//*[@id='dataInicial_maindiv']/div/input";
	private static final String PERIODICIDADE = "periodicidade";
	private static final String NUMERO_PARCELAS = "numeroParcelas";
	private static final String NOME_MODELO = ".//*[@id='accordion']/div/div[1]/span/input";
	private static final String BTN_CADASTRAR_CRONOGRAMA = "criarCronograma";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private String modelo = "Primeiro Cronograma";
	private String parcelas = "1";
	private String period = "1";
	private String dataIni = "01102016";
	private String valorParcela = "100000";
	private String percentFixo = "5000";
	private String percentCusteio = "10000";

	public CadastroAbaCronograma(WebDriver driver) {
		this.driver = driver;
	}

	public void abaCronograma() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, BTN_CADASTRAR_CRONOGRAMA);

		seleniumUtil.clickElementXpath(driver, NOME_MODELO);
		seleniumUtil.sendKeysXpath(driver, NOME_MODELO, modelo);

		seleniumUtil.clickElementId(driver, NUMERO_PARCELAS);
		seleniumUtil.sendKeysId(driver, NUMERO_PARCELAS, parcelas);

		seleniumUtil.clickElementId(driver, PERIODICIDADE);
		seleniumUtil.sendKeysId(driver, PERIODICIDADE, period);

		seleniumUtil.clickElementXpath(driver, DATA_INICIAL);
		driver.findElement(By.xpath(DATA_INICIAL)).clear();
		seleniumUtil.sendKeysXpath(driver, DATA_INICIAL, dataIni);

		seleniumUtil.clickElementXpath(driver, BTN_ATUALIZAR);
		Thread.sleep(3000);

		seleniumUtil.clickElementXpath(driver, VALOR_PADRAO);
		seleniumUtil.sendKeysXpath(driver, VALOR_PADRAO, valorParcela);

		seleniumUtil.clickElementXpath(driver, PERCENTUAL_FIXO);
		seleniumUtil.sendKeysXpath(driver, PERCENTUAL_FIXO, percentFixo);

		seleniumUtil.clickElementXpath(driver, PERCENTUAL_CUSTEIO);
		seleniumUtil.sendKeysXpath(driver, PERCENTUAL_CUSTEIO, percentCusteio);

		seleniumUtil.clickElementXpath(driver, BTN_SALVAR_MODELO);
		Thread.sleep(8000);

		seleniumUtil.clickElementId(driver, BTN_PROXIMO);

	}
}
