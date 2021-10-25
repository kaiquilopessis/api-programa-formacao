package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.CandidatoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneraçãoProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private ProgramaRepository programaRepository;

    @Autowired
    private RemuneraçãoProgramaRepository remuneraçãoProgramaRepository;

    public List<Candidato> todosCandidatos(){
        return candidatoRepository.findAll();
    }

    public Candidato buscaPorId(Long id){
        Optional<Candidato> optionalCandidato = candidatoRepository.findById(id);

        return optionalCandidato.get();
    }

    public List<Candidato> buscaPorNome(String nome) {
        List<Candidato> listCandidatoNome = candidatoRepository.findByNome(nome);

        return listCandidatoNome;
    }



    public void salva(Candidato candidato){
        candidatoRepository.save(candidato);
    }

}
