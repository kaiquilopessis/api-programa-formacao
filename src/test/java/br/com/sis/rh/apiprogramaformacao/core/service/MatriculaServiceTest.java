package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.model.permissoes.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import br.com.sis.rh.apiprogramaformacao.core.service.permissoes.MatriculaService;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import javax.naming.NamingException;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

/**
 * Classe responsável pelos testes do Service MatriculaService.
 *
 * @author Gustavo Juliano
 */

@SpringBootTest
public class MatriculaServiceTest {

    @Autowired
    private MatriculaService matriculaService;

    private static LoginADForm loginADForm = new LoginADForm();

    @BeforeAll
    public static void executaAntesDeTodosOsMetodos () throws NamingException {
        loginADForm.setMatricula("teste");
        loginADForm.setPerfil("ROLE_ADMINISTRADOR");

    }

    @Test
    public void deveriaRetornarUmaListaComTodasAsMatriculas (){
        assertNotNull(matriculaService.buscarTodos());
    }

    @Test
    @WithMockUser("testeUnitarioJUnit")
    public void deveriaCriarUmaMatricula () {
        LoginAD matricula = matriculaService.criaMatricula(loginADForm);
        assertSame(LoginAD.class, matricula.getClass());
    }

    @Test
    @WithMockUser("testeUnitarioJUnit")
    public void deveriaExcluirUmaMatricula () {
        assertEquals(ResponseEntity.ok().build(), matriculaService.deletaMatricula("teste"));
    }

    @Test
    public void deveriaRetornarTodosOsPerfis () {
        assertNotNull(matriculaService.getPerfis());
    }
}
