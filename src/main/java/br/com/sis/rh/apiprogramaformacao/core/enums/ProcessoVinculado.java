package br.com.sis.rh.apiprogramaformacao.core.enums;

public enum ProcessoVinculado {
	
	NAO(0),
	SIM(1);

	private Integer codigo;

	private ProcessoVinculado(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
}
