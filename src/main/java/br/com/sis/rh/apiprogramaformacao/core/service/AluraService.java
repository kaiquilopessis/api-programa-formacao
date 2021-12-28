package br.com.sis.rh.apiprogramaformacao.core.service;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;
import br.com.sis.rh.apiprogramaformacao.api.model.AluraCompare;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AluraDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ApiAluraDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAluraVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AluraForm;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraCompareRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.FormatadorDataUtil;

@Service
public class AluraService {

	@Autowired
	private AluraRepository aluraRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private AluraCompareRepository aluraCompareRepository;

	@Autowired
	private FormatadorDataUtil formatador;

	private static final String URI = "https://cursos.alura.com.br/corp/api/v1/conclusoes";

	/**
	 * Retorna uma lista de registros com base no participante selecionado.
	 */

	public List<AluraDto> listaRegistros(String cpf) {
		List<Alura> alura = aluraRepository.findAllByParticipanteCpf(cpf);
		return AluraDto.converter(alura);
	}

	/**
	 * Cadastra um registro com base no participante selecionado. Retorna código 201
	 * e um DTO com o objeto criado na resposta caso o participante exista, caso não
	 * exista, é retornado erro 404.
	 */
	public ResponseEntity<AluraDto> cadastrar(String cpf, AluraForm aluraForm,
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

	/**
	 * Deleta um registro com base no registro selecionado caso o participante
	 * exista retorna código 200 caso o registro existir, se não retorna 404.
	 */
	public ResponseEntity<AluraDto> deletar(Long id) {
		Optional<Alura> alura = aluraRepository.findById(id);
		if (alura.isPresent()) {
			aluraRepository.delete(alura.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Executa outros métodos para popular o Vo para levar as informações para o
	 * front-end e popular os cards.
	 * 
	 * @param formacao nome do programa de formação selecionado
	 * @param turma    turma do programa de formação selecionado
	 * @return Vo populado com a media de horas, maior e menor horas registradas,
	 *         data do último registro, nome e cargo do participante que teve a
	 *         maior e menor hora, além do nome do programa e a turma.
	 */

	public RelatorioAluraVo popularCards(String formacao, String turma) {
		RelatorioAluraVo aluraVo = new RelatorioAluraVo();
		List<Alura> relatorios = new ArrayList<Alura>();

		String turmaFormatada = turma.replace("+", " ");

		relatorios = aluraRepository.buscarRegistroHoras(turmaFormatada, formacao);
		aluraVo = calcularMediaMaxMinHoras(relatorios);
		aluraVo = buscarParticipantesComMaiorEMenorQtdHoras(aluraVo, turmaFormatada, formacao);
		LocalDate dataRegistro = relatorios.get(0).getDataRegistro();
		aluraVo.setDataUltimoRegistro(formatador.formatarData(dataRegistro));
		aluraVo.setProgramaDeFormacao(formacao);
		aluraVo.setTurma(turmaFormatada);

		return aluraVo;
	}

	/**
	 * Calcula a média de horas por semana dos participantes, busca a maior e a
	 * menor quantidade de horas registradas.
	 *
	 * @param relatorios Lista do último registro de apontamento de horas da
	 *                   plataforma Alura
	 * @return Vo com os campos de média, máxima e menor quantidade de horas
	 *         populados.
	 */

	public RelatorioAluraVo calcularMediaMaxMinHoras(List<Alura> relatorios) {
		RelatorioAluraVo aluraVo = new RelatorioAluraVo();
		aluraVo.setMediaDeHorasDosParticipantes(0);
		aluraVo.setMaiorQuantidadeDeHorasDosParticipantes(relatorios.get(0).getQtdHoras());
		aluraVo.setMenorQuantidadeDeHorasDosParticipantes(relatorios.get(0).getQtdHoras());
		relatorios.forEach(relatorio -> {
			if (relatorio.getQtdHoras() > aluraVo.getMaiorQuantidadeDeHorasDosParticipantes()) {
				aluraVo.setMaiorQuantidadeDeHorasDosParticipantes(relatorio.getQtdHoras());
			}
			if (relatorio.getQtdHoras() < aluraVo.getMenorQuantidadeDeHorasDosParticipantes()) {
				aluraVo.setMenorQuantidadeDeHorasDosParticipantes(relatorio.getQtdHoras());
			}
			aluraVo.setMediaDeHorasDosParticipantes(
					aluraVo.getMediaDeHorasDosParticipantes() + relatorio.getQtdHoras());
		});
		aluraVo.setMediaDeHorasDosParticipantes(aluraVo.getMediaDeHorasDosParticipantes() / relatorios.size());

		return aluraVo;
	}

	public RelatorioAluraVo buscarParticipantesComMaiorEMenorQtdHoras(RelatorioAluraVo aluraVo, String nomeTurma,
			String nomePrograma) {
		String cpfMaiorHora = aluraRepository.buscarCpfMaiorHora(nomeTurma, nomePrograma);
		String cpfMenorHora = aluraRepository.buscarCpfMenorHora(nomeTurma, nomePrograma);

		Participante participanteMaiorHora = participanteRepository.findByCpf(cpfMaiorHora);
		Participante participanteMenorHora = participanteRepository.findByCpf(cpfMenorHora);

		aluraVo.setNomeFuncionarioComMaiorQuantidadeHoras(participanteMaiorHora.getCandidato().getNome());
		aluraVo.setCargoFuncionarioComMaiorQuantidadeHoras(participanteMaiorHora.getRemuneracao().getCargo());

		aluraVo.setNomeFuncionarioComMenorQuantidadeHoras(participanteMenorHora.getCandidato().getNome());
		aluraVo.setCargoFuncionarioComMenorQuantidadeHoras(participanteMenorHora.getRemuneracao().getCargo());

		return aluraVo;
	}

	public ApiAluraDto[] getAlura() {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("cursos.alura.com.br")
				.path("corp/api/v1/conclusoes").queryParam("token", "6afb14cb642b40e7915770094b8fbb8a").build();

		ApiAluraDto[] body = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entity, ApiAluraDto[].class)
				.getBody();
		return body;
	}

	public void AluraSchedule() {

		List<Participante> participantes = participanteRepository.findByStatus(StatusAtivo.ATIVO);
		List<String> emailParticipantes = participantes.stream().map(Participante::getEmail)
				.collect(Collectors.toList());
		ApiAluraDto[] registros = this.getAlura();

		for (String email : emailParticipantes) {
			for (ApiAluraDto registro : registros) {
				if (email.compareTo(registro.getEmail()) == 0) {
					List<AluraCompare> emailsAlura = aluraCompareRepository.findByEmail(email);
					for (AluraCompare emailAlura : emailsAlura) {
						if (emailAlura.getIdCurso().compareTo(registro.getIdCurso()) == 0) {
							break;
						} else {
							AluraCompare registroConvertido = emailAlura.converter(registro);
							aluraCompareRepository.save(registroConvertido);
							break;
						}
					}
				}
			}
		}
	}
}
