package br.com.sis.rh.apiprogramaformacao.core.service;


import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaDeProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProcessoSeletivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoSeletivoService {

    @Autowired
    private ProcessoSeletivoRepository repository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<ListaDeProcessoSeletivoDto> getExibeListaDeProcessos() {
        List<ProcessoSeletivo> listaDeProcessos = repository.findTodosEmAndamento();

        return ListaDeProcessoSeletivoDto.gerarLista(listaDeProcessos);
    }

    public ProcessoSeletivoDto getProcessoSeletivo(Long id) {
        Optional<ProcessoSeletivo> optional = repository.findById(id);
        if (optional.isPresent()){
            ProcessoSeletivo processoSeletivo = optional.get();
            return new ProcessoSeletivoDto(processoSeletivo);
        }
        return null;
    }

    public ProcessoSeletivo criaNovoProcessoSeletivo(ProcessoSeletivoForm form) {
        ProcessoSeletivo processoSeletivo = form.converter(instrutorRepository);
        repository.save(processoSeletivo);

        return processoSeletivo;
    }

    public ProcessoSeletivo atualizaProcessoExistente(AtualizaProcessoSeletivoForm form, Long id) {
        Optional<ProcessoSeletivo> optional = repository.findById(id);

        if(optional.isPresent()){
            ProcessoSeletivo processoSeletivo = form.atualiza(id, repository, instrutorRepository);
            return processoSeletivo;
        }
        return null;
    }
}
