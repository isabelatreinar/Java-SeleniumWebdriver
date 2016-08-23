package br.com.marph.geicom.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menus {

	private static final String SUB_MENU_MICRO = ".//*[@id='microMenu']/td[2]";
	private static final String SUB_MENU_MACRO = ".//*[@id='macroMenu']/td[2]";
	private static final String MENU_RESOLUCOES = "//td[@onmouseup='cmItemMouseUp (this,0)']";
	private static final String SUB_MENU_MONITORAMENTO = ".//*[@id='monitoramentoIndicadoresMenu']/td[2]";
	private static final String MENU_PROCESSOS = "//td[@onmouseup='cmItemMouseUp (this,20)']";
	private static final String SUB_MENU_BASE_LEGAL = ".//*[@id='baseLegalMenu']/td[2]";
	private static final String SUB_MENU_TIPO_BASE = ".//*[@id='tipoBaseLegalMenu']/td[2]";
	private static final String SUB_MENU_INDICADORES = ".//*[@id='indicadoresMenu']/td[2]";
	private static final String SUB_MENU_RESOLUCAO = ".//*[@id='resolucaoMenu']/td[2]";
	private static final String MENU_CADASTROS = "//td[@onmouseup='cmItemMouseUp (this,4)']";
	private static final String SUB_MENU_VALIDACAO = ".//*[@id='validacaoResultadosMenu']/td[2]";
	private static final String SUB_MENU_REUNIAO = ".//*[@id='resultadoReuniaoRegionalMenu']/td[2]";
	private static final String SUB_MENU_SOLICITACAO_PGTO = ".//*[@id='comandoPagamentoMenu']/td[2]";
	private static final String SUB_MENU_TERMOS_ADITIVOS = ".//*[@id='resolucaoMenuTermos']/td[2]";

	WebElement element;

	// MENUS
	public static void MenuCadastros(WebDriver driver) {
		driver.findElement(By.xpath(MENU_CADASTROS)).click();
	}

	public static void MenuProcessos(WebDriver driver) {
		driver.findElement(By.xpath(MENU_PROCESSOS)).click();
	}

	public static void MenuResolucoes(WebDriver driver) {
		driver.findElement(By.xpath(MENU_RESOLUCOES)).click();
	}

	// SUBMENUS
	public static void subMenuResolucao(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_RESOLUCAO)).click();
	}

	public static void subMenuIndicador(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_INDICADORES)).click();
	}

	public static void subMenuTipoBase(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_TIPO_BASE)).click();
	}

	public static void subMenuBaseLegal(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_BASE_LEGAL)).click();
	}

	public static void subMenuMonitoramento(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_MONITORAMENTO)).click();
	}

	public static void subMenuValidacao(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_VALIDACAO)).click();
	}

	public static void subMenuReuniao(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_REUNIAO)).click();
	}

	public static void subMenuSolicitacaoPagamento(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_SOLICITACAO_PGTO)).click();
	}

	public static void subMenuTermosAditivosV1(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_TERMOS_ADITIVOS)).click();
	}
	
	public static void subMenuMacro(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_MACRO)).click();
	}

	public static void subMenuMicro(WebDriver driver) {
		driver.findElement(By.xpath(SUB_MENU_MICRO)).click();
	}
}
