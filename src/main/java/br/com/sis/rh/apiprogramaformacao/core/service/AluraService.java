package br.com.sis.rh.apiprogramaformacao.core.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AluraDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AluraForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class AluraService {

	@Autowired
	private AluraRepository aluraRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	public List<AluraDto> listaRegistros(String cpf) {
		List<Alura> alura = aluraRepository.findAllByParticipanteCpf(cpf);
		return AluraDto.converter(alura);
	}

	public ResponseEntity<AluraDto> cadastrar(String cpf, @RequestBody AluraForm aluraForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		if (participante.isPresent()) {
			Alura alura = aluraForm.converter(participante.get());
			aluraRepository.save(alura);
			URI uri = uriComponentsBuilder.path("/alura/novo/{id}").buildAndExpand(alura.getCodigoAlura()).toUri();
			return ResponseEntity.created(uri).body(new AluraDto(alura));
		}
		return ResponseEntity.notFound().build();
	}


	public ResponseEntity<AluraDto> deletar(Long id) {
		Optional<Alura> alura = aluraRepository.findById(id);
		if (alura.isPresent()) {
			aluraRepository.delete(alura.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
