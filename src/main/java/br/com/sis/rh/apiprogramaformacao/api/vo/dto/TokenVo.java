package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

public class TokenVo {

    private String tipo;
    private String token;

    public TokenVo(String tipo, String token){
        this.tipo = tipo;
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
