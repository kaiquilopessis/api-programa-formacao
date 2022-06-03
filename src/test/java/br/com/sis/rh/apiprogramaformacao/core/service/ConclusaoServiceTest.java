package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioConclusaoVO;
import br.com.sis.rh.apiprogramaformacao.core.service.relatorios.ConclusaoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável pelos testes do Service ConclusaoService.
 *
 * @author Gustavo Juliano
 */

@SpringBootTest
public class ConclusaoServiceTest {

    @Autowired
    private ConclusaoService conclusaoService;

    @Test
    public void deveriaPopularCards () {
        assertEquals(RelatorioConclusaoVO.class,conclusaoService.popularCards("Formaçãoteste", "Java II").getClass());
    }
}
