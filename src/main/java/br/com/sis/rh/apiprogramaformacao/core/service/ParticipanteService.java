package br.com.sis.rh.apiprogramaformacao.core.service;


import br.com.sis.rh.apiprogramaformacao.api.model.Investimentos;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InvestimentosRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    InvestimentosRepository investimentosRepository;

    public List<FiltragemFolhaDto> listagemFiltroFolha(String nomeFormacao, String nomeTurma){
        String nomeTurmaFormatado = nomeTurma.replace("+", " "); // pesquisa no banco
        return participanteRepository.findByNomeFormacaoTurmaBolsa(nomeFormacao, nomeTurmaFormatado);
    }

    public void cadastrar(FolhaForm folhaForm){
        Participante participante = participanteRepository.findByNome(folhaForm.getNome());
        Investimentos investimento = FolhaForm.converter(folhaForm, participante);
        investimentosRepository.save(investimento);
    }
}
