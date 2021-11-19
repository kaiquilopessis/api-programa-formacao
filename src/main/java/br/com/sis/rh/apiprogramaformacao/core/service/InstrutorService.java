package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Investimentos;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao_Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InstrutorForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.InvestimentoInstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoInstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InstrutorService {

    @Autowired
    private InvestimentoInstrutorRepository investimentoInstrutorRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    RemuneracaoInstrutorRepository remuneracaoInstrutorRepository;

    public List<FiltragemInstrutorDto> listagemFiltroInstrutor(String nomeFormacao, String nomeTurma){
        String nomeTurmaFormatado = nomeTurma.replace("+", " "); // pesquisa no banco
        return investimentoInstrutorRepository.findByNomeFormacaoTurmaHora(nomeFormacao, nomeTurmaFormatado);
    }

    public void cadastrar(InstrutorForm instrutorForm){
        Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(instrutorForm.getCpf());
        if (optionalInstrutor.isPresent()){
            Remuneracao_Instrutor remuneracaoInstrutor = InstrutorForm.converter(instrutorForm, optionalInstrutor.get());
            remuneracaoInstrutorRepository.save(remuneracaoInstrutor);
        }
    }

    public List<CpfInstrutorNomeDto> listagemInstrutores(String nomeFormacao, String nomeTurma){
        return investimentoInstrutorRepository.findByCpf(nomeFormacao, nomeTurma);
    }

}
