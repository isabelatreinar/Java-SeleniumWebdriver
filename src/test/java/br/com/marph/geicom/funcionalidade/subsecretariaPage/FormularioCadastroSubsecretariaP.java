package br.com.marph.geicom.funcionalidade.subsecretariaPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;


import br.com.marph.geicom.util.SeleniumUtil;

public class FormularioCadastroSubsecretariaP {

	private static final String CAMPO_NOME_VISUALIZ = "tipo";
	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String CAMPO_SIGLA = "sigla";
	private static final String CAMPO_NOME = "nome";
	private static final String BTN_NOVA_SUBSECRETARIA = "btnNovaSubsecretaria";
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String opcaoNome = "Subsecretaria Teste";
	private final String opcaoSigla = "SUB";

	public FormularioCadastroSubsecretariaP(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherCadastro() {
		
		seleniumUtil = SeleniumUtil.getInstance();
		
		seleniumUtil.clickElementId(driver, BTN_NOVA_SUBSECRETARIA);
		
		seleniumUtil.clickElementId(driver, CAMPO_NOME);
		seleniumUtil.sendKeysId(driver, CAMPO_NOME, opcaoNome );
		
		seleniumUtil.clickElementId(driver, CAMPO_SIGLA);
		seleniumUtil.sendKeysId(driver, CAMPO_SIGLA, opcaoSigla );
		
		seleniumUtil.clickElementId(driver, BTN_SALVAR);
		
		/**Validação:**/
		assertEquals(opcaoNome,driver.findElement(By.id(CAMPO_NOME_VISUALIZ)).getText());
		
	}
}
