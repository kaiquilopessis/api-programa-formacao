package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioConclusaoVO;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.DataConfiguration;

@RestController
@RequestMapping("/conclusao")
@CrossOrigin
public class ConclusaoController {

//	@Autowired
//	private conclusãoRepository ConclusaoRepository;
	
//	@GetMapping("/{programa}/{turma}")
//	public Integer PartAtivos() {
//		List<Participante> participantesAtivos = conclusãoRepository.findAllByParticipanteStatus(status);
//		return participantesAtivos;
//	} 
	
//	@Autowired
//	private DataConfiguration formatacaoData;
//	
//	@GetMapping()
//	public RelatorioConclusaoVO partAtivos() {
//		RelatorioConclusaoVO conclusao = new RelatorioConclusaoVO("Java","Java-01",35,14,LocalDate.now());
//		return conclusao;
//	}

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@GetMapping("/total")
	public Integer PartAtivos(){
		List<Participante> partAtivos = participanteRepository.findAll();
		return partAtivos.size();
	}
	public Integer PartEfetivados(){
		List<Participante> partAtivos = participanteRepository.findAll();
		return partAtivos.size();
	}
}
