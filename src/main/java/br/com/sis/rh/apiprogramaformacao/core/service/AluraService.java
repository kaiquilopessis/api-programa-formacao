package br.com.sis.rh.apiprogramaformacao.core.service;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
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
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAluraVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AluraForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.FormatadorDataUtil;

@Service
public class AluraService {

	@Autowired
	private AluraRepository aluraRepository;
	
	@Autowired
	private FormatadorDataUtil formatador;

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
		LocalDate dataRegistro = relatorios.get(0).getDataRegistro();
		aluraVo.setDataUltimoRegistro(formatador.formatarData(dataRegistro));
		
//		aluraVo = buscarParticipantesComMaiorEMenorQtdHoras(aluraVo);
		String turmaFormatada = turma.replace("+", " ");
		System.out.println(turmaFormatada);
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
	
//	public RelatorioAluraVo buscarParticipantesComMaiorEMenorQtdHoras(RelatorioAluraVo aluraVo) {
//		String cpfMaiorHora = aluraRepository.buscarCpfMaiorHora();
//		String cpfMenorHora = aluraRepository.buscarCpfMenorHora();
//
//		Participante participanteMaiorHora = participanteRepository.findByCpf(cpfMaiorHora);
//		Participante participanteMenorHora = participanteRepository.findByCpf(cpfMenorHora);
//		
//		aluraVo.setNomeFuncionarioComMaiorQuantidadeHoras(participanteMaiorHora.getNome());
//		aluraVo.setCargoFuncionarioComMaiorQuantidadeHoras(participanteMaiorHora.getCargo());
//		
//		aluraVo.setNomeFuncionarioComMenorQuantidadeHoras(participanteMenorHora.getNome());
//		aluraVo.setCargoFuncionarioComMenorQuantidadeHoras(participanteMenorHora.getCargo());
//		
//		return aluraVo;
//	}

}
