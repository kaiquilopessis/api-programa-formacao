package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FeedBackForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FeedBackServiceTest {

    @Autowired
    private FeedBackService feedBackService;

    private static FeedBackForm feedBackForm = new FeedBackForm();

    @BeforeAll
    public static void executaAntesDosTestes () throws IOException {
        feedBackForm.setData("2022-02-21");
        feedBackForm.setAnotacoes("Anotação teste");
        feedBackForm.setDisc(new MockMultipartFile("file", new ByteArrayInputStream("Teste".getBytes())));
    }

    @Test
    public void deveriaRetornarListaDeFeedBacks () {
        assertNotNull(feedBackService.listar("33092410840"));
    }

    @Test
    @WithMockUser("testeUnitarioJUnit")
    public void deveriaCadastrarNoBancoUmFeedBack () {
        UriComponentsBuilder uri = UriComponentsBuilder.newInstance();
        URI uriPath = uri.path("feedback/novo").buildAndExpand().toUri();
        assertEquals(ResponseEntity.created(uriPath).build().getStatusCode(), feedBackService.cadastrar("33092410840", feedBackForm, uri).getStatusCode());
    }

    @Test
    @WithMockUser("testeUnitarioJUnit")
    public void deveriaDeletarUmFeedBack () {

    }
}
