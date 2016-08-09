package br.com.marph.geicom.enums;

public enum EnumMensagensLog {
	//INICIO("INICIO DA ROTINA", TipoMensagem.INFO),
	CAMPO_OBRIGATORIO("Validação de campo obrigatório faltando - Campo "),  /** Inserir nome do campo*/
	ANO_VIGENCIA_DESABILITADO("Campo 'Ano do inicio da vigencia' desabilitado, com o campo 'Data da publicação' preenchido"),
	BREADCRUMB_INCORRETO("Breadcrumb incorreto."),
	REGISTRO_DUPLICADO("Falta validação de registro já cadastrado - CRUD "),		/** Inserir o nome do CRUD*/
	MODAL_DESABILITADO("Não exibe modal."),
	TOAST_DESABILITADO("Toast desabilitado.\n"),
	ERRO_SALVAR("Erro ao salvar o campo "),		/** Inserir o nome do campo*/
	VALIDACAO_INCORRETA("A validação/mensagem realizada no campo está incorreta."),	/** Inserir o nome do campo, quando houver mais de um campo sendo validado*/
	DADO_INVALIDO("Falta validação de dado inválido inserido - Campo "),   /** Inserir o nome do campo*/
	MENSAGEM_INCORRETA("Mensagem incorreta - "),	/** Inserir o local de exibição da mensagem*/
	OPERACAO_INVALIDA("Operacao inválida."),
	ALTERACAO_STATUS("Erro na alteracao de status - ");		/** Inserir a alteração do status*/

	

	
	private String mensagem;
	private TipoMensagem tipoMensagem;
	
	private EnumMensagensLog(String mensagem) {
		this(mensagem,TipoMensagem.ERRO);
	}
	private EnumMensagensLog(String mensagem, TipoMensagem tipoMensagem) {
		this.mensagem = mensagem;
		this.tipoMensagem = tipoMensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	public TipoMensagem getTipoMensagem() {
		return tipoMensagem;
	}
	

}
