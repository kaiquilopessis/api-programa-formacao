package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAluraVo;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class AluraServiceTest {

    @Autowired
    private AluraService aluraService;

    @Autowired
    private AluraRepository aluraRepository;

    @Test
    public void deveriaRetornarUmaListaDeRegistros () {
        assertNotNull(aluraService.listaRegistros("33092410840"));
    }

    @Test
    @Transactional
    public void deveriaRetornarRelatorioAluraVOParaPopularCards () {
        assertEquals(RelatorioAluraVo.class, aluraService.popularCards("Formaçãoteste", "Java II").getClass());
    }

    @Test
    public void deveriaCalcularMediaMaxMinHoras () {
        List<Alura> aluraList = aluraRepository.findAll();
        assertEquals(RelatorioAluraVo.class, aluraService.calcularMediaMaxMinHoras(aluraList).getClass());
    }

    @Test
    @Transactional
    public void deveriaBuscarParticipantesComMaiorEMenorQtdHoras () {
        List<Alura> aluraList = aluraRepository.findAll();
        RelatorioAluraVo relatorioAluraVo = aluraService.calcularMediaMaxMinHoras(aluraList);
        assertEquals(RelatorioAluraVo.class, aluraService.buscarParticipantesComMaiorEMenorQtdHoras(relatorioAluraVo, "Java II", "Formaçãoteste").getClass());
    }
}
