package br.com.marph.geicom.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menus {

	private static final String SUB_MENU_MONITORAMENTO = ".//*[@id='monitoramentoIndicadoresMenu']/td[2]";
	private static final String MENU_PROCESSOS = "//td[@onmouseup='cmItemMouseUp (this,20)']";
	private static final String SUB_MENU_BASE_LEGAL = ".//*[@id='baseLegalMenu']/td[2]";
	private static final String SUB_MENU_TIPO_BASE = ".//*[@id='tipoBaseLegalMenu']/td[2]";
	private static final String SUB_MENU_INDICADORES = ".//*[@id='indicadoresMenu']/td[2]";
	private static final String SUB_MENU_RESOLUCAO = ".//*[@id='resolucaoMenu']/td[2]";
	private static final String MENU_CADASTROS = "//td[@onmouseup='cmItemMouseUp (this,4)']";
	WebElement element;
	
	//MENUS
	public static void MenuCadastros(WebDriver driver) {
		driver.findElement(By.xpath(MENU_CADASTROS)).click();
	}
	
	public static void MenuProcessos(WebDriver driver){
		driver.findElement(By.xpath(MENU_PROCESSOS)).click();
	}

	//SUBMENUS
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
}
