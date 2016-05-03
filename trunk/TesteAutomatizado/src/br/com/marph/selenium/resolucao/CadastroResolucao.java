package br.com.marph.selenium.resolucao;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagensLog;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.AcessoUtils;
import br.com.marph.selenium.utils.LogUtils;

public class CadastroResolucao {
	private final String LOG_NAME = System.getProperty("user.name");
	private WebDriver driver;
	private Logger log = LogManager.getLogger(LOG_NAME);
	JavascriptExecutor js;
	String nomeIndicador = "teste";
	String baseLegal = "1016";
	
	
	
	@Before
	public void startBrowser() {
		driver = new FirefoxDriver();
		Conexao.ip(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void realizaBusca() throws InterruptedException, TesteAutomatizadoException, IOException {

		LogUtils.log(EnumMensagensLog.INICIO, this.getClass());

		long timestart = System.currentTimeMillis();

		MenuResolucaoTemplate.prepararAcessoResolucao(driver);

		// cadastra resolucao
		cadastrarResolucao();

		// cadastro de beneficiario
		beneficiarios();

		// cadastro de indicadores.
		indicadores();

		// cadastro de periodo.
		periodo();

		// cadastro de cronograma
		cronograma();
		
		indicadoresXCronograma();
		
		modelosXBeneficiarios();
		
		importacaoDeMetas();
		
		importacaoDeParcelas();

		float tempoGasto = (System.currentTimeMillis() - timestart);
		float tempoSegundos = tempoGasto / 1000;

		StringBuilder sb = new StringBuilder();
		sb.append("Entrada no sistema - ").append(tempoSegundos).append(" segundos - FINALIZADO COM SUCESSO\n");

		if (tempoSegundos > 5000) {
			log.warn(sb.toString() + "\n");
		} else {
			log.info(sb.toString() + "\n");
		}
	}

	protected void cadastrarResolucao() throws TesteAutomatizadoException {
		
		AcessoUtils.idClick(driver, "btnNovaResolucao","programa_chosen");
		
		AcessoUtils.xpathChoosenSend(driver, "//*[@id='programa_chosen']/div/div/input", "Farmácia de Minas",Keys.TAB);
		
		// numero resolucao
		driver.findElement(By.id("baseLegal_chosen")).click();
		driver.findElement(By.xpath("//*[@id='baseLegal_chosen']/div/div/input")).sendKeys(baseLegal);
		driver.findElement(By.xpath("//*[@id='baseLegal_chosen']/div/div/input")).sendKeys(Keys.TAB);

		//seleciona base legal
		driver.findElement(By.xpath("//*[@class='chosen-container chosen-container-multi']")).click();
		driver.findElement(By.xpath("//*[@id='termosBaseLegal_chosen']/div/ul/li[2]")).click();
		
		// tempo
		driver.findElement(By.id("tempoVigencia")).sendKeys("25");

		// tempo
		driver.findElement(By.id("descricao")).sendKeys("Teste TESTE");
		
		AcessoUtils.idClick(driver, "btnSalvar1","btnProximo");
		
	}


	protected void beneficiarios() throws InterruptedException, TesteAutomatizadoException {
		
		//botão para importar
		driver.findElement(By.id("buttonImportarPlanilha")).click();
		
		File arquivo = new File("./data/Geicom/Export.xlsx");
		
		// arquivo
		driver.findElement(By.id("uploadBeneficiariosContemplados"))
				.sendKeys(arquivo.getAbsolutePath());// Export.xlsx

		// importa
		driver.findElement(By.id("buttonImportar")).click();		
		
		 Thread.sleep(6000);			
		
		//proximo 
		driver.findElement(By.id("btnProximo")).click();
			
	}

	protected void indicadores() throws TesteAutomatizadoException, InterruptedException {
		
		try {
			if(driver.findElement(By.id("mensagemNaoPrestacaoMetas")).getText().equalsIgnoreCase("Não é necessário inserir informações nesta aba.")){
				throw new TesteAutomatizadoException(EnumMensagensLog.INDICADOR_FIM, this.getClass());
			}
		} catch (NoSuchElementException e) {
			
		}
		
		// criar
		driver.findElement(By.id("criar")).click();

		// nome
		driver.findElement(By.id("nome")).sendKeys(nomeIndicador);
 
		// INDICADOR
		driver.findElement(By.xpath("//*[@id='collapseNovo']/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@data-label-field='nomeIndicador']")).sendKeys("tes");
		driver.findElement(By.id("ui-id-2")).click();

		// ponto
		driver.findElement(By.xpath("//*[@id='tabelaIndicadoresNovo']/div[2]/div[3]/input")).sendKeys("5000");

		// peso
		driver.findElement(By.xpath("//*[@id='tabelaIndicadoresNovo']/div[2]/div[4]/input")).sendKeys("10000");
		
		
		driver.findElement(By.xpath("//*[@id='tabelaIndicadoresNovo']/div[2]/div[5]/a")).click();
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//*[@id='headingNovo']/ul/li[1]/a")).click();
		
		Thread.sleep(500);

		driver.findElement(By.id("btnProximo")).click();
	}

	protected void periodo() throws TesteAutomatizadoException, InterruptedException {

		driver.findElement(By.xpath("//*[@class='panel-heading']/ul/li[3]/a")).click();
		
		driver.findElement(By.id("numeroPeriodoMonitoramento")).sendKeys("1");
		
		driver.findElement(By.id("periodicidade")).sendKeys("1");
		
		driver.findElement(By.name("dataInicial")).sendKeys("-19102015");
		
		driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[1]/div[4]/a")).click();
		
		Thread.sleep(2500);

		driver.findElement(By.xpath("//*[@class='panel-heading']/ul/li[1]/a")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("btnProximo")).click();
	} 

	protected void cronograma() throws TesteAutomatizadoException, InterruptedException {
		// clica em criar
		driver.findElement(By.id("criarCronograma")).click();

		// coloca o nome
		driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]/span/input")).sendKeys("Teste");

		// defini numero de parcelas
		driver.findElement(By.id("numeroParcelas")).sendKeys("1");
		
		//Periodicidade(Meses)
		driver.findElement(By.id("periodicidade")).sendKeys("1");
		
		//data inicial
		driver.findElement(By.xpath("//*[@id='dataInicial_maindiv']/div/input")).sendKeys("-29112018");		
		
		Thread.sleep(2000);
		
		// clica em atualizar
		driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[2]/div[4]/a")).click();

		// valor padrão
		driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[3]/div[2]/div[3]/input"))
				.sendKeys("200000");

		// percentual fixo
		driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[3]/div[2]/div[4]/input"))
				.sendKeys("1000");

		// percentual de custeio
		driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[3]/div[2]/div[5]/input"))
				.sendKeys("500");
		
		//salva
		driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]/ul/li[1]/a")).click();
		
		Thread.sleep(2000);
		
		//proximo
		driver.findElement(By.id("btnProximo")).click();
	}

