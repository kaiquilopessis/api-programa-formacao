package br.com.sis.rh.apiprogramaformacao.api.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.permissoes.LoginAD;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    //Pega o secret do Application.properties
    @Value("${api-programa-formacao.jwt.secret}")
    private String secret;

    //Pega o expiration (tempo de expiração do Token) do Application.properties
    @Value("${api-programa-formacao.jwt.expiration}")
    private String expiration;

    // Gera o token, utilizando a Autenticacao dos Dados de login
    public String gerarToken(Authentication auth){
        LoginAD logado = (LoginAD) auth.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));


        return Jwts.builder()
                .setIssuer("API do SPF")
                .setSubject(logado.getUsername())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Verifica se o Token enviado no Header das requisições é válido
    public boolean isTokenValido(String token) {
        try{
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    // Pega o ID do usuário através do Token
    public String getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
