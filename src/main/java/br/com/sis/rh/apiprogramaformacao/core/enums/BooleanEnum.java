package br.com.sis.rh.apiprogramaformacao.core.enums;

public enum BooleanEnum {
	ATIVO("S"),
	INATIVO("N");
	
	private String codigo;

	private BooleanEnum(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	
}
