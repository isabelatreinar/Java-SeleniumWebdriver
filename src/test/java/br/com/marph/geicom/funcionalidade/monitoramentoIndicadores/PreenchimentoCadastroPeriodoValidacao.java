package br.com.marph.geicom.funcionalidade.monitoramentoIndicadores;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.SeleniumUtil;

public class PreenchimentoCadastroPeriodoValidacao {

	private static final String BTN_VOLTAR_LISTAGEM = "btnVoltar1";
	private static final String BTN_SALVAR = "btnSalvar1";
	private static final String DATA_LIMITE_REUNIAO = "dataLimiteReuniaoPeriodoValidacao";
	private static final String SELECIONAR_HABILIT_REUNIAO = ".//*[@id='solicitacaoReuniaoAcompanhamento_chosen']/div/div/input";
	private static final String HABILITAR_SOLICIT_REUNIAO = ".//*[@id='solicitacaoReuniaoAcompanhamento_chosen']/a";
	private static final String DATA_FIM_PERIODO_VALIDACAO = "dataFimPeriodoValidacao";
	private static final String DATA_INICIO_PERIODO_VALIDACAO = "dataInicioPeriodoValidacao";
	private static final String BTN_CADASTRAR_PERIODO_VALIDACAO = "btnCadastrarPeriodoValidacao";
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String dtFim = "01122016";
	private final String opcao = "Sim";
	private final String dtReuniao = "20122016"; 

	
	public PreenchimentoCadastroPeriodoValidacao(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preencherCadastro(){
		
		seleniumUtil = SeleniumUtil.getInstance();
		
		//Retorna a data atual, c contém a data atual
		Calendar c = Calendar.getInstance();
		//Converte a data para String
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		String dtInicio = s.format(c.getTime());
		
		seleniumUtil.clickElementId(driver, BTN_CADASTRAR_PERIODO_VALIDACAO);
		
		seleniumUtil.clickElementId(driver, DATA_INICIO_PERIODO_VALIDACAO);
		driver.findElement(By.id(DATA_INICIO_PERIODO_VALIDACAO)).clear();
		seleniumUtil.sendKeysId(driver, DATA_INICIO_PERIODO_VALIDACAO, dtInicio); //dtInicio contém a data atual
		
		seleniumUtil.clickElementId(driver, DATA_FIM_PERIODO_VALIDACAO);
		driver.findElement(By.id(DATA_FIM_PERIODO_VALIDACAO)).clear();
		seleniumUtil.sendKeysId(driver, DATA_FIM_PERIODO_VALIDACAO, dtFim);
		
		seleniumUtil.clickElementXpath(driver, HABILITAR_SOLICIT_REUNIAO);
		seleniumUtil.clickElementXpath(driver, SELECIONAR_HABILIT_REUNIAO);
		seleniumUtil.sendKeysXpath(driver, SELECIONAR_HABILIT_REUNIAO, opcao);
		driver.findElement(By.xpath(SELECIONAR_HABILIT_REUNIAO)).sendKeys(Keys.ENTER);
		
		seleniumUtil.clickElementId(driver, DATA_LIMITE_REUNIAO);
		driver.findElement(By.id(DATA_LIMITE_REUNIAO)).clear();
		seleniumUtil.sendKeysId(driver, DATA_LIMITE_REUNIAO, dtReuniao);
		
		seleniumUtil.clickElementId(driver, BTN_SALVAR);
		
		seleniumUtil.clickElementId(driver, BTN_VOLTAR_LISTAGEM);
		
		
	}

}
