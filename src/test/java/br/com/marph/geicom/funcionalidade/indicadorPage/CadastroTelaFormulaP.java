package br.com.marph.geicom.funcionalidade.indicadorPage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroTelaFormulaP {

	private static final String DESCRICAO = "descricao";
	private static final String PROGRAMA = "programa";
	private static final String NOME_INDICADOR = "nomeIndicador";
	private static final String NOME_FONTE = "nomeFonte";
	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String FORMULA = "formula";
	private static final String BTN_ADICIONAR = ".//*[@class='row rowPanel']/div[3]/ul/li/a";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private String valorFormula = "*1200";

	public CadastroTelaFormulaP(WebDriver driver) {

		this.driver = driver;
	}

	public void cadastrarFormula() throws InterruptedException {

		seleniumUtil = SeleniumUtil.getInstance();
				
		Thread.sleep(3000);
		// adicionar a variável no textarea de formula
		seleniumUtil.clickElementXpath(driver, BTN_ADICIONAR);		
		
		seleniumUtil.sendKeysId(driver, FORMULA, valorFormula);
		
		seleniumUtil.clickElementId(driver, BTN_SALVAR);
		

		// instanciar a classe CadastroTelaIndicador para usar a variável 'nome'
		// (nome do indicador) para validação no assertEquals
		CadastroTelaIndicadorP indicador = new CadastroTelaIndicadorP(driver);

		// Validação para saber se o cadastro está correto, se o indicador
		// apresentado após o cadastro tem o mesmo nome inserido no cadastro
		assertEquals(indicador.fonte, driver.findElement(By.id(NOME_FONTE)).getText());
		assertEquals(indicador.nome, driver.findElement(By.id(NOME_INDICADOR)).getText());
		assertEquals(indicador.nomePrograma, driver.findElement(By.id(PROGRAMA)).getText());
		assertEquals(indicador.desc, driver.findElement(By.id(DESCRICAO)).getText());

	}

}
