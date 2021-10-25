package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;


    public List<Programa> buscaPorPrograma(String programa){
        List<Programa> listCandidatoPrograma = programaRepository.findByPrograma(programa);

        return listCandidatoPrograma;
    }

    public List<Programa> buscaPorTurma(String nomeTurma){
        List<Programa> listCandidatoTurma = programaRepository.findByTurma(nomeTurma);

        return listCandidatoTurma;
    }



}
