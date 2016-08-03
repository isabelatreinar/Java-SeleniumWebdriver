package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import br.com.marph.geicom.util.AcessoUtils;
import br.com.marph.geicom.util.IConstante;

public class CadastroAbaResolucao {

	private WebDriver driver;

	public CadastroAbaResolucao(WebDriver driver) {
		this.driver = driver;
	}

	public void abaResolucao() throws InterruptedException {

		//WebDriverWait wait = new WebDriverWait(driver, IConstante.Parametro.DEFAULT_WAIT);

		String nomePrograma = "Samu";
		String numeroResolucao = "1235";
		String tempoVigencia = "12";

		// Preencher campo Programa/Outros
		driver.findElement(By.id("btnNovaResolucao")).click();
		WebElement programa = driver.findElement(By.xpath(".//*[@id='programa_chosen']/a"));
		programa.click();
		programa.sendKeys(nomePrograma);
		programa.sendKeys(Keys.TAB);

		// Selecionar Número da Resolução
		WebElement resolucao = driver.findElement(By.xpath(".//*[@id='baseLegal_chosen']/a"));
		resolucao.click();
		resolucao.sendKeys(numeroResolucao);
		resolucao.sendKeys(Keys.TAB);

		// Selecionar Base Legal

		//espera até que o nome do campo de base legal apareça na tela, para poder selecionar
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termosBaseLegal_label")));
		Thread.sleep(3000);
		
		WebElement baseLegal = driver.findElement(By.xpath(".//*[@id='termosBaseLegal_chosen']/ul"));
		baseLegal.click();
		baseLegal.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='termosBaseLegal_chosen']/div/ul/li[4]")).click();
		baseLegal.sendKeys(Keys.TAB);

		// Preencher Tempo de Vigência
		WebElement vigencia = driver.findElement(By.id("tempoVigencia"));
		vigencia.sendKeys(tempoVigencia);

		// Verifica se campos de Recursos estão habilitados
		WebElement recursoMun = driver.findElement(By.id("recursoMunicipal"));
		WebElement recursoEst = driver.findElement(By.id("recursoEstadual"));
		WebElement recursoFed = driver.findElement(By.id("recursoFederal"));

		if (!recursoMun.isEnabled()) {
			recursoMun.click();
			recursoMun.sendKeys("120000");

			recursoEst.click();
			recursoEst.sendKeys("140000");

			recursoFed.click();
			recursoFed.sendKeys("150000");
		}

		WebElement descricao = driver.findElement(By.id("descricao"));
		descricao.click();
		descricao.sendKeys("Testeeeee");

		AcessoUtils.idClick(driver, "btnSalvar1", "btnProximo");

	}
}
