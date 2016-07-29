package br.com.marph.geicom.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.geicom.util.IConstantes;
import br.com.marph.geicom.util.SeleniumUtil;
//
public class TesteLoginComplexo {

	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	
	@Before
	public void startUp() {
		seleniumUtil = SeleniumUtil.getInstance();
		driver = new FirefoxDriver();
	}

	@Test
	public void testLoginAnotai() {
		driver.get(IConstantes.URI.LOGIN);
		seleniumUtil.clickElement(driver, IConstantes.HtmlCommandId.BOTAO_ACESSO);
		seleniumUtil.buildElement(driver, getInputs());
		//caso quisesse setar em apenas um campo, pode ser feito de maneira direta sem utilizar a lista
		//seleniumUtil.buildElement(driver, IConstante.HtmlInput.SENHA);
		//caso quisesse setar em apenas um campo passando os nomes do campo
		//seleniumUtil.buildElement(driver, "email", "anotaai@gmail.com");NAO RECOMENDADO
		seleniumUtil.clickElement(driver, IConstantes.HtmlCommandId.BOTAO_LOGIN);
	}
	
	private List<Entry<String, String>> getInputs() {
		List<Entry<String, String>> inputs = new ArrayList<>();
		inputs.add(IConstantes.HtmlInput.EMAIL);
		inputs.add(IConstantes.HtmlInput.SENHA);
		return inputs;
	}
	
	@After
	public void driverClose() {
		//deslogar depois dos testes efetuados
		seleniumUtil.clickElement(driver, IConstantes.HtmlCommandId.BOTAO_PROFILE);
		seleniumUtil.clickElement(driver, IConstantes.HtmlCommandId.BOTAO_SHUTDOWN);
		//decomentar caso queira fechar o browser quando os testes forem concuidos
		//driver.quit();
	}

}
