package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

import br.com.sis.rh.apiprogramaformacao.api.model.Ciclo;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoCiclo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCiclo;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoProgramaRepository;

<<<<<<< HEAD:src/main/java/br/com/sis/rh/apiprogramaformacao/api/vo/form/CicloProgressivaForm.java
public class CicloProgressivaForm {
=======
public class CicloProgressivoForm {
>>>>>>> 4122612e6506c48f1ada3c5cb2bff90981197aaf:src/main/java/br/com/sis/rh/apiprogramaformacao/api/vo/form/CicloProgressivoForm.java

	private ResultadoCiclo resultado;
	private String dataAlteracao;
	private String cargo;
	private MultipartFile comprovante;

	public ResultadoCiclo getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoCiclo resultado) {
		this.resultado = resultado;
	}

	public String getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public MultipartFile getComprovante() {
		return comprovante;
	}

	public void setComprovante(MultipartFile comprovante) {
		this.comprovante = comprovante;
	}

	public Ciclo converter(Participante participante, RemuneracaoProgramaRepository remuneracaoProgramaRepository) throws IOException {
		LocalDate data = LocalDate.parse(this.dataAlteracao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		RemuneracaoPrograma cargo = remuneracaoProgramaRepository.findByCargo(this.cargo);
<<<<<<< HEAD:src/main/java/br/com/sis/rh/apiprogramaformacao/api/vo/form/CicloProgressivaForm.java
		return new Ciclo(participante, data, cargo, comprovante.getBytes(), resultado, StatusCiclo.PROGRESSIVA);
=======
		return new Ciclo(participante, data, cargo, comprovante.getBytes(), resultado, StatusConclusao.PROGRESSIVA);
>>>>>>> 4122612e6506c48f1ada3c5cb2bff90981197aaf:src/main/java/br/com/sis/rh/apiprogramaformacao/api/vo/form/CicloProgressivoForm.java
	}
}
