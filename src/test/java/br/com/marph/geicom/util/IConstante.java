package br.com.marph.geicom.util;

public interface IConstante {

	interface Parametro {
		Long DEFAULT_WAIT = 5L;
		Long LONG_WAIT = 10L;
	}

	interface Url {
		String LOGIN = "http://172.16.10.115:8080/public/login";

	}

	interface acessarSistema {
		String BOTAO_ACESSAR = "btnAcessar";
		String BOTAO_CONFIRMAR = "confirmarDados";
		String BOTAO_ACESSAR_PERFIL = "acessarSistema";
	}

}
