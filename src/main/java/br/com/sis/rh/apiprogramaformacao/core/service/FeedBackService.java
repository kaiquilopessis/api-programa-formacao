package br.com.sis.rh.apiprogramaformacao.core.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FeedBackForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.FeedBackRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import javassist.bytecode.ByteArray;

@Service
public class FeedBackService {

	@Autowired
	private FeedBackRepository feedBackRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	public List<FeedBackDto> listar(String cpf) {
		List<FeedBack> feedbacks = feedBackRepository.findAllByParticipanteCpf(cpf);
		return FeedBackDto.converter(feedbacks);
	}

	public ResponseEntity<FeedBackDto> cadastrar(String cpf, @RequestBody FeedBackForm feedBackForm,
			UriComponentsBuilder uriComponentsBuilder) throws IOException {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		if (participante.isPresent()) {
			FeedBack feedback = feedBackForm.converter(participante.get());
			feedBackRepository.save(feedback);
			URI uri = uriComponentsBuilder.path("feedback/novo/{id}").buildAndExpand(feedback.getId()).toUri();
			return ResponseEntity.created(uri).body(new FeedBackDto(feedback));

		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<FeedBackDto> deletar(@PathVariable Long id) {
		Optional<FeedBack> feedBack = feedBackRepository.findById(id);
		if (feedBack.isPresent()) {
			feedBackRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<ByteArrayResource> download (Long id){
		FeedBack disc = feedBackRepository.getById(id);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.body(new ByteArrayResource(disc.getDisc()));
		
	}

}
