package br.com.marph.geicom.enums;

public enum Enums {

	ADMINISTRADOR("16932"), 
	EQUIPE_GEICOM("5909"), 
	SECRETARIO(""), 
	RESOLUCAO("//td[@onmouseup='cmItemMouseUp (this,4)']"),
	CADASTRO_RESOLUCAO("//td[@onmouseup='cmItemMouseUp (this,4)']");
	

	private String id;
	
	private Enums(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}