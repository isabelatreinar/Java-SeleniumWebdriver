package br.com.marph.selenium.municipio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.marph.selenium.enums.EnumAcesso;
import br.com.marph.selenium.utils.AcessoUtils;

public class MenuMunicipioTemplate {
	private MenuMunicipioTemplate(){}
	
	public static void prepararAcessoMunicipio(WebDriver driver) {
		
		AcessoUtils.acessaId(driver, "closeModalHome", "btnEntradaSistemaID","btnAcessar","confirmarDados",EnumAcesso.ADMINISTRADOR.getId(),"acessarSistema");
		
		AcessoUtils.acessaXpath(driver, "//td[@onmouseup='cmItemMouseUp (this,2)']");
		
		
		municipio(driver);
	}

	private static void municipio(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id='municipioMenu']")).click();
	}
}
