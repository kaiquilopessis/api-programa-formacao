package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

//    public List<FiltragemInstrutorDto> listagemFiltroInstrutor(String nomeInstrutor, String nomeFormacao, String nomeTurma, BigDecimal valorHoraInstrutor){
//        return instrutorRepository.findByNomeFormacaoTurmaHora(nomeInstrutor, nomeFormacao, nomeTurma, valorHoraInstrutor);
//    }
//
//    public List<FiltragemInstrutorDto> listagemFiltroInstrutorTodos(){
//        return instrutorRepository.findByNomeFormacaoTurmaHoraTodos();
//    }
}
