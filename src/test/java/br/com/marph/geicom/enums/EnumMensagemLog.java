package br.com.marph.geicom.enums;

public enum EnumMensagemLog {
	
	ARQUIVO_NÃO_ENCONTRADO("Arquivo não encontrado!");
	

	
	
	private String mensagem;
//	private TipoMensagem tipoMensagem;
	
	private EnumMensagemLog(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getMensagem() {
		return mensagem;
	}

	

}
