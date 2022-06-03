package br.com.sis.rh.apiprogramaformacao.core.service.acompanhamento;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.Ciclo;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloFinalDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloFinalForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloProgressivoForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.acompanhamento.CicloRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.cargos.RemuneracaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.permissoes.MatriculaService;

@Service
public class CicloService {
	private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

	@Autowired
	private CicloRepository conclusaoRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private RemuneracaoRepository remuneracaoRepository;

	public List<CicloDto> listarConclusoes(String cpf) {
		List<Ciclo> conclusoes = conclusaoRepository.findAllByParticipanteCpf(cpf);
		return CicloDto.converter(conclusoes);
	}

	public ResponseEntity<CicloFinalDto> registrarCicloFinal(String cpf, CicloFinalForm conclusaoFinalForm){
		Optional<Participante> participante = participanteRepository.findById(cpf);
		try {
			if (participante.isPresent()) {
				Ciclo conclusaoFinal = conclusaoFinalForm.converter(participante.get());
				conclusaoRepository.save(conclusaoFinal);
				LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " cadastrou o ciclo final: " + conclusaoFinal.getId()
				+ " para o participante: " + conclusaoFinal.getParticipante().getCpf() + " - " + conclusaoFinal.getParticipante().getCandidato().getNome());
				URI uri = UriComponentsBuilder.newInstance().path("/conclusoes/registrociclofinal/{id}")
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
			CicloProgressivoForm conclusaoProgressivaForm) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		try {

			if (participante.isPresent()) {
				Ciclo conclusaoProgressiva = conclusaoProgressivaForm.converter(participante.get(),
						remuneracaoRepository);
				conclusaoRepository.save(conclusaoProgressiva);
				LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " cadastrou um ciclo progressivo: " + conclusaoProgressiva.getId()
				+ " para o participante: " + conclusaoProgressiva.getParticipante().getCpf() + " - " + conclusaoProgressiva.getParticipante().getCandidato().getNome());
				URI uri = UriComponentsBuilder.newInstance().path("/conclusoes/registrocicloprogressivo/{id}")
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
}
