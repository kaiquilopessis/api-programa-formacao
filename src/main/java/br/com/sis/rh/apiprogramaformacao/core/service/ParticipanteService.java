package br.com.sis.rh.apiprogramaformacao.core.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.model.Investimentos;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaStatusParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CadastroParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.CandidatoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.InvestimentoFolhaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.InvestimentosRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoRepository;

@Service
public class ParticipanteService {
	@Autowired
	private ParticipanteRepository repository;

	@Autowired
	private ProgramaRepository programaRepository;

	@Autowired
	private InvestimentoFolhaRepository folhaRepository;

	@Autowired
	private InvestimentosRepository investimentosRepository;

	@Autowired
	private CandidatoRepository candidatoRepository;

	@Autowired
	private RemuneracaoRepository remuneracaoRepository;

	public List<Participante> todosParticipantes() {
		return repository.findAll();
	}

	public Participante participanteCpf(String cpf) {
		Optional<Participante> optional = repository.findById(cpf);
		System.out.println(optional.get().getCpf());

		return optional.get();
	}

//	public Participante atualizaParticipante(String cpf, AtualizaParticipanteForm form) {
//		Optional<Participante> optionalParticipante = repository.findById(cpf);
//		if (optionalParticipante.isPresent()) {
//			Participante participante = form.atualizar(cpf, repository, programaRepository);
//			return participante;
//		}
//		return null;
//	}

	public List<FiltragemFolhaDto> listagemFiltroFolha(String nomeFormacao, String nomeTurma) {
		String nomeTurmaFormatado = nomeTurma.replace("+", " "); // pesquisa no banco
		return folhaRepository.findByNomeFormacaoTurmaBolsa(nomeFormacao, nomeTurmaFormatado);
	}

	public void cadastrar(FolhaForm folhaForm) {
		Optional<Participante> optionalParticipante = repository.findById(folhaForm.getCpf());
		if (optionalParticipante.isPresent()) {
			Investimentos investimento = FolhaForm.converter(folhaForm, optionalParticipante.get());
			investimentosRepository.save(investimento);
		}

	}

	public List<CpfParticipanteNomeDto> listagemParticipantes(String nomeFormacao, String nomeTurma) {
//        List<Participante> listaParticipantes = ;
		return folhaRepository.findByCpf(nomeFormacao, nomeTurma);
	}

	public List<ParticipanteBuscaDto> buscaPorStatus() {
		List<Participante> participantes = repository.findByStatus(StatusAtivo.ATIVO);
		return ParticipanteBuscaDto.converter(participantes);
	}

	public ResponseEntity<ParticipanteBuscaNomeDto> buscaPorId(String cpf) {
		Optional<Participante> participante = repository.findById(cpf);
		if (participante.isPresent()) {
			return ResponseEntity.ok(new ParticipanteBuscaNomeDto(participante.get()));
		}
		return ResponseEntity.notFound().build();
	}

	public void cadastrarParticipante(CadastroParticipanteForm cadastroParticipanteForm) throws IOException {
		Candidato candidato = candidatoRepository.getById(cadastroParticipanteForm.getIdCandidato());
		Remuneracao remuneracao = remuneracaoRepository.getById(cadastroParticipanteForm.getIdRemuneracao());
		Programa programa = programaRepository.getById(cadastroParticipanteForm.getIdPrograma());

		Participante participante = CadastroParticipanteForm.converter(cadastroParticipanteForm, remuneracao, programa,
				candidato);
		repository.save(participante);
	}

	public void atualizarStatus(AtualizaStatusParticipanteForm atualizaStatusParticipanteForm) {
		Participante participante = repository.findByCpf(atualizaStatusParticipanteForm.getCpf());
		participante.setStatus(atualizaStatusParticipanteForm.getStatusAtivo());
		repository.save(participante);
	}

	public List<ParticipanteBuscaDto> filtrarParticipantes(String nome, String nomePrograma, String nomeTurma) {
		List<Participante> participante = new ArrayList<>();
		String nomeTurmaFormatada = nomeTurma.replace("%20 ", " ");
		if (nomePrograma.equals("0") || nomeTurmaFormatada.equals("0")) {
			participante = repository.findByNome(nome);
		} else if (nome.equals("0")) {
			participante = repository.findByProgramaTurma(nomePrograma, nomeTurmaFormatada);
		} else {
			participante = repository.findByNomeProgramaTurma(nome, nomePrograma, nomeTurmaFormatada);
		}
		return ParticipanteBuscaDto.converter(participante);
	}

	public void atualizarParticipante(AtualizaParticipanteForm atualizaStatusParticipanteForm) throws IOException {

		Participante participante = repository.findByCpf(atualizaStatusParticipanteForm.getCpf());
		LocalDate dataFormatadaBanco =  LocalDate.parse(atualizaStatusParticipanteForm.getDataFimGraduacao(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		participante.getCandidato().setNome(atualizaStatusParticipanteForm.getNome());
		participante.setCpf(atualizaStatusParticipanteForm.getCpf());
		participante.getCandidato().setTelefone(atualizaStatusParticipanteForm.getTelefone());
		participante.getCandidato().setFonteRecrutamento(atualizaStatusParticipanteForm.getFonteRecrutamento());
		participante.setFaculdade(atualizaStatusParticipanteForm.getNmFaculdade());
		participante.setCurso(atualizaStatusParticipanteForm.getCurso());
		participante.setDataFinal(dataFormatadaBanco);
		participante.getCandidato().setObservacao(atualizaStatusParticipanteForm.getObservacao());
		participante.setEmail(atualizaStatusParticipanteForm.getEmail());
		participante.setTce(atualizaStatusParticipanteForm.getTce().getBytes());

		repository.save(participante);

	}

	public ResponseEntity<ByteArrayResource> downloadTce(String id) {
			Participante tce = repository.getById(id);
				return ResponseEntity.ok()
				.contentType(
						MediaType.parseMediaType("application/pdf"))
				.body(new ByteArrayResource(tce.getTce()));
		
	}

	public ResponseEntity<ByteArrayResource> downloadDisc(String id) {
		Participante tce = repository.getById(id);
		return ResponseEntity.ok()
				.contentType(
						MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.body(new ByteArrayResource(tce.getCandidato().getDisc()));

	}
		
}

