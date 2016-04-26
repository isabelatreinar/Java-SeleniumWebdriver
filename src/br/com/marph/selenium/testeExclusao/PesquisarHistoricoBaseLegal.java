package br.com.marph.selenium.testeExclusao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.marph.selenium.base.MenuBaseLegalTemplate;
import br.com.marph.selenium.conexao.AcessoSistema;
import br.com.marph.selenium.conexao.Conexao;
import br.com.marph.selenium.enums.EnumMensagens;
import br.com.marph.selenium.exceptions.TesteAutomatizadoException;
import br.com.marph.selenium.utils.LogUtils;

public class PesquisarHistoricoBaseLegal {
	private final String LOG_NAME = System.getProperty("user.name");
	private WebDriver driver;
	private Logger log = LogManager.getLogger(LOG_NAME);

	@Before
	public void startBrowser() {
		driver = new FirefoxDriver();
		Conexao.ip(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void pesquisarBaseLegal() throws TesteAutomatizadoException {

		LogUtils.log(EnumMensagens.INICIO, this.getClass());
		long timestart = System.currentTimeMillis();

		//Acessar Sistema
		AcessoSistema.perfilAdministrador(driver);
		
		// Acessa menu Base Legal
		MenuBaseLegalTemplate.menuBaseLegal(driver);

		// Realiza pesquisa de uma base
		PesquisarBaseLegal.pesquisar(driver);

		// Acessa a página da base legal selecionada
		VisualizarBaseLegal.visualizar(driver);

		// Acessa Histórico da Base Legal selecionada
		VisualizarHistoricoBaseLegal.visualizar(driver);

		// Acessa a pesquisa do histórico, se houver histórico
		pesquisar(driver);

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

	public static void pesquisar(WebDriver driver) throws TesteAutomatizadoException {

		/*
		 * O sinal de menos é colocado antes da data para a máscara do campo
		 * seja considerada.
		 */
		//data inicial
		// Abrir o dataPicker 
		driver.findElement(By.id("filtroDataInicialHistorico")).click();
		
		//Passando o dataPicker para uma tabela
		WebElement datePickerInicial = driver.findElement(By.xpath("/html/body/div[5]/div[1]"));
		//List<WebElement> rows = datePicker.findElements(By.tagName("tr"));
		List<WebElement> columnsInicial = datePickerInicial.findElements(By.tagName("td"));
		System.out.println("Inicial");
		//Selecionar célula
		for(WebElement cellInicial : columnsInicial){
			if(cellInicial.getText().equals("23")){
				cellInicial.click();
				break;
			}
		}

		//data final
		// Abrir o dataPicker 
		driver.findElement(By.id("filtroDataFinalHistorico")).click();
		System.out.println("Final");
		//Passando o dataPicker para uma tabela
		WebElement datePickerFinal = driver.findElement(By.xpath("/html/body/div[5]/div[1]"));
		//List<WebElement> rows = datePicker.findElements(By.tagName("tr"));
		List<WebElement> columnsFinal = datePickerFinal.findElements(By.tagName("td"));
		//Selecionar célula
		/*for(WebElement cellFinal : columnsFinal){
			if(cellFinal.getText().equals("23")){
				cellFinal.click();
				break;
			}
		}

		//campo Alterado
		driver.findElement(By.xpath("//div[@id='camposBaseLegal_chosen']/ul/li/input")).click();
		driver.findElement(By.xpath("//div[@id='camposBaseLegal_chosen']/ul/li/input")).sendKeys("Arquivo Importado");
		driver.findElement(By.xpath("//div[@id='camposBaseLegal_chosen']/ul/li/input")).sendKeys(Keys.ENTER);

		/*
		 * 1º caso: se possui a mensagem "Resultado não encontrado" -> não
		 * preenche o campo 'Modificado por' 2º caso: se não possui a mensagem
		 * preenche o campo 'Modificado por' 3º caso: verifica se não possui a
		 * mensagem e não possui usuário -> erro na exibição
		 */
		// verifica se possui a mensagem "Resultado não encontrado"
	/*	if (!driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]")).getText()
				.contains("Resultado não encontrado.")) {
			System.out.println(driver.findElements(By.cssSelector(".chosen-results li")).size());
			// verifica se possui usuários, se não possui a mensagem nem
			// usuários -> erro
			if (driver.findElements(By.cssSelector(".chosen-results li")).size() == 0) {
				throw new TesteAutomatizadoException(EnumMensagens.ERRO_HISTORICO, PesquisarHistoricoBaseLegal.class);
			}

			driver.findElement(By.id("usuariosAlteracao_chosen")).click();
			WebElement modificadoPor = driver
					.findElement(By.xpath("//div[@id='usuariosAlteracao_chosen']/div/div/input"));
			modificadoPor.click();
			modificadoPor.sendKeys("Usuário Marph");
			modificadoPor.sendKeys(Keys.ENTER);
		}

		driver.findElement(By.id("btnPesquisar")).click();*/
	}

}
