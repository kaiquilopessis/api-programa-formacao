package br.com.sis.rh.apiprogramaformacao.core.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ConclusaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ConclusaoFinalForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ConclusaoProgressivaForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoProgramaDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.ConclusaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class ConclusaoService {

	@Autowired
	private ConclusaoRepository conclusaoRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private RemuneracaoRepository remuneracaoRepository;

	public List<ConclusaoDto> listarConclusoes(String cpf){
		List<Conclusao> conclusoes = conclusaoRepository.findAllByParticipanteCpf(cpf);
		return ConclusaoDto.converter(conclusoes);
	}

	public ResponseEntity<ConclusaoDto> registrarCicloFinal(String cpf, ConclusaoFinalForm conclusaoFinalForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		if (participante.isPresent()) {
			Conclusao conclusaoFinal = conclusaoFinalForm.converter(participante.get());
			conclusaoRepository.save(conclusaoFinal);
			URI uri = uriComponentsBuilder
					.path("/conclusoes/registrociclofinal/{id}")
					.buildAndExpand(conclusaoFinal.getId())
					.toUri();
			return ResponseEntity.created(uri).body(new ConclusaoDto(conclusaoFinal));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<ConclusaoDto> registrarCicloProgressivo(String cpf,
			ConclusaoProgressivaForm conclusaoProgressivaForm, UriComponentsBuilder uriComponentsBuilder) {
		Optional<Participante> participante =  participanteRepository.findById(cpf);
		if(participante.isPresent()) {
			Conclusao conclusaoProgressiva = conclusaoProgressivaForm
					.converter(participante.get(), remuneracaoRepository);
			conclusaoRepository.save(conclusaoProgressiva);
			URI uri = uriComponentsBuilder
					.path("/conclusoes/registrocicloprogressivo/{id}")
					.buildAndExpand(conclusaoProgressiva.getId())
					.toUri();
			return ResponseEntity.created(uri).body(new ConclusaoDto(conclusaoProgressiva));
		}
		return ResponseEntity.notFound().build();
	}

	public List<RemuneracaoProgramaDto> listarRemuneracao() {
		List<Remuneracao> remuneracao = remuneracaoRepository.findAll();
		return RemuneracaoProgramaDto.converter(remuneracao);
	}


}
