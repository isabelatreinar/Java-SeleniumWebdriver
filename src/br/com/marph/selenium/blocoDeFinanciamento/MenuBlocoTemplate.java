package br.com.marph.selenium.blocoDeFinanciamento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.marph.selenium.enums.EnumAcesso;
import br.com.marph.selenium.utils.AcessoUtils;

public class MenuBlocoTemplate {
	public static void prepararAcessoBloco(WebDriver driver) {
		AcessoUtils.idClick(driver, "btnEntradaSistemaID", "btnAcessar", "confirmarDados",
				EnumAcesso.ADMINISTRADOR.getId(), "acessarSistema");

		AcessoUtils.xpathClick(driver, "//td[@onmouseup='cmItemMouseUp (this,3)']");

		blocoFinanciamento(driver);
	}

	private static void blocoFinanciamento(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id='blocoFinanciamentoMenu']")).click();
	}
}
