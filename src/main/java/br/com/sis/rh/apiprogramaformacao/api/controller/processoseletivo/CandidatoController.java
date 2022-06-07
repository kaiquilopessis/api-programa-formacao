package br.com.sis.rh.apiprogramaformacao.api.controller.processoseletivo;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.openApi.CandidatoControllerOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CargoModalDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeTurmaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaModalDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaCandidatoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CandidatoForm;
import br.com.sis.rh.apiprogramaformacao.core.service.processoseletivo.CandidatoService;

@RestController
@RequestMapping("/api/candidato")
public class CandidatoController implements CandidatoControllerOpenApi {

    @Autowired
    private CandidatoService candidatoService;

    //Lista todos os candidatos do banco de dados
    @Override
    @GetMapping("/lista")
    public List<ListaCandidatoDto> listaCandidato(){

        return candidatoService.listaTodosDeUmaVaga();
    }

    //Mostra todos os dados unicos de um candidato
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CandidatoDto> mostrarCandidato(@PathVariable Long id){
        return ResponseEntity.ok(new CandidatoDto(candidatoService.buscaPorId(id)));
    }

    //Mostra todos os candidatos que participam de um processo seletivo especifico
    @Override
    @GetMapping("/lista-do-processo/{id}")
    public List<ListaCandidatoDto> mostraListaCandidatoEmProcesso(@PathVariable Long id){
        return candidatoService.buscaCandidadoPorFormacao(id);
    }

    //Realiza a edição de um candidato
    @Override
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CandidatoDto> atualizarCandidato(@PathVariable Long id, @ModelAttribute AtualizaCandidatoForm form) throws IOException {

        Candidato candidato = candidatoService.atualizaCandidato(id, form);

        return ResponseEntity.ok().body(new CandidatoDto(candidato));
    }

    //Cria um novo candidato e já linka ele a um processo-seletivo
    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<CandidatoDto> inserirCandidato(@ModelAttribute CandidatoForm form, UriComponentsBuilder uriBuilder) throws IOException {

        Candidato candidato = candidatoService.criaCandidato(form);

        URI uri = uriBuilder.path("/api/candidato/{id}").buildAndExpand(candidato.getId()).toUri();

        return ResponseEntity.created(uri).body(new CandidatoDto(candidato));
    }

    //Faz o download  do curriculo de um usuario registrado no banco de dados
    @Override
    @GetMapping("/download-curriculo/{id}")
    public ResponseEntity<ByteArrayResource> downloadCurriculo(@PathVariable Long id){
        return candidatoService.downloadCurriculo(id);
    }

    //Faz o donwload do disc de um usuario registrado previamente no banco de dados
    @Override
    @GetMapping("/download-disc/{id}")
    public ResponseEntity<ByteArrayResource> downloadDisc(@PathVariable Long id){
        return candidatoService.downloadDisc(id);
    }
    
    //Faz uma busca no programa de acordo com o ID do candidato, e retorna nome do programa
    @Override
    @GetMapping("/programa-candidato-nome/{id}")
    public NomeProgramaCandidatoDto listaTurmasEProgramaCandidato (@PathVariable Long id) {
    	return candidatoService.buscarPrograma(id);

    }

    @Override
    @GetMapping("/programa-candidato-turmas/{nomePrograma}")
    public List<NomeTurmaCandidatoDto> listarTurmasPorPrograma(@PathVariable String nomePrograma) {
    	return candidatoService.buscarTurmas(nomePrograma);
    }

    @Override
    @GetMapping("/buscar-instrutor")
    public List<NomeInstrutorDto> listarInstrutoresAtivos(){
        return candidatoService.buscarInstrutoresAtivos();
    }

    @Override
    @GetMapping("/mostrar-cargo/{id}")
    public CargoModalDto mostrarCargo(@PathVariable Long id) {
        return candidatoService.mostrarCargoModal(id);
    }

    @Override
    @GetMapping("/mostrar-turma/{id}")
    public TurmaModalDto mostrarTurma(@PathVariable Long id){
        return candidatoService.mostrarTurmaModal(id);
    }
    
   
}
