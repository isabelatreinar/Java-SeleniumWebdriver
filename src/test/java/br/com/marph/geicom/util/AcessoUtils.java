package br.com.marph.geicom.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.enums.EnumPerfil;

public class AcessoUtils {

	public WebElement driver;
	
	/**Perfil Administrador**/
	public static void acessarSistemaAdmin(WebDriver driver) {

		// N�o utilizei a classe SeleniumUtil, pois preciso acessar a interface,
		// e os metodos da interface s�o static, e os m�todos de click do
		// selenium util n�o s�o static, para usar o click de selenium util,
		// deveria mudar todos os metodos dessa classe para static
		driver.findElement(By.id(IConstante.acessarSistema.BOTAO_ACESSAR)).click();
		driver.findElement(By.id(IConstante.acessarSistema.BOTAO_CONFIRMAR)).click();
		driver.findElement(By.id(EnumPerfil.ADMINISTRADOR.getId())).click();
		driver.findElement(By.id(IConstante.acessarSistema.BOTAO_ACESSAR_PERFIL)).click();

	}
	
	/**Perfil Superintend�ncia de Contratos**/
	public static void acessarSistemaScss(WebDriver driver) {

		// N�o utilizei a classe SeleniumUtil, pois preciso acessar a interface,
		// e os metodos da interface s�o static, e os m�todos de click do
		// selenium util n�o s�o static, para usar o click de selenium util,
		// deveria mudar todos os metodos dessa classe para static
		driver.findElement(By.id(IConstante.acessarSistema.BOTAO_ACESSAR)).click();
		driver.findElement(By.id(IConstante.acessarSistema.BOTAO_CONFIRMAR)).click();
		driver.findElement(By.id(EnumPerfil.SUPERINTENDENCIA_CONTRATOS.getId())).click();
		driver.findElement(By.id(IConstante.acessarSistema.BOTAO_ACESSAR_PERFIL)).click();

	}
}
