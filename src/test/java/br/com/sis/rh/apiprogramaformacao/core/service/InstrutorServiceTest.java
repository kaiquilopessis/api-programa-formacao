package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AttInstrutorForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InvestimentoInstrutorForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável pelos testes do Service InstrutorService.
 *
 * @author Gustavo Juliano
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InstrutorServiceTest {

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Order(1)
    @Test
    public void deveriaRetornarTodosOsInstrutores () {
        assertNotNull(instrutorService.todosInstrutores());
    }

    @Order(2)
    @Test
    public void deveriaRetornarInstrutoresPorStatus () {
        assertNotNull(instrutorService.buscaPorStatus("ATIVO"));
    }

    @Order(3)
    @Test
    @WithMockUser("testeUnitarioJUnit")
    public void deveriaSalvarUmInstrutor () {
        Instrutor instrutor = new Instrutor("999999999998", "(11) 9 9999-9999", "ATIVO", "Teste", "teste@teste.com.br");

        assertNotNull(instrutorService.salva(instrutor));
    }

    @Order(4)
    @Test
    @WithMockUser("testeUnitarioJUnit")
    public void deveriaAtualizarUmInstrutor () {
        AttInstrutorForm attInstrutorForm = new AttInstrutorForm();

        attInstrutorForm.setEmail("teste@testando.com.br");
        attInstrutorForm.setStatus("ATIVO");
        attInstrutorForm.setNome("Testando");
        attInstrutorForm.setTelefone("(14) 9 9999-9999");

        assertTrue(instrutorService.alteraInstrutor(attInstrutorForm, "999999999998"));
    }

    @Order(5)
    @Test
    public void deveriaRetornarUmInstrutorPorCpf () {
        assertNotNull(instrutorService.buscaPorCpf("33092410840"));
    }

    @Order(6)
    @Test
    @WithMockUser("testeUnitarioJUnit")
    public void deveriaCriarUmInvestimentoInstrutor () {
        InvestimentoInstrutorForm investimentoInstrutorForm = new InvestimentoInstrutorForm();

        investimentoInstrutorForm.setCpf("999999999998");
        investimentoInstrutorForm.setHorasTrabalhadas("18");
        investimentoInstrutorForm.setMesAno("2022-02-02");
        investimentoInstrutorForm.setValorHora("15");

        assertEquals(ResponseEntity.ok().build().getStatusCode(), instrutorService.cadastrar(investimentoInstrutorForm).getStatusCode());
    }

    @Order(7)
    @Test
    public void deveriaRetornarUmaListaDeFiltroDeInstrutor () {
        assertNotNull(instrutorService.listagemFiltroInstrutor("Formaçãoteste", "Java II"));
    }

    @Order(8)
    @Test
    public void deveriaRetornarUmInstrutorPelaTurmaDele () {
        assertNotNull(instrutorService.listagemInstrutores("Formaçãoteste", "Java II"));
    }

//    @Order(9)
//    @Test
//    public void desfazAlteracoesNoBanco () {
//        instrutorRepository.deleteById("999999999998");
//    }
}
