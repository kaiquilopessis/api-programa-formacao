package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.sis.rh.apiprogramaformacao.core.enums.BooleanEnum;

@Entity
@Table(name = "TB_LOGIN_AD")
public class LoginAD implements UserDetails{

	@Id
	private String matricula;
	private LocalDate dataPrimeiroAcesso;
	@Column(name = "ativo")
	private String ativo;

//	public String getMatricula() {
//		return matricula;
//	}
//
//	public LocalDate getDataPrimeiroAcesso() {
//		return dataPrimeiroAcesso;
//	}
//
//	public BooleanEnum getAtivo() {
//		return ativo;
//	}


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

	

}
