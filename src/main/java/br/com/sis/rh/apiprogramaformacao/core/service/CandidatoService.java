package br.com.sis.rh.apiprogramaformacao.core.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.*;
import br.com.sis.rh.apiprogramaformacao.core.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaCandidatoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CandidatoForm;

@Service
public class CandidatoService {

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

    public Candidato buscaPorId(Long id){
        Optional<Candidato> optionalCandidato = candidatoRepository.findById(id);

        return optionalCandidato.get();
    }
    
    public List<CandidatoDto> buscaCandidatoAprovado() {
    	List<Candidato> candidatos = candidatoRepository.findCandidatoPorStatus();
    	return CandidatoDto.converter(candidatos);
    }

    public List<ListaCandidatoDto> listaTodosDeUmaVaga () {
        List<Candidato> candidatos = candidatoRepository.findAll();
        return ListaCandidatoDto.toListaCandidatoDto(candidatos);
    }

    public Candidato atualizaCandidato(Long id, AtualizaCandidatoForm form) throws IOException {

        Optional<Candidato> optional = candidatoRepository.findById(id);
        if(optional.isPresent()){
            Candidato candidato = form.atualizar(id, candidatoRepository, processoSeletivoRepository);
            return candidato;
        }
        return null;
    }


    public Candidato criaCandidato(CandidatoForm form) throws IOException {

        Candidato candidato = form.converter(processoSeletivoRepository);
        candidatoRepository.save(candidato);

        return candidato;
    }

    public List<ListaCandidatoDto> buscaCandidadoPorFormacao(Long id) {
        List<Candidato> candidatos = candidatoRepository.findCandidatosPorFormacao(id);

        return ListaCandidatoDto.toListaCandidatoDto(candidatos);
    }

    public ResponseEntity<ByteArrayResource> downloadCurriculo(Long id) {
        Candidato curriculo = candidatoRepository.getById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new ByteArrayResource(curriculo.getCurriculo()));
    }

    public ResponseEntity<ByteArrayResource> downloadDisc(Long id) {
        Candidato disc = candidatoRepository.getById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
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
		System.out.println(nomePrograma);
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
