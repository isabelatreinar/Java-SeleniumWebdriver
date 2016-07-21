package br.com.marph.geicom;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteLogin {

	private WebDriver driver;

	@Before
	public void startUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void testLoginAnotai() {
		driver.get("http://anotaai-alinesolutions.rhcloud.com");
		buildElement("email", "anotaai@gmail.com");
		buildElement("senha", "10481");
		
		String[] btns = {"btn-login", "outro-btn"};
		
		clickElement(btns);
		
		Assert.assertNotNull(driver.findElement(By.id("nome-perfil")));
	}

	private void buildElement(String fieldId, String keys) {
		WebElement user = driver.findElement(By.name(fieldId));
		user.sendKeys(keys);
	}
	
	private void clickElement(String... elements) {
		WebElement access = null;
		for (String element : elements) {
			access = driver.findElement(By.id(element));
			access.click();
		}
	}
	
	/*@After
	public void driverClose() {
		driver.quit();
	}*/

}
