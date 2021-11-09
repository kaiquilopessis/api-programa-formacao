package br.com.sis.rh.apiprogramaformacao.core.service;


import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<FiltragemFolhaDto> listagemFiltroFolha(String nomeFormacao, String nomeTurma){
        String nomeTurmaFormatado = nomeTurma.replace("+", " "); // pesquisa no banco
        return participanteRepository.findByNomeFormacaoTurmaBolsa(nomeFormacao, nomeTurmaFormatado);
    }

//    public List<FiltragemFolhaDto> listagemFiltroFolhaTodos(){
//        return participanteRepository.findByNomeFormacaoTurmaBolsaTodos();
//    }



}
