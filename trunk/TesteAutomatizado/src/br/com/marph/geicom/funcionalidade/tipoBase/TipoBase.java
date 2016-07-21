package br.com.marph.geicom.funcionalidade.tipoBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.util.LoginSistema;

public class TipoBase {

	private WebDriver driver;

	@Before
		public void startUp(){
		driver = new FirefoxDriver();
	}
	
	/*@After
	public void driverClose(){
		driver.quit();
	}*/
	
	@Test
	public void browser(){
		LoginSistema.acessarUrl(driver);
		
		LoginSistema.acessarSistema(driver);
	}
		

}

//LoginSistema.acessarSistema(driver);
		/*WebElement botaoEnviar = driver.findElement(By.id("btnAcessar"));
		    botaoEnviar.click();*/