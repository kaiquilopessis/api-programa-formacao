package br.com.sis.rh.apiprogramaformacao.core.enums;

public enum BooleanEnum {
	ATIVO(1),
	INATIVO(0);
	
	private Integer codigo;

	private BooleanEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	
}
