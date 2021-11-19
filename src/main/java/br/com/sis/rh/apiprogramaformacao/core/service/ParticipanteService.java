package br.com.sis.rh.apiprogramaformacao.core.service;


import br.com.sis.rh.apiprogramaformacao.api.model.Investimentos;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InvestimentosRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.InvestimentoFolhaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    private InvestimentoFolhaRepository folhaRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    InvestimentosRepository investimentosRepository;

    public List<FiltragemFolhaDto> listagemFiltroFolha(String nomeFormacao, String nomeTurma){
        String nomeTurmaFormatado = nomeTurma.replace("+", " "); // pesquisa no banco
        return folhaRepository.findByNomeFormacaoTurmaBolsa(nomeFormacao, nomeTurmaFormatado);
    }

    public void cadastrar(FolhaForm folhaForm){
        System.out.println(folhaForm.getCpf());
        Optional<Participante> optionalParticipante = participanteRepository.findById(folhaForm.getCpf());
        if (optionalParticipante.isPresent()){
            System.out.println("entrei aqui");
            Investimentos investimento = FolhaForm.converter(folhaForm, optionalParticipante.get());
            investimentosRepository.save(investimento);
        }


    }

    public List<CpfParticipanteNomeDto> listagemParticipantes(String nomeFormacao, String nomeTurma){
//        List<Participante> listaParticipantes = ;
        return folhaRepository.findByCpf(nomeFormacao, nomeTurma);
    }
}
