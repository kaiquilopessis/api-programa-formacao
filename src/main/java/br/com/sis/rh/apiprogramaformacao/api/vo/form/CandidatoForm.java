package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProcessoSeletivoRepository;

public class CandidatoForm {

    private String nome;
    private String telefone;
    private String fonteRecrutamento;
    private String dataAgendamento;
    private String curso;
    private String observacao;
    private String status;
    private BigDecimal testeLogico;
    private MultipartFile curriculo;
    private MultipartFile disc;
    private Long idProcessoSeletivo;
    private String email;
    private String semestreFaculdade;
    private String periodoCurso;
    private String dataConclusao;
    private String duracaoCurso;
    private String endereco;
    private String indicacaoVaga;
    

    public Candidato converter (ProcessoSeletivoRepository repository) throws IOException {

        ProcessoSeletivo processoSeletivo = repository.getById(idProcessoSeletivo);

        LocalDate data = LocalDate.parse(this.dataAgendamento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (this.dataConclusao.equals("")) {
        	
			return new Candidato(nome, telefone, data, testeLogico, status, observacao, curriculo.getBytes(), disc.getBytes(), fonteRecrutamento, processoSeletivo, email, endereco, indicacaoVaga);
		} else{
            LocalDate dataConclusao = LocalDate.parse(this.dataConclusao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return new Candidato(nome, telefone, data, testeLogico, status, observacao, curriculo.getBytes(), disc.getBytes(), fonteRecrutamento, processoSeletivo, email, semestreFaculdade, periodoCurso, dataConclusao, duracaoCurso, endereco, indicacaoVaga);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFonteRecrutamento() {
        return fonteRecrutamento;
    }

    public void setFonteRecrutamento(String fonteRecrutamento) {
        this.fonteRecrutamento = fonteRecrutamento;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTesteLogico() {
        return testeLogico;
    }

    public void setTesteLogico(BigDecimal testeLogico) {
        this.testeLogico = testeLogico;
    }

    public MultipartFile getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(MultipartFile curriculo) {
        this.curriculo = curriculo;
    }

    public MultipartFile getDisc() {
        return disc;
    }

    public void setDisc(MultipartFile disc) {
        this.disc = disc;
    }

    public Long getIdProcessoSeletivo() {
        return idProcessoSeletivo;
    }

    public void setIdProcessoSeletivo(Long idProcessoSeletivo) {
        this.idProcessoSeletivo = idProcessoSeletivo;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSemestreFaculdade() {
		return semestreFaculdade;
	}

	public void setSemestreFaculdade(String semestreFaculdade) {
		this.semestreFaculdade = semestreFaculdade;
	}

	public String getPeriodoCurso() {
		return periodoCurso;
	}

	public void setPeriodoCurso(String periodoCurso) {
		this.periodoCurso = periodoCurso;
	}

	public String getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getDuracaoCurso() {
		return duracaoCurso;
	}

	public void setDuracaoCurso(String duracaoCurso) {
		this.duracaoCurso = duracaoCurso;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getIndicacaoVaga() {
		return indicacaoVaga;
	}

	public void setIndicacaoVaga(String indicacaoVaga) {
		this.indicacaoVaga = indicacaoVaga;
	}
}
