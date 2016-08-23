package br.com.marph.geicom.funcionalidade.indicadorPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroTelaIndicadorP {

	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String PERCENTUAL_MAIOR_CEM = "percentualCumprimentoMaiorCem";
	private static final String OPCAO_MAIOR_CEM = ".//*[@id='percentualMaiorCem_chosen']/div/div/input";
	private static final String CAMPO_PERCENTUAL_MAIOR_CEM = ".//*[@id='percentualMaiorCem_chosen']/a";
	private static final String DESCRICAO = "descricao";
	private static final String SELECIONAR_PROGRAMA = ".//*[@id='programa_chosen']/div/div/input";
	private static final String PROGRAMA = "programa_chosen";
	private static final String NOME_FONTE = "nomeFonte";
	private static final String NOME_INDICADOR = "nomeIndicador";
	private static final String MESES_DE_DEFASAGEM = "mesesDeDefasagem";
	private static final String MESES_DA_MEDIA_MOVEL = "mesesDaMediaMovel";
	private static final String PERCENTUAL_CUMPRIMENTO_MENOR_MELHOR = "percentualCumprimentoQuandoPolaridadeMenorMelhorEValorZero";
	private static final String PERCENTUAL_POLAR_MENOR_MELHOR = ".//*[@id='percentualQuandoPolaridadeMenorMelhorEValorZero_chosen']/div/div/input";
	private static final String PARAMETRO_POLARIDADE_MENOR_MENOR = "percentualQuandoPolaridadeMenorMelhorEValorZero_chosen";
	private static final String SELECIONAR_POLARIDADE = ".//*[@id='polaridade_chosen']/div/div/input";
	private static final String POLARIDADE = "polaridade_chosen";
	private static final String SELECIONAR_TIPO_FONTE = ".//*[@id='tipoFonte_chosen']/div/div/input";
	private static final String TIPO_FONTE = "tipoFonte_chosen";
	private static final String PERCENTUAL_CUMPRIMENTO_INDICADOR_DISPENSADO = "percentualCumprimentoIndicadorDispensado";
	private static final String OPCAO_DISPENSA = ".//*[@id='percentualIndicadorDispensado_chosen']/div/div/input";
	private static final String CAMPO_INDICADOR_DISPENSADO = "percentualIndicadorDispensado_chosen";
	private static final String SELECIONAR_TIPO = ".//*[@id='tipoIndicador_chosen']/div/div/input";
	private static final String TIPO_INDICADOR = "tipoIndicador_chosen";
	private static final String BTN_NOVO_INDICADOR = "btnNovoIndicador";

	public WebDriver driver;
	private SeleniumUtil seleniumUtil;
	public final String medMovel = "12";
	public final String mesesDefasagem = "12";
	public final String nome = "Taxa de Adesao Oficial";
	public final String fonte = "Estadual";
	public final String desc = "Teste";
	public final String opDispensa = "Outro";
	public final String percentDispensa = "8000";
	public final String maiorCem = "Outro";
	public final String percent = "10000";
	public final String opPolaridadeMenor = "Outro";
	public final String percentPolaridadeMenor = "5000";
	public final String tpFonte = "Oficial";
	public final String tipoIndic = "Finalístico";
	public final String tipoPolaridade = "menor";
	public final String nomePrograma = "Samu";

	public CadastroTelaIndicadorP(WebDriver driver) {
		this.driver = driver;
	}

	public void cadastrarTelaIndicador() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, BTN_NOVO_INDICADOR);

		// Tipo Indicador
		seleniumUtil.clickElementId(driver, TIPO_INDICADOR);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_TIPO);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_TIPO, tipoIndic);
		driver.findElement(By.xpath(SELECIONAR_TIPO)).sendKeys(Keys.ENTER);

		// Preenchimento de campos para TIPO DE INDICADOR FINALISTICO - se for
		// processual comentar as linhas de código abaixo até a linha 57
		// Indicador Dispensado?
		seleniumUtil.clickElementId(driver, CAMPO_INDICADOR_DISPENSADO);
		seleniumUtil.clickElementXpath(driver, OPCAO_DISPENSA);
		seleniumUtil.sendKeysXpath(driver, OPCAO_DISPENSA, opDispensa);
		driver.findElement(By.xpath(OPCAO_DISPENSA)).sendKeys(Keys.TAB);

		// Informar o percentual de cumprimento para indicador dispensado
		seleniumUtil.clickElementId(driver, PERCENTUAL_CUMPRIMENTO_INDICADOR_DISPENSADO);
		seleniumUtil.sendKeysId(driver, PERCENTUAL_CUMPRIMENTO_INDICADOR_DISPENSADO, percentDispensa);

		// Tipo Fonte
		seleniumUtil.clickElementId(driver, TIPO_FONTE);

		seleniumUtil.clickElementXpath(driver, SELECIONAR_TIPO_FONTE);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_TIPO_FONTE, tpFonte);
		driver.findElement(By.xpath(SELECIONAR_TIPO_FONTE)).sendKeys(Keys.ENTER);

		// Tipo Polaridade
		seleniumUtil.clickElementId(driver, POLARIDADE);

		seleniumUtil.clickElementXpath(driver, SELECIONAR_POLARIDADE);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_POLARIDADE, tipoPolaridade);
		driver.findElement(By.xpath(SELECIONAR_POLARIDADE)).sendKeys(Keys.ENTER);

		// Preenchimento de campos para polaridade QUANTO MENOR MELHOR, se for
		// Maior Melhor, comentar as linhas de código abaixo, até a linha 92:
		seleniumUtil.clickElementId(driver, PARAMETRO_POLARIDADE_MENOR_MENOR);

		seleniumUtil.clickElementXpath(driver, PERCENTUAL_POLAR_MENOR_MELHOR);
		seleniumUtil.sendKeysXpath(driver, PERCENTUAL_POLAR_MENOR_MELHOR, opPolaridadeMenor);
		driver.findElement(By.xpath(PERCENTUAL_POLAR_MENOR_MELHOR)).sendKeys(Keys.TAB);

		// Informar o percentual de cumprimento para indicador dispensado
		seleniumUtil.clickElementId(driver, PERCENTUAL_CUMPRIMENTO_MENOR_MELHOR);
		seleniumUtil.sendKeysId(driver, PERCENTUAL_CUMPRIMENTO_MENOR_MELHOR, percentPolaridadeMenor);

		// Meses da media movel
		seleniumUtil.clickElementId(driver, MESES_DA_MEDIA_MOVEL);
		seleniumUtil.sendKeysId(driver, MESES_DA_MEDIA_MOVEL, medMovel);

		// Meses de Defasagem
		seleniumUtil.clickElementId(driver, MESES_DE_DEFASAGEM);
		seleniumUtil.sendKeysId(driver, MESES_DE_DEFASAGEM, mesesDefasagem);

		// Nome do Indicador
		seleniumUtil.clickElementId(driver, NOME_INDICADOR);
		seleniumUtil.sendKeysId(driver, NOME_INDICADOR, nome);

		// Fonte
		seleniumUtil.clickElementId(driver, NOME_FONTE);
		seleniumUtil.sendKeysId(driver, NOME_FONTE, fonte);

		// Programa
		seleniumUtil.clickElementId(driver, PROGRAMA);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_PROGRAMA);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_PROGRAMA, nomePrograma);
		driver.findElement(By.xpath(SELECIONAR_PROGRAMA)).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		// Descricao
		seleniumUtil.clickElementId(driver, DESCRICAO);
		seleniumUtil.sendKeysId(driver, DESCRICAO, desc);

		// Percentual de Cumprimento maior que 100%?
		seleniumUtil.clickElementXpath(driver, CAMPO_PERCENTUAL_MAIOR_CEM);
		seleniumUtil.clickElementXpath(driver, OPCAO_MAIOR_CEM);
		seleniumUtil.sendKeysXpath(driver, OPCAO_MAIOR_CEM, maiorCem);
		driver.findElement(By.xpath(OPCAO_MAIOR_CEM)).sendKeys(Keys.TAB);

		// Informar o percentual de cumprimento para indicador maior que 100%
		seleniumUtil.clickElementId(driver, PERCENTUAL_MAIOR_CEM);
		seleniumUtil.sendKeysId(driver, PERCENTUAL_MAIOR_CEM, percent);

		// Avancar para aba de Variaveis
		seleniumUtil.clickElementId(driver, BTN_SALVAR);

	}

}
