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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FeedBackForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.acompanhamento.FeedBackRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.permissoes.MatriculaService;

@Service
public class FeedBackService {
	private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

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
	public ResponseEntity<FeedBackDto> cadastrar(String cpf, FeedBackForm feedBackForm) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		
		try {
			if (participante.isPresent()) {
				FeedBack feedback = feedBackForm.converter(participante.get());
				feedBackRepository.save(feedback);
				LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " cadastrou o feedback: " + feedback.getId() + " para o participante: "
				+ feedback.getParticipante().getCpf() + " - " + feedback.getParticipante().getCandidato().getNome());
				URI uri = UriComponentsBuilder.newInstance().path("feedback/novo/{id}").buildAndExpand(feedback.getId()).toUri();
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
			LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " deletou o feedback: " + feedBack.get().getId() + " do participante: "
			+ feedBack.get().getParticipante().getCpf() + " - " + feedBack.get().getParticipante().getCandidato().getNome());
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
