package br.com.marph.geicom.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteLoginSimples {


	@Test
	public void testLoginAnotai() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://anotaai-alinesolutions.rhcloud.com/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		WebElement btnAccess = driver.findElement(By.id("btn-access"));
		btnAccess.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("anotaai@gmail.com");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("senha")));
		WebElement senha = driver.findElement(By.id("senha"));
		senha.sendKeys("10481");
		
		WebElement btnLogin = driver.findElement(By.id("btn-login"));
		btnLogin.click();
		
		Assert.assertNotNull(driver.findElement(By.id("nome-perfil")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-access")));
		WebElement btnProfile = driver.findElement(By.id("btn-access"));
		btnProfile.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-access")));
		WebElement btnShutdown = driver.findElement(By.id("btn-access"));
		btnShutdown.click();
	}

}