	protected void indicadoresXCronograma() throws InterruptedException{
		
		AcessoUtils.xpathClick(driver, "//*[@class='panel-heading']/ul/li[3]/a","//*[@class='chosen-container chosen-container-single']/a/div/b");
		
		AcessoUtils.xpathChoosenSend(driver, "//*[@class='chosen-container chosen-container-single chosen-with-drop chosen-container-active']/div/div/input", "teste",Keys.TAB);
		
		driver.findElement(By.xpath("//*[@class='panel-collapse collapse in']/div/div[2]/ul/li/a")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@class='panel-heading']/ul/li[1]/a")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("btnProximo")).click();
	}
	
	protected void modelosXBeneficiarios() throws InterruptedException{
		
		driver.findElement(By.xpath("//*[@id='toast-container']/button")).click();
		
		driver.findElement(By.id("buttonImportarPlanilha")).click();
		
		driver.findElement(By.id("modeloIndicadorImportar_chosen")).click();
		
		AcessoUtils.xpathChoosenSend(driver, "//*[@id='modeloIndicadorImportar_chosen']/div/div/input", "teste",Keys.TAB);
		
		File arquivo = new File("./data/Geicom/modeloBeneficiarioExport.xlsx");
		
		driver.findElement(By.id("uploadBeneficiariosContemplados")).sendKeys(arquivo.getAbsolutePath());
		
		driver.findElement(By.id("buttonImportar")).click();
		
		Thread.sleep(8000);
		
		driver.findElement(By.id("btnProximo")).click();
		
	}	
		
	public void importacaoDeMetas() throws IOException, InterruptedException{		
		
		driver.findElement(By.id("buttonImportarPlanilha")).click();
		
		File arquivo = new File("./data/Geicom/importacaoMetasExport.xlsx");
		
		driver.findElement(By.id("uploadMetasPactuadas")).sendKeys(arquivo.getAbsolutePath());
		
		driver.findElement(By.id("buttonImportar")).click();
		
		Thread.sleep(20000);
		
		driver.findElement(By.id("btnProximo")).click();
		
		
/*		XSSFWorkbook workbook = null;		
		File arquivo = new File("C:\\Users\\rafael.sad\\Downloads\\importacaoMetasExport.xlsx");		
		FileOutputStream outPut = null;		
		
		try {			
			workbook = new XSSFWorkbook(arquivo);			
			XSSFSheet planilha = workbook.getSheetAt(0);			
			outPut = new FileOutputStream(arquivo);						
//			XSSFRow cabecalho = planilha.getRow(0);
			Random gerador = new Random();			
			for (int i = 1; i < planilha.getLastRowNum() ; i++) {
				XSSFRow linha = planilha.getRow(i);
				Cell celula = linha.createCell(3);
				celula.setCellValue( String.valueOf(gerador.nextInt(100)));
			}
			workbook.write(outPut);			
		} catch (InvalidFormatException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		finally {
			if(outPut != null){
				outPut.close();
			}
			if(workbook != null){
				workbook.close();
			}						
		}*/		
	}	
	
	protected void importacaoDeParcelas() throws InterruptedException{
		
		driver.findElement(By.id("buttonImportarPlanilha")).click();
		
		driver.findElement(By.id("modeloPagamentoImportarPlanilha_chosen")).click();
		driver.findElement(By.xpath("//*[@id='modeloPagamentoImportarPlanilha_chosen']/div/div/input")).sendKeys("Tes");
		driver.findElement(By.xpath("//*[@id='modeloPagamentoImportarPlanilha_chosen']/div/div/input")).sendKeys(Keys.TAB);
		
		File arquivo = new File("./data/Geicom/importacaoParcelasExport.xlsx");
		
		driver.findElement(By.id("uploadValorParcelas")).sendKeys(arquivo.getAbsolutePath());
		
		driver.findElement(By.id("buttonImportar")).click();
		
		driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div/div/div/div[4]/button[1]")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.id("btnFinalizar")).click();
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div/div/div/div[4]/button[1]")).click();
		
	}
}