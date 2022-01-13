package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.model.Perfil;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.PerfilDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import br.com.sis.rh.apiprogramaformacao.core.ad.ConnectAD;
import br.com.sis.rh.apiprogramaformacao.core.repository.LoginADRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.PerfilRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        LOGGER.info("foi adicionada a matrícula: " + matricula.getMatricula());
        return matricula;
        
    }

    public ResponseEntity<LoginADDto> deletaMatricula(String matricula) {

        Optional<LoginAD> optional = loginADRepository.findById(matricula);

        if (optional.isPresent()){
            loginADRepository.delete(optional.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    public List<PerfilDto> getPerfis() {
        List<Perfil> perfis = perfilRepository.findAll();
        return PerfilDto.converter(perfis);
    }
}
