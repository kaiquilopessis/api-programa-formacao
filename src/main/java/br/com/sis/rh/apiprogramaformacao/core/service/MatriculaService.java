package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.LoginADRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
