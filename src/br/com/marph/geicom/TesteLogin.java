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
		driver.get("http://anotaai-alinesolutions.rhcloud.com/main.html#/access/Login");
		WebElement user = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("senha"));
		WebElement access = driver.findElement(By.id("btn-login"));
		user.sendKeys("anotaai@gmail.com");
		pass.sendKeys("10481");
		access.click();
		Assert.assertNotNull(driver.findElement(By.id("nome-perfil")));
	}

	@After
	public void driverClose() {
		driver.quit();
	}

}
