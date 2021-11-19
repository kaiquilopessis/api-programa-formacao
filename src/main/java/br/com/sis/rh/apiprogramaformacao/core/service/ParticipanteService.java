package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;
import java.util.Optional;

import br.com.sis.rh.apiprogramaformacao.api.model.Investimentos;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InvestimentoFolhaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.InvestimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

@Service
public class ParticipanteService {
	@Autowired
	ParticipanteRepository repository;
	
	@Autowired
	ProgramaRepository programaRepository;

	@Autowired
	private InvestimentoFolhaRepository folhaRepository;

	@Autowired
	InvestimentosRepository investimentosRepository;

	public List<Participante> todosParticipantes(){
		return repository.findAll();
	}

	public Participante participanteCpf(String cpf){
		Optional<Participante> optional = repository.findById(cpf);
		return optional.get();
	}

	public Participante atualizaParticipante(String cpf, AtualizaParticipanteForm form) {
		Optional<Participante> optionalParticipante = repository.findById(cpf);
		if(optionalParticipante.isPresent()) {
			Participante participante = form.atualizar(cpf, repository, programaRepository);
			return participante;
		}
		return null;
	}

	public List<FiltragemFolhaDto> listagemFiltroFolha(String nomeFormacao, String nomeTurma){
		String nomeTurmaFormatado = nomeTurma.replace("+", " "); // pesquisa no banco
		return folhaRepository.findByNomeFormacaoTurmaBolsa(nomeFormacao, nomeTurmaFormatado);
	}

	public void cadastrar(FolhaForm folhaForm){
		System.out.println(folhaForm.getCpf());
		Optional<Participante> optionalParticipante = repository.findById(folhaForm.getCpf());
		if (optionalParticipante.isPresent()){
			System.out.println("entrei aqui");
			Investimentos investimento = FolhaForm.converter(folhaForm, optionalParticipante.get());
			investimentosRepository.save(investimento);
		}


	}

	public List<CpfParticipanteNomeDto> listagemParticipantes(String nomeFormacao, String nomeTurma){
//        List<Participante> listaParticipantes = ;
		return folhaRepository.findByCpf(nomeFormacao, nomeTurma);
	}
	
}
