package br.com.marph.geicom.util;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.marph.geicom.enums.EnumPerfil;

import org.openqa.selenium.WebDriver;

public class AcessoUtils {

	public WebElement driver;

	public static void acessarUrl(WebDriver driver) {
		driver.get("http://172.16.10.115:8081/public/login");

	}

	public static void idClick(WebDriver driver, String... ids) {
	//	WebDriverWait wait = new WebDriverWait(driver, IConstante.Parametro.DEFAULT_WAIT);
		for (String idElemento : ids) {
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idElemento)));
			driver.findElement(By.id(idElemento)).click();
		}
	}
	
	public static void idClickXpath(WebDriver driver, String... ids) {
		//WebDriverWait wait = new WebDriverWait(driver, IConstante.Parametro.DEFAULT_WAIT);
		for (String idElemento : ids) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idElemento)));
			driver.findElement(By.xpath(idElemento)).click();
			
		}
	}

	public static void acessarSistema(WebDriver driver) {
		idClick(driver, IConstante.acessarSistema.BOTAO_ACESSAR, IConstante.acessarSistema.BOTAO_CONFIRMAR,
				EnumPerfil.ADMINISTRADOR.getId(), IConstante.acessarSistema.BOTAO_ACESSAR_PERFIL);
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