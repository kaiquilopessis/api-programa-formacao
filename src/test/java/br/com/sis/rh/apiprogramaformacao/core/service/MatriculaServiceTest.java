package br.com.sis.rh.apiprogramaformacao.core.service;

import br.com.sis.rh.apiprogramaformacao.api.controller.ADController;
import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.model.Perfil;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.input.LoginInput;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import br.com.sis.rh.apiprogramaformacao.core.ad.ConnectAD;
import br.com.sis.rh.apiprogramaformacao.core.ad.UsuarioAD;
import br.com.sis.rh.apiprogramaformacao.core.repository.PerfilRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.naming.NamingException;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

@SpringBootTest
public class MatriculaServiceTest {

    @Autowired
    private MatriculaService matriculaService;

    private static LoginADForm loginADForm = new LoginADForm();

    @BeforeAll
    public void executaAntesDeTodosOsMetodos () throws NamingException {
        loginADForm.setMatricula("teste");
        loginADForm.setPerfil("ROLE_ADMINISTRADOR");
    }

    @Test
    public void deveriaRetornarUmaListaComTodasAsMatriculas () {
        List<LoginADDto> lista = matriculaService.buscarTodos();

        assertNotNull(lista);
    }

    @Test
    public void deveriaCriarUmaMatricula () {
        LoginAD matricula = matriculaService.criaMatricula(loginADForm);
        assertSame(LoginAD.class, matricula.getClass());
    }

    @Test
    public void deveriaExcluirUmaMatricula () {
        assertEquals(ResponseEntity.ok().build(), matriculaService.deletaMatricula("teste"));
    }

    @Test
    public void deveriaRetornarTodosOsPerfis () {
        assertNotNull(matriculaService.getPerfis());
    }
}
