package br.com.sis.rh.apiprogramaformacao.core.service.permissoes;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.permissoes.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.model.permissoes.Perfil;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.PerfilDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.permissoes.LoginADRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.permissoes.PerfilRepository;

@Service
public class MatriculaService {
	
	private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

    @Autowired
    private LoginADRepository loginADRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    public List<LoginADDto> buscarTodos(){
        List<LoginAD> matriculas = loginADRepository.findAll();
        return LoginADDto.converter(matriculas);
    }

    public LoginAD criaMatricula(LoginADForm form) {
        LoginAD matricula = form.converter(perfilRepository.findByNome(form.getPerfil()));
        loginADRepository.save(matricula);
        LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " adicionou a matrícula: " + matricula.getMatricula());
        return matricula;
        
    }

    public ResponseEntity<LoginADDto> deletaMatricula(String matricula) {

        Optional<LoginAD> optional = loginADRepository.findById(matricula);

        if (optional.isPresent()){
            loginADRepository.delete(optional.get());
            LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " deletou a matrícula: " + optional.get().getMatricula());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    public List<PerfilDto> getPerfis() {
        List<Perfil> perfis = perfilRepository.findAll();
        return PerfilDto.converter(perfis);
    }
}
