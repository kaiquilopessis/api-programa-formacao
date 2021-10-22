package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioConclusaoVO;
import br.com.sis.rh.apiprogramaformacao.core.util.DataConfiguration;

@RestController
@RequestMapping("/conclusao")
@CrossOrigin
public class conclusãoController {

//	@Autowired
//	private conclusãoRepository ConclusaoRepository;
	
//	@GetMapping("/{programa}/{turma}")
//	public Integer PartAtivos() {
//		List<Participante> participantesAtivos = conclusãoRepository.findAllByParticipanteStatus(status);
//		return participantesAtivos;
//	} 
	
	@Autowired
	private DataConfiguration formatacaoData;
	
	@GetMapping()
	public RelatorioConclusaoVO partAtivos() {
		RelatorioConclusaoVO conclusao = new RelatorioConclusaoVO("Java","Java-01",35,14,LocalDate.now());
		return conclusao;
	}

}
