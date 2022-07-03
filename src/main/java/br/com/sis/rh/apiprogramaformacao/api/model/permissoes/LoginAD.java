package br.com.sis.rh.apiprogramaformacao.api.model.permissoes;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "TB_LOGIN_AD")
public class LoginAD implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	private String matricula;
	private LocalDate dataPrimeiroAcesso;
	@Column(name = "ativo")
	private String ativo;
	@ManyToOne
	@JoinColumn(name = "fk_perfil")
	private Perfil fk_perfil;

	public LoginAD() {
	}

	public LoginAD(String matricula, Perfil perfil) {
		this.matricula = matricula;
		this.fk_perfil = perfil;
	}

	public String getMatricula() {
		return matricula;
	}

	public LocalDate getDataPrimeiroAcesso() {
		return dataPrimeiroAcesso;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setDataPrimeiroAcesso(LocalDate dataPrimeiroAcesso) {
		this.dataPrimeiroAcesso = dataPrimeiroAcesso;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	@Override
	public String getPassword() {
		return this.ativo;
	}

	@Override
	public String getUsername() {
		return this.matricula;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public Perfil getFk_perfil() {
		return fk_perfil;
	}

	public void setFk_perfil(Perfil fk_perfil) {
		this.fk_perfil = fk_perfil;
	}

}
