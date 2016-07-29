package br.com.marph.geicom.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menus {

	WebElement element;

	public static void menuResolucao(WebDriver driver) {

		driver.findElement(By.xpath("//td[@onmouseup='cmItemMouseUp (this,4)']")).click();;
		driver.findElement(By.xpath(".//*[@id='resolucaoMenu']/td[2]")).click();
		
	}

}
