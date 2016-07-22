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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("senha")));
		WebElement senha = driver.findElement(By.id("senha"));
		WebElement btnLogin = driver.findElement(By.id("btn-login"));
		email.sendKeys("anotaai@gmail.com");
		senha.sendKeys("10481");
		btnLogin.click();
		Assert.assertNotNull(driver.findElement(By.id("nome-perfil")));
	}

}
