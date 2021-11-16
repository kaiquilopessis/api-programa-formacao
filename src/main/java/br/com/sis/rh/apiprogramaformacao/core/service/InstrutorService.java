package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<FiltragemInstrutorDto> listagemFiltroInstrutor(String nomeFormacao, String nomeTurma){
        List<FiltragemInstrutorDto> instrutores = instrutorRepository.findByNomeFormacaoTurmaHora(nomeFormacao, nomeTurma);
        return instrutores;
    }

}
