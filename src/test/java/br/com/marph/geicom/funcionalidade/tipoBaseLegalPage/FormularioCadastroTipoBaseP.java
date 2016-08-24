package br.com.marph.geicom.funcionalidade.tipoBaseLegalPage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class FormularioCadastroTipoBaseP {

	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String DESCRICAO_VISUALIZACAO = "descricaoTipoBaseLegal";
	private static final String ASSINATURA_ENTIDADE_VISUALIZACAO = "assinaturaEntidade";
	private static final String ASSINATURA_BENEFICIARIO_VISUALIZACAO = "assinaturaBeneficiario";
	private static final String ASSINATURA_SECRETARIO_VISUALIZACAO = "assinaturaSecretario";
	private static final String PRESTACAO_CONTAS_VISUALIZACAO = "prestacaoContasTipoBaseLegal";
	private static final String PRESTACAO_METAS_VISUALIZACAO = "prestacaoMetasTipoBaseLegal";
	private static final String TRANSFERENCIA_RECURSOS_VISUALIZACAO = "transferenciaRecursosFinanceirosBaseLegal";
	private static final String NOME_TIPO_BASE_LEGAL_VISUALIZACAO = "modalNomeTipoBaseLegal";
	private static final String DESCRICAO = "descricao";
	private static final String SELECIONAR_ASSIN_ENTIDADE = ".//*[@id='assinaturaEntidade_chosen']/div/div/input";
	private static final String ASSINATURA_ENTIDADE = ".//*[@id='assinaturaEntidade_chosen']/a";
	private static final String SELECIONAR_ASSIN_BENEFICIARIO = ".//*[@id='assinaturaBeneficiario_chosen']/div/div/input";
	private static final String ASSINATURA_BENEFICIARIO = ".//*[@id='assinaturaBeneficiario_chosen']/a";
	private static final String SELECIONAR_ASSIN_SECRETARIO = ".//*[@id='assinaturaSecretario_chosen']/div/div/input";
	private static final String ASSINTURA_SECRETARIO = ".//*[@id='assinaturaSecretario_chosen']/a";
	private static final String SELECIONAR_PRESTACAO_CONTAS = ".//*[@id='prestacaoContas_chosen']/div/div/input";
	private static final String PRESTACAO_CONTAS = ".//*[@id='prestacaoContas_chosen']/a";
	private static final String SELECIONAR_PRESTACAO_METAS = ".//*[@id='prestacaoMetas_chosen']/div/div/input";
	private static final String PRESTACAO_METAS = ".//*[@id='prestacaoMetas_chosen']/a";
	private static final String SELECIONAR_TRANSF_RECURSO = ".//*[@id='transferenciaRecursosFinanceiros_chosen']/div/div/input";
	private static final String TRANSFERENCIA_RECURSOS = ".//*[@id='transferenciaRecursosFinanceiros_chosen']/a";
	private static final String NOME_TIPO_BASE_LEGAL = "nomeTipoBaseLegal";
	private static final String BTN_CADASTRAR_TIPO_BASE_LEGAL = "btnNovoTipoBaseLegal";

	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	public final String nomeTipo = "Deliberação Automatizado";
	private final String opcaoTrans = "Sim";
	private final String opcaoMetas = "Sim";
	private final String opcaoContas = "Sim";
	private final String opcaoAssSecretario = "Não";
	private final String opcaoAssBeneficiario = "Não";
	private final String opcaoAssEntidade = "Não";
	private final String textDescricao = "Teste";

	public FormularioCadastroTipoBaseP(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherCadastro() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, BTN_CADASTRAR_TIPO_BASE_LEGAL);

		seleniumUtil.clickElementId(driver, NOME_TIPO_BASE_LEGAL);
		seleniumUtil.sendKeysId(driver, NOME_TIPO_BASE_LEGAL, nomeTipo);

		// Selecionar transferência de recurso
		seleniumUtil.clickElementXpath(driver, TRANSFERENCIA_RECURSOS);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_TRANSF_RECURSO);
		seleniumUtil.sendKeysXpath(driver, TRANSFERENCIA_RECURSOS, opcaoTrans);
		driver.findElement(By.xpath(TRANSFERENCIA_RECURSOS)).sendKeys(Keys.ENTER);

		// Selecionar prestação de Metas
		seleniumUtil.clickElementXpath(driver, PRESTACAO_METAS);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_PRESTACAO_METAS);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_PRESTACAO_METAS, opcaoMetas);
		driver.findElement(By.xpath(SELECIONAR_PRESTACAO_METAS)).sendKeys(Keys.ENTER);

		// Selecionar prestação de Contas
		seleniumUtil.clickElementXpath(driver, PRESTACAO_CONTAS);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_PRESTACAO_CONTAS);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_PRESTACAO_CONTAS, opcaoContas);
		driver.findElement(By.xpath(SELECIONAR_PRESTACAO_CONTAS)).sendKeys(Keys.ENTER);

		// Selecionar assinatura secretário de estado
		seleniumUtil.clickElementXpath(driver, ASSINTURA_SECRETARIO);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_ASSIN_SECRETARIO);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_ASSIN_SECRETARIO, opcaoAssSecretario);
		driver.findElement(By.xpath(SELECIONAR_ASSIN_SECRETARIO)).sendKeys(Keys.ENTER);

		// Selecionar assinatura Beneficiário
		seleniumUtil.clickElementXpath(driver, ASSINATURA_BENEFICIARIO);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_ASSIN_BENEFICIARIO);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_ASSIN_BENEFICIARIO, opcaoAssBeneficiario);
		driver.findElement(By.xpath(SELECIONAR_ASSIN_BENEFICIARIO)).sendKeys(Keys.ENTER);


		// Selecionar assinatura Entidade
		seleniumUtil.clickElementXpath(driver, ASSINATURA_ENTIDADE);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_ASSIN_ENTIDADE);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_ASSIN_ENTIDADE, opcaoAssEntidade);
		driver.findElement(By.xpath(SELECIONAR_ASSIN_ENTIDADE)).sendKeys(Keys.ENTER);

		// Preencher descrição
		seleniumUtil.clickElementId(driver, DESCRICAO);
		seleniumUtil.sendKeysId(driver, DESCRICAO, textDescricao);
				
		// Salvar cadastro
		seleniumUtil.clickElementId(driver, BTN_SALVAR);
		
		// Validações
		assertEquals(nomeTipo, driver.findElement(By.id(NOME_TIPO_BASE_LEGAL_VISUALIZACAO)).getText());
		assertEquals(opcaoTrans, driver.findElement(By.id(TRANSFERENCIA_RECURSOS_VISUALIZACAO)).getText());
		assertEquals(opcaoMetas, driver.findElement(By.id(PRESTACAO_METAS_VISUALIZACAO)).getText());
		assertEquals(opcaoContas, driver.findElement(By.id(PRESTACAO_CONTAS_VISUALIZACAO)).getText());
		assertEquals(opcaoAssSecretario, driver.findElement(By.id(ASSINATURA_SECRETARIO_VISUALIZACAO)).getText());
		assertEquals(opcaoAssBeneficiario, driver.findElement(By.id(ASSINATURA_BENEFICIARIO_VISUALIZACAO)).getText());
		assertEquals(opcaoAssEntidade, driver.findElement(By.id(ASSINATURA_ENTIDADE_VISUALIZACAO)).getText());
		assertEquals(textDescricao, driver.findElement(By.id(DESCRICAO_VISUALIZACAO)).getText());

	}

}
