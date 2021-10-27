package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaRemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaRemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.RemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RemuneracaoService {

    @Autowired
    private RemuneracaoRepository remuneracaoRepository;

    public List<ListaRemuneracaoDto> listaTodasRemuneracoes() {
        List<Remuneracao> remuneracoes = remuneracaoRepository.findAll();

        return ListaRemuneracaoDto.converterLista(remuneracoes);
    }

    public RemuneracaoDto exibeRemuneracao(Long id) {

        Optional<Remuneracao> optional = remuneracaoRepository.findById(id);

        if (optional.isPresent()){
            return new RemuneracaoDto(optional.get());
        }

        return null;
    }

    public Remuneracao cadastraRemuneracao(RemuneracaoForm form) {

        Remuneracao remuneracao = form.converter();
        remuneracaoRepository.save(remuneracao);

        return remuneracao;
    }

    public Remuneracao atualizaRemuneracao(Long id, AtualizaRemuneracaoForm form) {
        Optional<Remuneracao> optional = remuneracaoRepository.findById(id);
        if(optional.isPresent()){
            Remuneracao remuneracao = form.atualizar(id, remuneracaoRepository);
            return remuneracao;
        }
        return null;
    }
}
