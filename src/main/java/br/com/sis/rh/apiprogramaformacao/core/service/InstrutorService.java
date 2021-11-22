package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao_Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AttInstrutorForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InstrutorForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InvestimentoInstrutorForm;
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
    private InstrutorRepository repository;

    @Autowired
    private RemuneracaoInstrutorRepository remuneracaoInstrutorRepository;

    @Autowired
    private InvestimentoInstrutorRepository investimentoInstrutorRepository;

    public List<Instrutor> todosInstrutores(){
        return repository.findAll();
    }

    public Instrutor buscaPorCpf(String id){
        Optional<Instrutor> optionalInstrutor = repository.findById(id);

        return optionalInstrutor.get();
    }

    public List<Instrutor> buscaPorStatus(String status){
        List<Instrutor> listInstrutor = repository.findByStatus(status);

        return listInstrutor;
    }

    public void salva(Instrutor instrutor){
        repository.save(instrutor);
    }

    //Métodos criados por Marco Aguiar

    public List<FiltragemInstrutorDto> listagemFiltroInstrutor(String nomeFormacao, String nomeTurma){
        String nomeTurmaFormatado = nomeTurma.replace("+", " "); // pesquisa no banco
        return investimentoInstrutorRepository.findByNomeFormacaoTurmaHora(nomeFormacao, nomeTurmaFormatado);
    }

    public void cadastrar(InvestimentoInstrutorForm investimentoInstrutorForm){
        Optional<Instrutor> optionalInstrutor = repository.findById(investimentoInstrutorForm.getCpf());
        if (optionalInstrutor.isPresent()){
            Remuneracao_Instrutor remuneracaoInstrutor = InvestimentoInstrutorForm.converter(investimentoInstrutorForm, optionalInstrutor.get());
            remuneracaoInstrutorRepository.save(remuneracaoInstrutor);
        }
    }

    public List<CpfInstrutorNomeDto> listagemInstrutores(String nomeFormacao, String nomeTurma){
        return investimentoInstrutorRepository.findByCpf(nomeFormacao, nomeTurma);
    }

    public boolean alteraInstrutor(AttInstrutorForm attInstrutorForm, String cpf) {
        return attInstrutorForm.atualizaInstrutor(repository, cpf);
    }
}
