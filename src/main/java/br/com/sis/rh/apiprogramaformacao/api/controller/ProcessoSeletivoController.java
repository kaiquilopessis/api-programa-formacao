package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaDeProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.core.service.ProcessoSeletivoService;

@RestController
@RequestMapping("/api/processo-seletivo")
public class ProcessoSeletivoController {

    @Autowired
    private ProcessoSeletivoService processoSeletivoService;

    //Lista todos os processos seletivos
   @GetMapping
    public List<ListaDeProcessoSeletivoDto> listaTodosOsProcessos () {
        return processoSeletivoService.getExibeListaDeProcessos();
   }

   //Visualiza um processo seletivo
   @GetMapping("/{id}")
    public ProcessoSeletivoDto retornaUnicoProcessoSeletivo (@PathVariable Long id){
       return processoSeletivoService.getProcessoSeletivo(id);
   }
   // Visualiza só o nome do processo seletivo
   @GetMapping("/nome/{id}")
   public ProcessoSeletivoNomeDto retornaNomeProcessoSeletivo (@PathVariable Long id){
      return processoSeletivoService.getNomeProcessoSeletivo(id);
  }
   //Cria um novo processo seletivo
   @PostMapping
   @Transactional
   public ResponseEntity<ProcessoSeletivoDto> criaNovoProcessoSeletivo (@RequestBody ProcessoSeletivoForm form, UriComponentsBuilder uriBuilder){
       System.out.println(form.getDataFim().getClass()); 
	   ProcessoSeletivo processoSeletivo = processoSeletivoService.criaNovoProcessoSeletivo(form);
        
       URI uri = uriBuilder.path("/api/processo-seletivo/{id}").buildAndExpand(processoSeletivo.getId()).toUri();

       return ResponseEntity.created(uri).body(new ProcessoSeletivoDto(processoSeletivo));
   }

   //Edita um processo seletivo que já existe
   @PutMapping("/{id}")
   @Transactional
   public ResponseEntity<ProcessoSeletivoDto> atualizaProcessoEspecifico (@RequestBody AtualizaProcessoSeletivoForm form, @PathVariable Long id){
       ProcessoSeletivo processoSeletivo = processoSeletivoService.atualizaProcessoExistente(form, id);

       return ResponseEntity.ok().body(new ProcessoSeletivoDto(processoSeletivo));
   }
}
