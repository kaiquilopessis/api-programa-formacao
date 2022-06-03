package br.com.sis.rh.apiprogramaformacao.core.service.processoseletivo;

import java.io.IOException;
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

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CargoModalDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeTurmaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaModalDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaCandidatoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CandidatoForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.cargos.RemuneracaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo.CandidatoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo.ProcessoSeletivoRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.permissoes.MatriculaService;

@Service
public class CandidatoService {

	private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

	@Autowired
	private CandidatoRepository candidatoRepository;

	@Autowired
	private ProcessoSeletivoRepository processoSeletivoRepository;

	@Autowired
	private ProgramaRepository programaRepository;

	@Autowired
	private InstrutorRepository instrutorRepository;

	@Autowired
	private RemuneracaoRepository remuneracao;

	public Candidato buscaPorId(Long id) {
		Optional<Candidato> optionalCandidato = candidatoRepository.findById(id);

		return optionalCandidato.get();
	}

	public List<CandidatoDto> buscaCandidatoAprovado() {
		List<Candidato> candidatos = candidatoRepository.findCandidatoPorStatus();
		return CandidatoDto.converter(candidatos);
	}

	public List<ListaCandidatoDto> listaTodosDeUmaVaga() {
		List<Candidato> candidatos = candidatoRepository.findAll();
		return ListaCandidatoDto.toListaCandidatoDto(candidatos);
	}

	public Candidato atualizaCandidato(Long id, AtualizaCandidatoForm form) throws IOException {

		Optional<Candidato> optional = candidatoRepository.findById(id);
		if (optional.isPresent()) {
			Candidato candidato = form.atualizar(id, candidatoRepository, processoSeletivoRepository);
			LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " atualizou o candidato: " + candidato.getId()+ " - " + candidato.getNome());
			return candidato;
		}
		return null;
	}

	public Candidato criaCandidato(CandidatoForm form) throws IOException {

		Candidato candidato = form.converter(processoSeletivoRepository);
		candidatoRepository.save(candidato);

		LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " criou o candidato: " + candidato.getId()+ " - " + candidato.getNome());

		return candidato;
	}

	public List<ListaCandidatoDto> buscaCandidadoPorFormacao(Long id) {
		List<Candidato> candidatos = candidatoRepository.findCandidatosPorFormacao(id);

		return ListaCandidatoDto.toListaCandidatoDto(candidatos);
	}

	public ResponseEntity<ByteArrayResource> downloadCurriculo(Long id) {
		Candidato curriculo = candidatoRepository.getById(id);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf"))
				.header("Content-Disposition", "attachment; filename=\"Currículo-" + curriculo.getNome() + "-.pdf\"")
				.body(new ByteArrayResource(curriculo.getCurriculo()));
	}

	public ResponseEntity<ByteArrayResource> downloadDisc(Long id) {
		Candidato disc = candidatoRepository.getById(id);
		return ResponseEntity.ok()
				.contentType(
						MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.header("Content-Disposition", "attachment; filename=\"DISC-" + disc.getNome() + "-.xlsx\"")
				.body(new ByteArrayResource(disc.getDisc()));
	}

	public Candidato candidatoId(Long id) {
		return candidatoRepository.getById(id);
	}

	public ProcessoSeletivo buscarNomePrograma(Long id) {
		return processoSeletivoRepository.findByIdCandidato(id);
	}

	public NomeProgramaCandidatoDto buscarPrograma(Long id) {
		return programaRepository.buscarProgramaPorCandidato(id);
	}

	public List<NomeTurmaCandidatoDto> buscarTurmas(String nomePrograma) {
		List<Programa> programas = programaRepository.buscarTurmasPeloNomePrograma(nomePrograma);
		return NomeTurmaCandidatoDto.converter(programas);
	}

	public List<NomeInstrutorDto> buscarInstrutoresAtivos() {
		return instrutorRepository.listarInstrutoresAtivos();
	}

	public CargoModalDto mostrarCargoModal(Long id) {
		return remuneracao.buscarPeloId(id);
	}

	public TurmaModalDto mostrarTurmaModal(Long id) {
		return programaRepository.buscarPeloId(id);
	}

}
