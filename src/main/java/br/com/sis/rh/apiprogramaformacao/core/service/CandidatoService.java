package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaCandidatoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CandidatoForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato buscaPorId(Long id){
        Optional<Candidato> optionalCandidato = candidatoRepository.findById(id);

        return optionalCandidato.get();
    }

    public List<ListaCandidatoDto> listaTodosDeUmaVaga () {
        List<Candidato> candidatos = candidatoRepository.findAll();
        return ListaCandidatoDto.toListaCandidatoDto(candidatos);
    }

    public Candidato atualizaCandidato(Long id, AtualizaCandidatoForm form){

        Optional<Candidato> optional = candidatoRepository.findById(id);
        if(optional.isPresent()){
            Candidato candidato = form.atualizar(id, candidatoRepository);
            return candidato;
        }
        return null;
    }


    public Candidato criaCandidato(CandidatoForm form){

        Candidato candidato = form.converter();
        candidatoRepository.save(candidato);

        return candidato;
    }
}
