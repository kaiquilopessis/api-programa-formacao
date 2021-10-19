package br.com.sis.rh.apiprogramaformacao.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO_ACESSO")
public class UsuarioAcesso {

	@Id
	@Column(name = "usuario_AD", nullable = false, length = 50)
	private String usuarioAd;
	@Column(name = "email", length = 100)
	private String email;
	@Column(name = "status", nullable = false)
	private long status;
	@Column(name = "senha_criptografada", length = 20, nullable = false)
	private String senha;
	@Column(name = "data_inclusao")
	private LocalDate dataInclusao;
}
