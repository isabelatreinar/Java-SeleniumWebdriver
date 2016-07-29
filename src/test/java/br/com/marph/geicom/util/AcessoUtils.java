package br.com.marph.geicom.util;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import br.com.marph.geicom.enums.EnumPerfil;

import org.openqa.selenium.WebDriver;

public class AcessoUtils {

	public WebElement driver;

	public static void acessarUrl(WebDriver driver) {
		driver.get("http://172.16.10.115:8081/public/login");

	}

	public static void idClick(WebDriver driver, String... ids) {
		for (String idElemento : ids) {
			driver.findElement(By.id(idElemento)).click();
		}
	}

	public static void acessarSistema(WebDriver driver) {
		idClick(driver, "btnAcessar", "confirmarDados", EnumPerfil.ADMINISTRADOR.getId(), "acessarSistema");
	}

}

/*
 * public static void acessarSistema(WebDriver driver){
 * 
 * driver.findElement(By.id("btnAcessar")).click();
 * 
 * driver.findElement(By.id("confirmarDados")).click();
 * 
 * WebElement perfilEnum =
 * driver.findElement(By.id(EnumPerfil.EQUIPE_GEICOM.getId()));
 * perfilEnum.click();
 * 
 * driver.findElement(By.id("acessarSistema")).click();
 * 
 * }
 */