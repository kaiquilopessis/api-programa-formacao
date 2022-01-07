package br.com.sis.rh.apiprogramaformacao.api.config;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.core.repository.LoginADRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private LoginADRepository loginADRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<LoginAD> optUsuario = loginADRepository.findById(username);

		if (optUsuario.isPresent()) {
			if (optUsuario.get().getDataPrimeiroAcesso() == null) {
				optUsuario.get().setDataPrimeiroAcesso(LocalDate.now());
				loginADRepository.save(optUsuario.get());
			}
			return optUsuario.get();
		}

		throw new UsernameNotFoundException("Dados inválidos");
	}
}
