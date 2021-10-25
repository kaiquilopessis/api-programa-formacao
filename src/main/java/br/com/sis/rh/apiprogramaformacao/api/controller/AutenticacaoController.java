package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.config.TokenService;
import br.com.sis.rh.apiprogramaformacao.api.vo.AutenticacaoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.TokenVo;
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
    private TokenService tokenService;

    @PostMapping
    @CrossOrigin
    // Esse método recebe as requisições e autentica os dados presentes no Body
    // Caso os dados (Usuario e Senha) coincidem com os presentes no BD, o método retorna
    // o Token para utilização da API.
    public ResponseEntity<TokenVo> autenticar(@RequestBody @Valid AutenticacaoForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);

            return ResponseEntity.ok(new TokenVo(token, "Bearer"));
        }
        catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{token}")
    @CrossOrigin
    public String verificaToken(@PathVariable String token){
        if(tokenService.isTokenValido(token)){
            return "SUCESSO";
        }

        return "ERRO";
    }
}
