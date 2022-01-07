package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.InvestimentoInstrutorRepository;

@Service
public class InvestimentoInstrutorService {

    @Autowired
    private InvestimentoInstrutorRepository investimentoInstrutorRepository;

    public List<FiltragemInstrutorDto> listagemFiltroInstrutor(String nomeFormacao, String nomeTurma){
        return investimentoInstrutorRepository.findByNomeFormacaoTurmaHora(nomeFormacao, nomeTurma);
    }
}
