package br.com.marph.geicom.funcionalidade.resolucao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroTelaIndicador {

	private WebDriver driver;
	private String tipoIndic = "Final";
	private String tipoFont = "Oficial";
	private String polari = "Quanto maio";
	private String medMovel = "12";
	private String medDefasagem = "12";
	public String nome = "Taxa de Adesao";
	private String fonte = "Estadual";
	private String program = "Samu";
	private String desc = "Teste";
	private String opDispensa = "Outro";
	private String percentDispensa = "8000";
	private String maiorCem = "Outro";
	private String percent = "10000";

	public CadastroTelaIndicador(WebDriver driver) {
		this.driver = driver;
	}

	public void cadastrarTelaIndicador() throws InterruptedException {

		WebElement novoIndicador = driver.findElement(By.id("btnNovoIndicador"));
		novoIndicador.click();

		// Tipo Indicador
		WebElement tipoIndicador = driver.findElement(By.id("tipoIndicador_chosen"));
		tipoIndicador.click();

		WebElement selecionarTipoInd = driver.findElement(By.xpath(".//*[@id='tipoIndicador_chosen']/div/div/input"));
		selecionarTipoInd.click();
		selecionarTipoInd.sendKeys(tipoIndic);
		selecionarTipoInd.sendKeys(Keys.ENTER);

		// Tipo Fonte
		WebElement tipoFonte = driver.findElement(By.id("tipoFonte_chosen"));
		tipoFonte.click();

		WebElement selecionarTipoFonte = driver.findElement(By.xpath(".//*[@id='tipoFonte_chosen']/div/div/input"));
		selecionarTipoFonte.click();
		selecionarTipoFonte.sendKeys(tipoFont);
		selecionarTipoFonte.sendKeys(Keys.ENTER);

		// Tipo Polaridade
		WebElement polaridade = driver.findElement(By.id("polaridade_chosen"));
		polaridade.click();

		WebElement selecionarPolaridade = driver.findElement(By.xpath(".//*[@id='polaridade_chosen']/div/div/input"));
		selecionarPolaridade.click();
		selecionarPolaridade.sendKeys(polari);
		selecionarPolaridade.sendKeys(Keys.ENTER);

		// Meses da m�dia m�vel
		WebElement mediaMovel = driver.findElement(By.id("mesesDaMediaMovel"));
		mediaMovel.click();
		mediaMovel.sendKeys(medMovel);

		// Meses de Defasagem
		WebElement mediaDefasagem = driver.findElement(By.id("mesesDeDefasagem"));
		mediaDefasagem.click();
		mediaDefasagem.sendKeys(medDefasagem);

		// Nome do Indicador
		WebElement nomeIndicador = driver.findElement(By.id("nomeIndicador"));
		nomeIndicador.click();
		nomeIndicador.sendKeys(nome);

		// Fonte
		WebElement nomeFonte = driver.findElement(By.id("nomeFonte"));
		nomeFonte.click();
		nomeFonte.sendKeys(fonte);

		// Programa
		WebElement programa = driver.findElement(By.id("programa_chosen"));
		programa.click();

		WebElement selecionarPrograma = driver.findElement(By.xpath(".//*[@id='programa_chosen']/div/div/input"));
		selecionarPrograma.click();
		selecionarPrograma.sendKeys(program);
		selecionarPrograma.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		// Descri��o
		WebElement descricao = driver.findElement(By.id("descricao"));
		descricao.click();
		descricao.sendKeys(desc);

		// Indicador Dispensado?
		WebElement indicadorDispensado = driver.findElement(By.id("percentualIndicadorDispensado_chosen"));
		indicadorDispensado.click();

		WebElement opcaoDispensa = driver.findElement(By.xpath(".//*[@id='percentualIndicadorDispensado_chosen']/div/div/input"));
		opcaoDispensa.click();
		opcaoDispensa.sendKeys(opDispensa);
		opcaoDispensa.sendKeys(Keys.TAB);

		// Informar o percentual de cumprimento para indicador dispensado
		WebElement percentualDispensa = driver.findElement(By.id("percentualCumprimentoIndicadorDispensado"));
		percentualDispensa.click();
		percentualDispensa.sendKeys(percentDispensa);
		Thread.sleep(2000);
		
		// Percentual de Cumprimento maior que 100%?
		WebElement percentualMaiorCem = driver.findElement(By.xpath(".//*[@id='percentualMaiorCem_chosen']/a"));
		percentualMaiorCem.click();

		WebElement opcaoMaiorCem = driver.findElement(By.xpath(".//*[@id='percentualMaiorCem_chosen']/div/div/input"));
		opcaoMaiorCem.click();
		opcaoMaiorCem.sendKeys(maiorCem);
		opcaoMaiorCem.sendKeys(Keys.ENTER);

		// Informar o percentual de cumprimento para indicador maior que 100%
		WebElement percentMaiorCem = driver.findElement(By.id("percentualCumprimentoMaiorCem"));
		percentMaiorCem.click();
		percentMaiorCem.sendKeys(percent );
		
		//Avan�ar para aba de Vari�veis
		WebElement avancar = driver.findElement(By.id("btnSalvar1"));
		avancar.click();

	}

}
