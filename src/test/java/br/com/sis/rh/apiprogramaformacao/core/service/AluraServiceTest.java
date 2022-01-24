package br.com.sis.rh.apiprogramaformacao.core.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAluraVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AluraServiceTest {

    @Autowired
    private AluraService aluraService;

    @Test
    public void deveriaRetornarUmaListaDeRegistros () {
        assertNotNull(aluraService.listaRegistros("33092410840"));
    }

    @Test
    public void deveriaRetornarRelatorioAluraVOParaPopularCards () {
        assertEquals(RelatorioAluraVo.class, aluraService.popularCards("Formaçãoteste", "Java II"));
    }

//    @Test
//    public void deveriaCalcularMediaMaxMinHoras () {}
//
//    @Test
//    public void deveriaBuscarParticipantesComMaiorEMenorQtdHoras () {}
}
