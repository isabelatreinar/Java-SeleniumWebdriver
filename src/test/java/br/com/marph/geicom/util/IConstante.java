package br.com.marph.geicom.util;

import java.util.AbstractMap;
import java.util.Map.Entry;

public interface IConstante {

	interface Parametro {
		Long DEFAULT_WAIT = 5L;
		Long LONG_WAIT = 30L;		
	}
	
	interface URI {
		String LOGIN = "http://anotaai-alinesolutions.rhcloud.com/";
	}
	
	/**
	 * Campos do html que permitem a insercao de valores, contem atributos do tipo <code>Map.Entry<String, String></code>
	 * @author gleidson
	 *
	 */
	interface HtmlInput {
		Entry<String, String> EMAIL = new AbstractMap.SimpleEntry<String, String>("email", "anotaai@gmail.com");
		Entry<String, String> SENHA = new AbstractMap.SimpleEntry<String, String>("senha", "10481");
	}
	
	/**
	 * Id dos comandos clicaveis do html
	 * Ex: links e botoes
	 * @author gleidson
	 *
	 */
	interface HtmlCommandId {

		String BOTAO_ACESSO = "btn-access";
		String BOTAO_LOGIN = "btn-login";
		String BOTAO_PROFILE = "btn-profile";
		String BOTAO_SHUTDOWN = "btn-shutdown";
		
	}

	interface ElementId {
		String NOME_PERFIL = "nome-perfil";
	}
	
}
