package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.config.AutenticacaoService;
import br.com.sis.rh.apiprogramaformacao.api.config.TokenService;
import br.com.sis.rh.apiprogramaformacao.api.model.UsuarioAcesso;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TokenVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AutenticacaoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.UsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

// Essa classe é o controller que recebe requisições para o retorno do Token JWT
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private AutenticacaoService authService;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    // Esse método recebe as requisições e autentica os dados presentes no Body
    // Caso os dados (Usuario e Senha) coincidem com os presentes no BD, o método retorna
    // o Token para utilização da API.
    public ResponseEntity autenticar(@RequestBody @Valid AutenticacaoForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            System.out.println(token);

            return ResponseEntity.ok(new TokenVo(token, "Bearer"));
        }
        catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    // Esse método recebe o token armazenado no FrontEnd e retorna uma String com o resultado
    // da verificação do Token
    @GetMapping("/{token}")
    public String verificaToken(@PathVariable String token){
        if(tokenService.isTokenValido(token)){
            System.out.println("Token válido!!!");
            return "SUCESSO";
        }

        return "ERRO";
    }

    @PostMapping("/cadastro-usuario")
    public ResponseEntity cadastroUsuario(@RequestBody UsuarioForm form){
        UsuarioAcesso usuario = form.converter();

        try{
            authService.salvaUsuario(usuario);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
