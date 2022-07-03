package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FeedBackForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.acompanhamento.FeedBackRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.acompanhamento.FeedBackService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável pelos testes do Service FeedBackService.
 *
 * @author Gustavo Juliano
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class FeedBackServiceTest {

    @Autowired
    private FeedBackService feedBackService;

    @Autowired
    private FeedBackRepository feedBackRepository;

    private static FeedBackForm feedBackForm = new FeedBackForm();

    private static Long id;

    @BeforeAll
    public static void executaAntesDosTestes () throws IOException {
        feedBackForm.setData("2022-02-21");
        feedBackForm.setAnotacoes("Anotação teste");
        feedBackForm.setDisc(new MockMultipartFile("file", new ByteArrayInputStream("Teste".getBytes())));
    }

    @Order(1)
    @Test
    @WithMockUser("testeUnitarioJUnit")
    public void deveriaCadastrarNoBancoUmFeedBack () {
        UriComponentsBuilder uri = UriComponentsBuilder.newInstance();
        URI uriPath = uri.path("feedback/novo").buildAndExpand().toUri();
        assertEquals(ResponseEntity.created(uriPath).build().getStatusCode(), feedBackService.cadastrar("33092410840", feedBackForm).getStatusCode());
    }

    @Order(2)
    @Test
    public void deveriaRetornarListaDeFeedBacks () {
        List<FeedBackDto> lista = feedBackService.listar("33092410840");
        id = lista.get((lista.size())-1).getId();
        assertNotNull(lista);
    }

    @Order(3)
    @Transactional
    @Test
    public void deveriaFazerDownload () {
        assertEquals(ResponseEntity.ok().build().getStatusCode(), feedBackService.download(id).getStatusCode());
    }

    @Order(4)
    @Test
    @WithMockUser("testeUnitarioJUnit")
    public void deveriaDeletarUmFeedBack () {
        List<FeedBack> feedBackList = feedBackRepository.findAll();
        int var = (feedBackList.size()) - 1;

        assertEquals(ResponseEntity.ok().build(), feedBackService.deletar(feedBackList.get(var).getId()));
    }
}
