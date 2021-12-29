package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.LoginADRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private LoginADRepository loginADRepository;

    public List<LoginADDto> buscarTodos(){
        List<LoginAD> matriculas = loginADRepository.findAll();
        return LoginADDto.converter(matriculas);
    }

    public LoginAD criaMatricula(LoginADForm form) {
        LoginAD matricula = form.converter();
        loginADRepository.save(matricula);
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
}
