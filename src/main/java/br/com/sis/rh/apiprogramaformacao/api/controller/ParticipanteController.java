package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteExibeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.core.service.ParticipanteService;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

	@Autowired
    private ParticipanteService participanteService;

	@GetMapping
    public ResponseEntity<List<ParticipanteBuscaVo>> getPadrao(){
        List<Participante> listaParticipante = participanteService.todosParticipantes();
        List<ParticipanteBuscaVo> participanteBuscaVos = ParticipanteBuscaVo.converterLista(listaParticipante);

        return ResponseEntity.ok(participanteBuscaVos);
    }
	
	@GetMapping("/{cpf}")
	public ParticipanteExibeDto participanteExibe(@PathVariable String cpf ) {
		return new ParticipanteExibeDto(participanteService.participanteCpf(cpf));
	}
	
	@PutMapping("/{cpf}")
	@Transactional
	public ResponseEntity<ParticipanteExibeDto> atualizaParticipante(@PathVariable String cpf, @RequestBody AtualizaParticipanteForm form){
		Participante participante = participanteService.atualizaParticipante(cpf, form);
		return ResponseEntity.ok().body(new ParticipanteExibeDto(participante));
	}
}
