package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidatoParticipante;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProgramaUsuario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;

//Modelo para acessar o sistema
@Entity
@Table(name = "TB_USUARIO_ACESSO")
@Getter
@Setter
public class Usuario {

	@Id
	@Column(name = "usuario_AD", nullable = false, length = 50)
	private String usuarioAd;
	@Column(name = "email", length = 100)
	private String email;
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusProgramaUsuario status;
	@Column(name = "senha_criptografada", length = 20, nullable = false)
	private String senha;
	@Column(name = "data_inclusao")
	private LocalDate dataInclusao;
}
