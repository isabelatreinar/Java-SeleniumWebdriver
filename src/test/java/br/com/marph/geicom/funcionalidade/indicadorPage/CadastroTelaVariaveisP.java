package br.com.marph.geicom.funcionalidade.indicadorPage;

import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroTelaVariaveisP {

	private static final String BTN_AVANCAR = "btnSalvar1";
	private static final String BTN_SALVAR = ".//*[@class='_salvarVariavel']";
	private static final String DESCRICAO = "descricao";
	private static final String NOME_VARIAVEL = ".//*[@class='form-control-tit _nome']";
	private static final String CADASTRAR_VARIAVEL = "criar";

	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private String nome = "Taxa";
	private String descr = "Taxa de Adesao";

	public CadastroTelaVariaveisP(WebDriver driver) {

		this.driver = driver;
	}

	public void cadastrarVariaveis() {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementId(driver, CADASTRAR_VARIAVEL);

		seleniumUtil.clickElementXpath(driver, NOME_VARIAVEL);
		seleniumUtil.sendKeysXpath(driver, NOME_VARIAVEL, nome);

		seleniumUtil.clickElementName(driver, DESCRICAO);
		seleniumUtil.sendKeysName(driver, DESCRICAO, descr);

		seleniumUtil.clickElementXpath(driver, BTN_SALVAR);

		// Clicar no botão Avançar
		seleniumUtil.clickElementId(driver, BTN_AVANCAR);

	}

}
