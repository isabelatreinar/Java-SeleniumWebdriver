package br.com.marph.geicom.util;

public interface IConstante {
	
	interface Parametro {
		Long DEFAULT_WAIT = 5L;
		Long LONG_WAIT = 10L;		
	}
	
	interface Url {
		String LOGIN = "http://172.16.10.115:8081/public/login";

	}

	interface acessarSistema {
		String BOTAO_ACESSAR = "btnAcessar";
		String BOTAO_CONFIRMAR =  "confirmarDados";
		String BOTAO_ACESSAR_PERFIL = "acessarSistema";
	}
	
	interface parametrosIndicador{
		
		String OFICIAL = "oficial";
		String DECLARATORIO = "Declaratório";
		String FINALISTICO = "Finalístico";
		String PROCESSUAL = "Processual";
		String MAIOR_MELHOR = "maior";
		String MENOR_MELHOR = "menor";
		String PROGRAMA = "Samu";
		
	}

}
