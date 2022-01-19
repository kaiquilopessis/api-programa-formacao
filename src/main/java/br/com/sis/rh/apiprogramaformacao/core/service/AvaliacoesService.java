package br.com.sis.rh.apiprogramaformacao.core.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.AvaliacaoDesempenho;
import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AvaliacaoDesempenhoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AvaliacoesDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AvaliacoesForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.AvaliacaoDesempenhoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.AvaliacaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
@Service
public class AvaliacoesService {
	private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

	/** injetando o repositorio de avaliação **/
	@Autowired
	private AvaliacaoRepository avaliacoesRepository;

	/** injetando o repositorio de participante **/
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	/** injetando o repositorio de avaliação desempenho **/
	@Autowired
	private AvaliacaoDesempenhoRepository avaliacaoDesempenhoRepository;

	/** lista as notas das avaliações
	 *
	 *@return dto que converte a lista em nota 
	 **/
	public ResponseEntity<List<AvaliacoesDto>> listarNotas(String cpf) {
		List<Avaliacoes> listaNotas = avaliacoesRepository.findAllByParticipanteCpf(cpf);
		return AvaliacoesDto.converter(listaNotas);

	}
	
	/** cadastra as avaliações do participante pegando ele pelo id
	 *@return caso não achar o participante vai dar uma mensagem de erro **/
	public ResponseEntity<AvaliacoesDto> cadastrar( String cpf,  AvaliacoesForm avaliacoesForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		if (participante.isPresent()) {
			Avaliacoes avaliacoes = avaliacoesForm.converter(participante.get());
			avaliacoesRepository.save(avaliacoes);
			LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " criou a avaliação: "+ avaliacoes.getId()
					+ " para o participante: " + avaliacoes.getParticipante().getCpf() + " - " + avaliacoes.getParticipante().getCandidato().getNome());
			URI uri = uriComponentsBuilder.path("/avaliacoes/novo/{id}").buildAndExpand(avaliacoes.getId()).toUri();
			return ResponseEntity.created(uri).body(new AvaliacoesDto(avaliacoes));
		}
		return ResponseEntity.notFound().build();
	}
	
	/** Metodo para deletar a avaliação **/
	public ResponseEntity<AvaliacoesDto> deletar( Long id) {
		Optional<Avaliacoes> avaliacoes = avaliacoesRepository.findById(id);
		if (avaliacoes.isPresent()) {
			avaliacoesRepository.deleteById(id);
			LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " deletou a avaliação: " + avaliacoes.get().getId() + " do participante: "
					+ avaliacoes.get().getParticipante().getCpf() + " - " + avaliacoes.get().getParticipante().getCandidato().getNome());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	/** Metodo listar para avaliação de desempenho **/
	public ResponseEntity<AvaliacaoDesempenhoDto> listarAvaliacaoDesempenho(Long id) {
		AvaliacaoDesempenho avaliacaoDesempenho = avaliacaoDesempenhoRepository.getById(id);
		return ResponseEntity.ok(new AvaliacaoDesempenhoDto(avaliacaoDesempenho));
	}

}
