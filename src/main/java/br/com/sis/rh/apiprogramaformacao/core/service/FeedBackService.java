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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FeedBackForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.FeedBackRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class FeedBackService {
	/**
	 Injeção do feedBackRepository
	 */
	@Autowired
	private FeedBackRepository feedBackRepository;
	/**
	 Injeção do participanteRepository
	 */
	@Autowired
	private ParticipanteRepository participanteRepository;
	/**
	 *Método que busca no banco os feedBacks e retorna o FeedBackDto 
	 * o Método converter converte o objeto feedback, para feedBackDto
	 **/
	public List<FeedBackDto> listar(String cpf) {
		List<FeedBack> feedbacks = feedBackRepository.findAllByParticipanteCpf(cpf);
		return FeedBackDto.converter(feedbacks);
	}
	/**
	 * Recebe o objeto feedbackForm, e salva no banco
	 * */
	public ResponseEntity<FeedBackDto> cadastrar(String cpf, FeedBackForm feedBackForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		
		try {
			if (participante.isPresent()) {
				FeedBack feedback = feedBackForm.converter(participante.get());
				feedBackRepository.save(feedback);
				URI uri = uriComponentsBuilder.path("feedback/novo/{id}").buildAndExpand(feedback.getId()).toUri();
				return ResponseEntity.created(uri).body(new FeedBackDto(feedback));
			}
			return ResponseEntity.notFound().build();
		} catch (IOException e) {
			System.out.println("Erro no input do arquivo DISC");
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	/**
	 * Recebe o id e faz a exclusão do feedBack de acordo com o ID passado.
	 */
	 
	public ResponseEntity<FeedBackDto> deletar(@PathVariable Long id) {
		Optional<FeedBack> feedBack = feedBackRepository.findById(id);
		if (feedBack.isPresent()) {
			feedBackRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	/**
	 *Faz a lógica do donwload, o metodo parseMediaType converte o arquivo para poder fazer donwload
	 * */
	public ResponseEntity<ByteArrayResource> download(Long id) {
		FeedBack arquivo = feedBackRepository.getById(id);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/pdf"))
				.header("Content-Disposition", "attachment; filename=\"Arquivo-" + arquivo.getParticipante().getCandidato().getNome() + "-"  + id + ".pdf\"")
				.body(new ByteArrayResource(arquivo.getDisc()));

	}
}
