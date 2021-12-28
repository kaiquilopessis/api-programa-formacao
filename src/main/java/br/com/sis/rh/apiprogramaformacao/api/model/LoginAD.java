package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "TB_LOGIN_AD")
public class LoginAD implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String matricula;
	private LocalDate dataPrimeiroAcesso;
	@Column(name = "ativo")
	private String ativo;
	private Integer nivelAcesso;

	public LoginAD() {}

	public LoginAD(String matricula, Integer nivelAcesso) {
		this.matricula = matricula;
		this.nivelAcesso = nivelAcesso;
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


	@Override
	public String getPassword() {	
		return this.ativo;
	}

	@Override
	public String getUsername() {
		return this.matricula;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
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

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setDataPrimeiroAcesso(LocalDate dataPrimeiroAcesso) {
		this.dataPrimeiroAcesso = dataPrimeiroAcesso;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
}
