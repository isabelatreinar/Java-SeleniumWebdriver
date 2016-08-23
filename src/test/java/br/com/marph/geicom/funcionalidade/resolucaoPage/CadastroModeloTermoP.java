package br.com.marph.geicom.funcionalidade.resolucaoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import br.com.marph.geicom.util.SeleniumUtil;

public class CadastroModeloTermoP {

	private static final String STATUS = ".//*[@id='janelaEntrada_0']/table/tbody/tr/td/table[2]/tbody/tr[3]/td[2]";
	private static final String BTN_VALIDAR_TERMOS = "html/body/div[2]/table/tbody/tr[2]/td[2]/div[4]/form/div/table/tbody/tr[4]/td/button";
	private static final String BTN_VOLTAR_TERMOS = "html/body/div[2]/table/tbody/tr[2]/td[2]/div[4]/form/div/div[2]/button";
	private static final String RODAPE_FORMALIZACAO = ".//*[@id='main_0']/div";
	private static final String LINK_TORNAR_VIGENTE = "html/body/div[2]/table/tbody/tr[2]/td[2]/div[4]/form/div/div[2]/div/div[1]/div[1]/p[5]/a";
	private static final String BTN_OK_POPUP = "popup_ok";
	private static final String BTN_FORMALIZAR_TERMOS = "html/body/div[2]/table/tbody/tr[2]/td[2]/div[4]/form/div/div[3]/div[2]/button[2]";
	private static final String BTN_SALVAR = "html/body/div[2]/table/tbody/tr[2]/td[2]/div[4]/form/div/div[3]/div[2]/button[1]";
	private static final String TXTAREA_TERMO_METAS = "tMeta";
	private static final String TXTAREA_TERMO_COMPROMISSO = "tCompromisso";
	private static final String BTN_EDITAR = BTN_SALVAR;
	private static final String LINK_MODELO_TERMOS = "html/body/div[2]/table/tbody/tr[2]/td[2]/div[4]/form/div/div[2]/div/div[1]/div[1]/p[2]/a";
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	private final String textoTermoCompromisso = "Texto do termo de compromisso!!";
	private final String textoTermoMetas = "Texto do termo de metas!!";
	private final String textoFormalizado = "Os termos foram formalizados.";
	private final String statusTermo = "Vigente";

	public CadastroModeloTermoP(WebDriver driver) {
		this.driver = driver;
	}
	
	/**Criei 3 métodos na mesma classe pois são todas ações da mesma página!!!**/
	
	public void cadastrarModeloTermo() {

		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementXpath(driver, LINK_MODELO_TERMOS);

		seleniumUtil.clickElementXpath(driver, BTN_EDITAR);

		seleniumUtil.clickElementId(driver, TXTAREA_TERMO_COMPROMISSO);
		seleniumUtil.sendKeysId(driver, TXTAREA_TERMO_COMPROMISSO, textoTermoCompromisso);

		seleniumUtil.clickElementId(driver, TXTAREA_TERMO_METAS);
		seleniumUtil.sendKeysId(driver, TXTAREA_TERMO_METAS, textoTermoMetas);

		seleniumUtil.clickElementXpath(driver, BTN_SALVAR);
	}

	public void formalizarTermo() {
		
		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementXpath(driver, BTN_FORMALIZAR_TERMOS);

		seleniumUtil.clickElementId(driver, BTN_OK_POPUP);
		//validação:
		assertEquals(textoFormalizado, driver.findElement(By.xpath(RODAPE_FORMALIZACAO)).getText());
		
		seleniumUtil.clickElementXpath(driver, BTN_VOLTAR_TERMOS);

	}

	public void tornarVigente() {
		
		seleniumUtil = SeleniumUtil.getInstance();

		seleniumUtil.clickElementXpath(driver, LINK_TORNAR_VIGENTE);
		
		seleniumUtil.clickElementXpath(driver, BTN_VALIDAR_TERMOS);
		
		//validação:
		assertEquals(statusTermo, driver.findElement(By.xpath(STATUS)).getText());
	}

}
