package br.com.sis.rh.apiprogramaformacao.core.service;


import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<FiltragemDto> listagemFiltro(String nomeParticipante, String nomeFormacao, String nomeTurma, BigDecimal bolsaAux){
        return participanteRepository.findByNomeFormacaoTurmaBolsa(nomeParticipante, nomeFormacao, nomeTurma, bolsaAux);
    }

    public List<FiltragemDto> listagemFiltroTodos(){
        return participanteRepository.findByNomeFormacaoTurmaBolsaTodos();
    }



}
