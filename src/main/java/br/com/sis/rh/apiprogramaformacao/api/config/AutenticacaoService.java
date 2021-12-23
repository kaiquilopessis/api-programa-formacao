package br.com.sis.rh.apiprogramaformacao.api.config;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.model.UsuarioAcesso;
import br.com.sis.rh.apiprogramaformacao.core.repository.LoginADRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.UsuarioAcessoRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioAcessoRepository repository;
    
    @Autowired
    private LoginADRepository loginADRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LoginAD> optUsuario = loginADRepository.findById(username);

        if(optUsuario.isPresent()){
            return optUsuario.get();
        }

        throw new UsernameNotFoundException("Dados inválidos");
    }

    public void salvaUsuario(UsuarioAcesso usuario){

        usuario.setUsuarioAd(usuario.getUsuarioAd());
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        usuario.setEmail(usuario.getUsuarioAd()+"@sisconsultoria.com.br");
        usuario.setStatus("ATIVO");
        usuario.setDataInclusao(LocalDate.now());

        repository.save(usuario);
    }
}
