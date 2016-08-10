package br.com.marph.geicom.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menus {
	WebElement element;

	public static void MenuCadastros(WebDriver driver){
		
		WebElement menuCadastros = driver.findElement(By.xpath("//td[@onmouseup='cmItemMouseUp (this,4)']"));
		menuCadastros.click();
	}
	
	public static void subMenuResolucao(WebDriver driver) {

		WebElement subMenuResolucao = driver.findElement(By.xpath(".//*[@id='resolucaoMenu']/td[2]"));
		subMenuResolucao.click();

	}

	public static void subMenuIndicador(WebDriver driver) {

		WebElement subMenuIndicador = driver.findElement(By.xpath(".//*[@id='indicadoresMenu']/td[2]"));
		subMenuIndicador.click();
	}

	public static void subMenuTipoBase(WebDriver driver) {
	
		WebElement subMenuTipoBase = driver.findElement(By.xpath(".//*[@id='tipoBaseLegalMenu']/td[2]"));
		subMenuTipoBase.click();
		
	}

}
