package br.com.sis.rh.apiprogramaformacao.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.config.AutenticacaoService;
import br.com.sis.rh.apiprogramaformacao.api.config.TokenService;
import br.com.sis.rh.apiprogramaformacao.api.model.UsuarioAcesso;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TokenVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.UsuarioForm;
import br.com.sis.rh.apiprogramaformacao.core.ad.UsuarioAD;

@Service
public class AutenticacaoADService {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private AutenticacaoService authService;

	@Autowired
	private TokenService tokenService;

	public ResponseEntity<TokenVo> autenticacao(UsuarioAD usuarioAD){

		UsernamePasswordAuthenticationToken dadosLogin = usuarioAD.converter();

		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);

			return ResponseEntity.ok(new TokenVo("Bearer", token));
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	public TokenVo autenticacaoNova(UsuarioAD usuarioAD){

		UsernamePasswordAuthenticationToken dadosLogin = usuarioAD.converter();
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);

			return new TokenVo("Bearer", token);
	}

	public String verificacao(String token) {
		if (tokenService.isTokenValido(token)) {
			return "SUCESSO";
		}

		return "ERRO";
	}

	public ResponseEntity cadastrarUsuario(UsuarioForm form) {
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
