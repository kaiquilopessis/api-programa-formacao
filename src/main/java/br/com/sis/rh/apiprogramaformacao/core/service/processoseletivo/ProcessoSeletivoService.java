package br.com.sis.rh.apiprogramaformacao.core.service.processoseletivo;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaDeProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo.ProcessoSeletivoRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.permissoes.MatriculaService;

@Service
public class ProcessoSeletivoService {

    private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

    @Autowired
    private ProcessoSeletivoRepository repository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<ListaDeProcessoSeletivoDto> getExibeListaDeProcessos() {
        List<ProcessoSeletivo> listaDeProcessos = repository.findTodosEmAndamento("EM_ANDAMENTO");

        return ListaDeProcessoSeletivoDto.gerarLista(listaDeProcessos);
    }

    public List<ProcessoSeletivoVo> listarProcesso(){
        List<ProcessoSeletivo> lista = repository.findAllByStatusAndProcessoVinculado("FINALIZADA", 0);
        return ProcessoSeletivoVo.converter(lista);
    }

    public ProcessoSeletivoDto getProcessoSeletivo(Long id) {
        Optional<ProcessoSeletivo> optional = repository.findById(id);
        if (optional.isPresent()){
            ProcessoSeletivo processoSeletivo = optional.get();
            return new ProcessoSeletivoDto(processoSeletivo);
        }
        return null;
    }
    public ProcessoSeletivoNomeDto getNomeProcessoSeletivo(Long id) {
        Optional<ProcessoSeletivo> optional = repository.findById(id);
        if (optional.isPresent()){
            ProcessoSeletivo processoSeletivo = optional.get();
            return new ProcessoSeletivoNomeDto(processoSeletivo);
        }
        return null;
    }
    public ResponseEntity<ProcessoSeletivoDto> criaNovoProcessoSeletivo(ProcessoSeletivoForm form) {
    	
    	ProcessoSeletivo processoSeletivoCriado = repository.findByNome(form.getNome());
    	if(processoSeletivoCriado != null) {
    		return ResponseEntity.badRequest().build();
    	}
    	
        ProcessoSeletivo processoSeletivo = form.converter(instrutorRepository);
        repository.save(processoSeletivo);

        LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " criou o novo processo seletivo: " + processoSeletivo.getId() + " - " + processoSeletivo.getNome());
        
        URI uri = UriComponentsBuilder.newInstance().path("/api/processo-seletivo/{id}").buildAndExpand(processoSeletivo.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new ProcessoSeletivoDto(processoSeletivo));
    }

    public ResponseEntity<ProcessoSeletivoDto> atualizaProcessoExistente(AtualizaProcessoSeletivoForm form, Long id) {
        Optional<ProcessoSeletivo> optionalProcessoSeletivo = repository.findById(id);

        if(optionalProcessoSeletivo.isPresent()){
            ProcessoSeletivo processoSeletivo = form.atualiza(optionalProcessoSeletivo.get(), repository, instrutorRepository);
            LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " atualizou informa????es do processo seletivo: " + processoSeletivo.getId() + " - " + processoSeletivo.getNome());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public List<ProcessoSeletivoVo> buscaProgramas() {

        List<ProcessoSeletivo> processosFinalizados =  repository.findAllByStatus("FINALIZADA");
        return ProcessoSeletivoVo.converter(processosFinalizados);
    }

	public ResponseEntity excluiProcessoSeletivo(Long id) {
		ProcessoSeletivo processoSeletivo = repository.getById(id);
		processoSeletivo.setStatus(String.valueOf(StatusProcessoSeletivo.EXCLUIDO));
		repository.save(processoSeletivo);
		return ResponseEntity.ok().build();
	}
}
