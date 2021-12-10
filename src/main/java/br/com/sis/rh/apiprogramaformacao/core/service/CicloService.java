package br.com.sis.rh.apiprogramaformacao.core.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.Ciclo;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloFinalDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioConclusaoVO;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloFinalForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloProgressivoForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.CicloRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.DataConfiguration;

@Service
public class CicloService {

	@Autowired
	private CicloRepository conclusaoRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private RemuneracaoRepository remuneracaoRepository;
	
	@Autowired
	private ProgramaRepository programaRepository;
	
	@Autowired
	private DataConfiguration dataConfiguration;

	public List<CicloDto> listarConclusoes(String cpf) {
		List<Ciclo> conclusoes = conclusaoRepository.findAllByParticipanteCpf(cpf);
		return CicloDto.converter(conclusoes);
	}

	public ResponseEntity<CicloFinalDto> registrarCicloFinal(String cpf, CicloFinalForm conclusaoFinalForm,
			UriComponentsBuilder uriComponentsBuilder){
		Optional<Participante> participante = participanteRepository.findById(cpf);
		try {
			if (participante.isPresent()) {
				Ciclo conclusaoFinal = conclusaoFinalForm.converter(participante.get());
				conclusaoRepository.save(conclusaoFinal);
				URI uri = uriComponentsBuilder.path("/conclusoes/registrociclofinal/{id}")
						.buildAndExpand(conclusaoFinal.getId()).toUri();
				return ResponseEntity.created(uri).body(new CicloFinalDto(conclusaoFinal));
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			System.out.println("Erro no input do arquivo");
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	public ResponseEntity<CicloDto> registrarCicloProgressivo(String cpf,
			CicloProgressivoForm conclusaoProgressivaForm, UriComponentsBuilder uriComponentsBuilder) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		try {

			if (participante.isPresent()) {
				Ciclo conclusaoProgressiva = conclusaoProgressivaForm.converter(participante.get(),
						remuneracaoRepository);
				conclusaoRepository.save(conclusaoProgressiva);
				URI uri = uriComponentsBuilder.path("/conclusoes/registrocicloprogressivo/{id}")
						.buildAndExpand(conclusaoProgressiva.getId()).toUri();
				return ResponseEntity.created(uri).body(new CicloDto(conclusaoProgressiva));
			}
			return ResponseEntity.notFound().build();

		} catch (IOException e) {
			System.out.println("Erro no input do arquivo");
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	public List<RemuneracaoProgramaDto> listarRemuneracao() {
		List<Remuneracao> remuneracaoPrograma = remuneracaoRepository.findAll();
		return RemuneracaoProgramaDto.converter(remuneracaoPrograma);
	}

	public ResponseEntity<ByteArrayResource> download(Long id) {
		Ciclo comprovante = conclusaoRepository.getById(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf"))
				.header("Content-Disposition", "attachment; filename=\"Comprovante-" + comprovante.getParticipante().getCandidato().getNome() + "-"  + id + ".pdf\"")
				.body(new ByteArrayResource(comprovante.getComprovanteRematricula()));
	}
	
	public RelatorioConclusaoVO popularCards(String formacao, String turma) {
		String turmaFormatada = turma.replace("+", " ");
		
		RelatorioConclusaoVO relatorioConclusaoVO = new RelatorioConclusaoVO();
		relatorioConclusaoVO = partAtivos(formacao, turmaFormatada, relatorioConclusaoVO);
		relatorioConclusaoVO = partEfetivados(formacao, turmaFormatada, relatorioConclusaoVO);
		relatorioConclusaoVO = dataConclusao(formacao, turmaFormatada, relatorioConclusaoVO);
		
		relatorioConclusaoVO.setProgramadeformacao(formacao);
		relatorioConclusaoVO.setTurma(turmaFormatada);
		
		return relatorioConclusaoVO;
	}
	
	public RelatorioConclusaoVO partAtivos(String formacao, String turma, RelatorioConclusaoVO relatorio) {
		Integer totalAtivos = participanteRepository.listaParticipantesAtivos(formacao, turma);
		relatorio.setParticipantesAtivos(totalAtivos);
		return relatorio;
	}
	
	public RelatorioConclusaoVO partEfetivados(String formacao, String turma, RelatorioConclusaoVO relatorio) {
		Integer totalEfetivados = participanteRepository.listaParticipantesEfetivados(formacao, turma);
		relatorio.setParticipantesEfetivados(totalEfetivados);
		return relatorio;
	}
	
	public RelatorioConclusaoVO dataConclusao(String formacao, String turma, RelatorioConclusaoVO relatorio) {
		LocalDate dataFim = programaRepository.dataConclusao(formacao, turma);
		String data = dataConfiguration.dataFormatada(dataFim);
		relatorio.setDataConclusao(data);
		
		return relatorio;
	}

}
