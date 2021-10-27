package br.com.sis.rh.apiprogramaformacao.api.vo;

public class TokenVo {

    private String tipo;
    private String token;


    public TokenVo(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public String getToken() {
        return token;
    }
}
