package br.com.marph.geicom.funcionalidade.indicador;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.marph.geicom.util.IConstante;

public class CadastroTelaIndicador {
	
	public WebDriver driver;
	public String medMovel = "12";
	public String medDefasagem = "12";
	public String nome = "Taxa de Adesao";
	public String fonte = "Estadual";
	public String desc = "Teste";
	public String opDispensa = "Outro";
	public String percentDispensa = "8000";
	public String maiorCem = "Outro";
	public String percent = "10000";
	public String opPolaridadeMenor = "Outro";
	public String percentPolaridadeMenor = "5000";

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
		selecionarTipoInd.sendKeys(IConstante.parametrosIndicador.FINALISTICO);
		selecionarTipoInd.sendKeys(Keys.ENTER);
				
		// Preenchimento de campos para TIPO DE INDICADOR FINALISTICO - se for processual comentar as linhas de código abaixo até a linha 57
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

		// Tipo Fonte
		WebElement tipoFonte = driver.findElement(By.id("tipoFonte_chosen"));
		tipoFonte.click();

		WebElement selecionarTipoFonte = driver.findElement(By.xpath(".//*[@id='tipoFonte_chosen']/div/div/input"));
		selecionarTipoFonte.click();
		selecionarTipoFonte.sendKeys(IConstante.parametrosIndicador.OFICIAL);
		selecionarTipoFonte.sendKeys(Keys.ENTER);

		// Tipo Polaridade
		WebElement polaridade = driver.findElement(By.id("polaridade_chosen"));
		polaridade.click();

		WebElement selecionarPolaridade = driver.findElement(By.xpath(".//*[@id='polaridade_chosen']/div/div/input"));
		selecionarPolaridade.click();
		selecionarPolaridade.sendKeys(IConstante.parametrosIndicador.MENOR_MELHOR);
		selecionarPolaridade.sendKeys(Keys.ENTER);

		// Preenchimento de campos para polaridade QUANTO MENOR MELHOR, se for Maior Melhor, comentar as linhas de código abaixo, até a linha 92:
		WebElement polaridadeMenorMelhor = driver.findElement(By.id("percentualQuandoPolaridadeMenorMelhorEValorZero_chosen"));
		polaridadeMenorMelhor.click();

		WebElement opcaoPolaridadeMenor = driver.findElement(By.xpath(".//*[@id='percentualQuandoPolaridadeMenorMelhorEValorZero_chosen']/div/div/input"));
		opcaoPolaridadeMenor.click();
		opcaoPolaridadeMenor.sendKeys(opPolaridadeMenor);
		opcaoPolaridadeMenor.sendKeys(Keys.TAB);

		// Informar o percentual de cumprimento para indicador dispensado
		WebElement percentualPolaridadeMenor = driver.findElement(By.id("percentualCumprimentoQuandoPolaridadeMenorMelhorEValorZero"));
		percentualPolaridadeMenor.click();
		percentualPolaridadeMenor.sendKeys(percentPolaridadeMenor);
		Thread.sleep(2000);

		// Meses da media movel
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
		selecionarPrograma.sendKeys(IConstante.parametrosIndicador.PROGRAMA);
		selecionarPrograma.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// Descricao
		WebElement descricao = driver.findElement(By.id("descricao"));
		descricao.click();
		descricao.sendKeys(desc);

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
		percentMaiorCem.sendKeys(percent);

		// Avancar para aba de Variaveis
		WebElement avancar = driver.findElement(By.id("btnSalvar1"));
		avancar.click();

	}

}
