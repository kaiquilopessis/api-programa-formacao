package br.com.sis.rh.apiprogramaformacao.core.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.AvaliacoesDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.AvaliacoesForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.AvaliacoesRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
@Service
public class AvaliacoesService {

	@Autowired
	private AvaliacoesRepository avaliacoesRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;


	public List<AvaliacoesDto> listarNotas(String cpf) {
		List<Avaliacoes> listaNotas = avaliacoesRepository.findAllByParticipanteCpf(cpf);
		return AvaliacoesDto.converter(listaNotas);

	}

	public ResponseEntity<AvaliacoesDto> cadastrar(@PathVariable String cpf, @RequestBody AvaliacoesForm avaliacoesForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		if (participante.isPresent()) {
			Avaliacoes avaliacoes = avaliacoesForm.converter(participante.get());
			avaliacoesRepository.save(avaliacoes);
			URI uri = uriComponentsBuilder.path("/avaliacoes/novo/{id}").buildAndExpand(avaliacoes.getId()).toUri();
			return ResponseEntity.created(uri).body(new AvaliacoesDto(avaliacoes));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<AvaliacoesDto> deletar( Long id) {
		Optional<Avaliacoes> avaliacoes = avaliacoesRepository.findById(id);
		if (avaliacoes.isPresent()) {
			avaliacoesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
