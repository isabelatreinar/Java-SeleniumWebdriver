package br.com.marph.selenium.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.marph.selenium.enums.EnumMensagensLog;
import br.com.marph.selenium.enums.TipoMensagem;

public class LogUtils {
	public static void log(EnumMensagensLog mensagem, Class<?> clazz) {
		Logger log = LogManager.getLogger(clazz.getSimpleName());

		// if(EnumMensagens.INICIO.equals(mensagem)){
		// log.info( "INICIO DO TESTE: " + clazz.getSimpleName());
		// }else
		if (TipoMensagem.VALIDACAO.equals(mensagem.getTipoMensagem())) {
			log.info(mensagem.getMensagem());
		} else if (TipoMensagem.INFO.equals(mensagem.getTipoMensagem())) {
			log.info(mensagem.getMensagem());
		} else if (TipoMensagem.DEBUG.equals(mensagem.getTipoMensagem())) {
			log.debug(mensagem.getMensagem());
		} else {
			log.error(mensagem.getMensagem());
		}
	}
	public static void logError(String mensagem, Class<?> clazz) {
		Logger log = LogManager.getLogger(clazz.getSimpleName());
		log.error(mensagem);
	}
	
}
