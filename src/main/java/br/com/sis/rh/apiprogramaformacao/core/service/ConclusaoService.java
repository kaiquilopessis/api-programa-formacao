package br.com.sis.rh.apiprogramaformacao.core.service;

import java.io.IOException;
import java.net.URI;
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
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloFinalDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ConclusaoFinalForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ConclusaoProgressivaForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.CicloRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoProgramaRepository;

@Service
public class ConclusaoService {

	@Autowired
	private CicloRepository conclusaoRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private RemuneracaoProgramaRepository remuneracaoProgramaRepository;

	public List<CicloDto> listarConclusoes(String cpf) {
		List<Ciclo> conclusoes = conclusaoRepository.findAllByParticipanteCpf(cpf);
		return CicloDto.converter(conclusoes);
	}

	public ResponseEntity<CicloFinalDto> registrarCicloFinal(String cpf, ConclusaoFinalForm conclusaoFinalForm,
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
			ConclusaoProgressivaForm conclusaoProgressivaForm, UriComponentsBuilder uriComponentsBuilder) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		try {

			if (participante.isPresent()) {
				Ciclo conclusaoProgressiva = conclusaoProgressivaForm.converter(participante.get(),
						remuneracaoProgramaRepository);
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
		List<RemuneracaoPrograma> remuneracaoPrograma = remuneracaoProgramaRepository.findAll();
		return RemuneracaoProgramaDto.converter(remuneracaoPrograma);
	}

	public ResponseEntity<ByteArrayResource> download(Long id) {
		Ciclo comprovante = conclusaoRepository.getById(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf"))
				.body(new ByteArrayResource(comprovante.getComprovanteRematricula()));
	}

}
