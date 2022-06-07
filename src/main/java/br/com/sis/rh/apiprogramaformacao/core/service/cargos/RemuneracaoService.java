package br.com.sis.rh.apiprogramaformacao.core.service.cargos;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CargosDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaRemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaRemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.RemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.cargos.RemuneracaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.permissoes.MatriculaService;

@Service
public class RemuneracaoService {
    private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

    @Autowired
    private RemuneracaoRepository remuneracaoRepository;

    public List<ListaRemuneracaoDto> listaTodasRemuneracoes() {
        List<Remuneracao> remuneracoes = remuneracaoRepository.findAll();

        return ListaRemuneracaoDto.converterLista(remuneracoes);
    }

    public RemuneracaoDto exibeRemuneracao(long id) {

        Optional<Remuneracao> optional = remuneracaoRepository.findById(id);

        if (optional.isPresent()){
            return new RemuneracaoDto(optional.get());
        }

        return null;
    }

    public Remuneracao cadastraRemuneracao(RemuneracaoForm form) {

        Remuneracao remuneracao = form.converter();
        remuneracaoRepository.save(remuneracao);
        LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " cadastrou a remuneração: " + remuneracao.getCargo());

        return remuneracao;
    }

    public Remuneracao atualizaRemuneracao(Long id, AtualizaRemuneracaoForm form) {
        Optional<Remuneracao> optional = remuneracaoRepository.findById(id);
        if(optional.isPresent()){
            Remuneracao remuneracao = form.atualizar(id, remuneracaoRepository);
            LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " alterou a remuneração: " + remuneracao.getCargo());

            return remuneracao;
        }
        return null;
    }

    public List<CargosDto> buscarCargos() {
        return CargosDto.converter(remuneracaoRepository.findAll());
    }
}
