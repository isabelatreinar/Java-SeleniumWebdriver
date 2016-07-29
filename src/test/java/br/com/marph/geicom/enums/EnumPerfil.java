package br.com.marph.geicom.enums;

public enum EnumPerfil {

	ADMINISTRADOR("16932"), 
	EQUIPE_GEICOM("5909"), 
	SECRETARIO("");
	

	private String id;
	
	private EnumPerfil(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}