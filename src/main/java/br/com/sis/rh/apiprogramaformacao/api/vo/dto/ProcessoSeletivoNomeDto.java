package br.com.sis.rh.apiprogramaformacao.api.vo.dto;


import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;

public class ProcessoSeletivoNomeDto {

    private Long id;
    private String nome;
    private String nomeTurma;
  

    public ProcessoSeletivoNomeDto(ProcessoSeletivo processoSeletivo){
        this.id = processoSeletivo.getId();
        this.nome = processoSeletivo.getNome();
        this.nomeTurma = processoSeletivo.getNomeTurma();
      
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNomeTurma() {
		return nomeTurma;
	}
    
    
}
