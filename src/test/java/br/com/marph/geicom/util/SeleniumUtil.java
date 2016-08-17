package br.com.marph.geicom.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe Singleton - Apenas uma instancia desta classe serah criada durante a
 * execucao do sistema, o que garante esta caracteristica é o fato do construtor
 * ser privado, internamente criamos a instancia e um metodo suficiente para que
 * os usuarios desa api possam recuperar esta instancia
 * 
 * 
 *
 */
public class SeleniumUtil {

	private static SeleniumUtil instance;

	// criando a unica instancia possivel desta classe durante a execucao do
	// projeto
	/**
	 * Cria uma instancia unica do singleton SeleniumUtil
	 */
	static {
		instance = new SeleniumUtil();
	}

	/**
	 * Da acesso ao objeto unico gerado por esta classe
	 * 
	 * @return instancia do singleton
	 */
	public static SeleniumUtil getInstance() {
		return instance;
	}

	/**
	 * 
	 * Seta o valor em um elemento contido no driver
	 * 
	 * @param driver
	 *            - Instancia do browser conectado a um dominio
	 * @param fieldKey
	 *            - id do elemento html no qual serah inserido o valor
	 * @param fieldValue
	 *            - valor que serah atribuido ao elemento html
	 * @param s
	 *            faz o seguinte, vc passa pra ele o id de um campo e o valor
	 *            que vc quer setar nele
	 */
	public void sendKeysId(WebDriver driver, String fieldKey, String fieldValue) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// farah com que o driver busque pelo elemento durante cinco segundos
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldKey)));
		WebElement user = driver.findElement(By.id(fieldKey));
		user.sendKeys(fieldValue);
	}

	public void sendKeysXpath(WebDriver driver, String fieldKey, String fieldValue) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// farah com que o driver busque pelo elemento durante cinco segundos
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldKey)));
		WebElement user = driver.findElement(By.xpath(fieldKey));
		user.sendKeys(fieldValue);
	}

	public void sendKeysName(WebDriver driver, String fieldKey, String fieldValue) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// farah com que o driver busque pelo elemento durante cinco segundos
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(fieldKey)));
		WebElement user = driver.findElement(By.name(fieldKey));
		user.sendKeys(fieldValue);
	}

	public void sendKeysClass(WebDriver driver, String fieldKey, String fieldValue) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// farah com que o driver busque pelo elemento durante cinco segundos
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(fieldKey)));
		WebElement user = driver.findElement(By.className(fieldKey));
		user.sendKeys(fieldValue);
	}

	public void clickElementId(WebDriver driver, String... elements) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement access = null;
		for (String element : elements) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
			access = driver.findElement(By.id(element));
			access.click();
		}
	}

	public void clickElementXpath(WebDriver driver, String... elements) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement access = null;
		for (String element : elements) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			access = driver.findElement(By.xpath(element));
			access.click();
		}
	}

	public void clickElementName(WebDriver driver, String... elements) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement access = null;
		for (String element : elements) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
			access = driver.findElement(By.name(element));
			access.click();
		}
	}

	public void clickElementClassName(WebDriver driver, String... elements) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement access = null;
		for (String element : elements) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
			access = driver.findElement(By.className(element));
			access.click();
		
	}

	/**
	 * Seta o valor de varios elementos contidos no driver
	 * 
	 * @param driver
	 *            - Instancia do browser conectado a um dominio
	 * @param fields
	 *            - Mapa contendo como key o id do elemento e value o valor a
	 *            ser atribuido
	 */
	// public void buildElement(WebDriver driver, List<Entry<String, String>>
	// fields) {
	// for (Entry<String, String> entry : fields) {
	// buildElement(driver, entry.getKey(), entry.getValue());
	// }
}
}

/**
 * Seta o valor de um elementos contidos no driver
 * 
 * @param driver
 *            - Instancia do browser conectado a um dominio
 * @param field
 *            - Entry contendo, key o id do elemento e value o valor a ser
 *            atribuido
 */
// public void buildElement(WebDriver driver, Entry<String, String> field) {
// buildElement(driver, field.getKey(), field.getValue());
// }
//
// }
