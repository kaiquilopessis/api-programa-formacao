package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.Remuneracao;


public class ListaRemuneracaoDto {

    private Long id;
    private String cargo;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public ListaRemuneracaoDto(Remuneracao remuneracao){
        this.id = remuneracao.getId();
        this.cargo = remuneracao.getCargo();
    }

    public static List<ListaRemuneracaoDto> converterLista(List<Remuneracao> remuneracoes){
        return remuneracoes.stream().map(ListaRemuneracaoDto::new).collect(Collectors.toList());
    }
}
