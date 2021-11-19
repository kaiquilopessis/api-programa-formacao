package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAluraVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AluraForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.FormatadorDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AluraService {

	@Autowired
	private AluraRepository aluraRepository;
	
	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private FormatadorDataUtil formatador;

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	/**
	 * Retorna uma lista de registros com base no participante selecionado.
	 */

	public List<AluraDto> listaRegistros(String cpf) {
		List<Alura> alura = aluraRepository.findAllByParticipanteCpf(cpf);
		return AluraDto.converter(alura);
	}
	
	/**
	 * Cadastra um registro com base no participante selecionado.
	 * Retorna código 201 e um DTO com o objeto criado na resposta caso o participante exista, caso não exista, é retornado erro 404.
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
	 * Deleta um registro com base no registro selecionado caso o participante exista
	 * retorna código 200 caso o registro existir, se não retorna 404.
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
	 * Executa outros métodos para popular o Vo
	 * para levar as informações para o front-end e popular
	 * os cards.
	 * 
	 * @param formacao nome do programa de formação selecionado
	 * @param turma turma do programa de formação selecionado
	 * @return Vo populado com a media de horas, maior e menor
	 * horas registradas, data do último registro, nome e cargo
	 * do participante que teve a maior e menor hora, além do 
	 * nome do programa e a turma.
	 */
	
	public RelatorioAluraVo popularCards(String formacao, String turma) {
		RelatorioAluraVo aluraVo = new RelatorioAluraVo();
		List<Alura> relatorios = new ArrayList<Alura>();
		
		relatorios = aluraRepository.buscarRegistroHoras();
		aluraVo = calcularMediaMaxMinHoras(relatorios);
		aluraVo = buscarParticipantesComMaiorEMenorQtdHoras(aluraVo);
		LocalDate dataRegistro = relatorios.get(0).getDataRegistro();
		aluraVo.setDataUltimoRegistro(formatador.formatarData(dataRegistro));
		
//		aluraVo = buscarParticipantesComMaiorEMenorQtdHoras(aluraVo);
		String turmaFormatada = turma.replace("+", " ");
		aluraVo.setProgramaDeFormacao(formacao);
		aluraVo.setTurma(turmaFormatada);
		
		return aluraVo;
	}

	/**
	 * Calcula a média de horas por semana dos participantes,
	 * busca a maior e a menor quantidade de horas registradas.
	 *
	 * @param relatorios Lista do último registro de apontamento
	 * de horas da plataforma Alura
	 * @return Vo com os campos de média, máxima e menor quantidade
	 * de horas populados.
	 */
	
	public RelatorioAluraVo calcularMediaMaxMinHoras(List<Alura> relatorios) {
		RelatorioAluraVo aluraVo = new RelatorioAluraVo();
		aluraVo.setMediaDeHorasDosParticipantes(0);
		aluraVo.setMaiorQuantidadeDeHorasDosParticipantes(relatorios.get(0).getQtdHoras());
		aluraVo.setMenorQuantidadeDeHorasDosParticipantes(relatorios.get(0).getQtdHoras());
		relatorios.forEach(relatorio -> {
			if(relatorio.getQtdHoras() > aluraVo.getMaiorQuantidadeDeHorasDosParticipantes()) {
				aluraVo.setMaiorQuantidadeDeHorasDosParticipantes(relatorio.getQtdHoras());
			}
			if(relatorio.getQtdHoras() < aluraVo.getMenorQuantidadeDeHorasDosParticipantes()) {
				aluraVo.setMenorQuantidadeDeHorasDosParticipantes(relatorio.getQtdHoras());
			}
			aluraVo.setMediaDeHorasDosParticipantes(aluraVo.getMediaDeHorasDosParticipantes() + relatorio.getQtdHoras());
		});
		aluraVo.setMediaDeHorasDosParticipantes(aluraVo.getMediaDeHorasDosParticipantes() / relatorios.size());
		
		return aluraVo;
	}
	
	public RelatorioAluraVo buscarParticipantesComMaiorEMenorQtdHoras(RelatorioAluraVo aluraVo) {
		String cpfMaiorHora = aluraRepository.buscarCpfMaiorHora();
		String cpfMenorHora = aluraRepository.buscarCpfMenorHora();

		Participante participanteMaiorHora = participanteRepository.findByCpf(cpfMaiorHora);
		Participante participanteMenorHora = participanteRepository.findByCpf(cpfMenorHora);

		aluraVo.setNomeFuncionarioComMaiorQuantidadeHoras(participanteMaiorHora.getCandidato().getNomeCandidato());
		aluraVo.setCargoFuncionarioComMaiorQuantidadeHoras(participanteMaiorHora.getRemuneracao().getCargo());

		aluraVo.setNomeFuncionarioComMenorQuantidadeHoras(participanteMenorHora.getCandidato().getNomeCandidato());
		aluraVo.setCargoFuncionarioComMenorQuantidadeHoras(participanteMenorHora.getRemuneracao().getCargo());

		return aluraVo;
	}
}
