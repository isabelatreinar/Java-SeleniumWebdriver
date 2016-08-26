package br.com.marph.geicom.funcionalidade.blocoFinanciamentoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import br.com.marph.geicom.util.SeleniumUtil;

public class FormularioCadastroBlocoP {

	private static final String CAMPO_NOME_VISUALIZ = "tipo";
	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String CAMPO_DESCRICAO = "descricao";
	private static final String CAMPO_NOME = "nome";
	private static final String BTN_NOVO_BLOCO_FINANCIAMENTO = "btnNovoBlocoFinanciamento";
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String opcaoNome = "Bloco Teste";
	private final String opcaoDescricao = "Teste descricão";
	
	public FormularioCadastroBlocoP(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherCadastro(){
		
		seleniumUtil = SeleniumUtil.getInstance();
		
		seleniumUtil.clickElementId(driver, BTN_NOVO_BLOCO_FINANCIAMENTO);
		
		seleniumUtil.clickElementId(driver, CAMPO_NOME);
		seleniumUtil.sendKeysId(driver, CAMPO_NOME, opcaoNome );
		
		seleniumUtil.clickElementId(driver, CAMPO_DESCRICAO);
		seleniumUtil.sendKeysId(driver, CAMPO_DESCRICAO, opcaoDescricao );
		
		seleniumUtil.clickElementId(driver, BTN_SALVAR);
		
		assertEquals(CAMPO_NOME, driver.findElement(By.id(CAMPO_NOME_VISUALIZ)).getText());
		
	}
}
