package br.com.marph.geicom.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.enums.EnumPerfil;

public class AcessoUtils {

	public WebElement driver;

	public static void acessarSistema(WebDriver driver) {

		// Não utilizei a classe SeleniumUtil, pois preciso acessar a interface,
		// e os metodos da interface são static, e os métodos de click do
		// selenium util não são static, para usar o click de selenium util,
		// deveria mudar todos os metodos dessa classe para static
		driver.findElement(By.id(IConstante.acessarSistema.BOTAO_ACESSAR)).click();
		driver.findElement(By.id(IConstante.acessarSistema.BOTAO_CONFIRMAR)).click();
		driver.findElement(By.id(EnumPerfil.ADMINISTRADOR.getId())).click();
		driver.findElement(By.id(IConstante.acessarSistema.BOTAO_ACESSAR_PERFIL)).click();

	}

}
