package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.Formacao;
import br.com.sis.rh.apiprogramaformacao.api.vo.Participante;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@RestController
@CrossOrigin
@RequestMapping("/busca")
public class BuscaController {
	
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	
	
	@GetMapping("/participantes/{statusPart}")
	public List<Participante> listarPart(@PathVariable Boolean statusPart) {
		List<Participante> participantes = participanteRepository.findByStatus(statusPart);
		return participantes;
	}
	
//	@GetMapping("participantes/programa/{status}")
//	public List<Formacao> listar(@PathVariable Boolean status){
//		List<>
//		return 
//	}
}
