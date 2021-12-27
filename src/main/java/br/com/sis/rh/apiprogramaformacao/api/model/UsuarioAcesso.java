package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO_ACESSO")
public class UsuarioAcesso {

    @Id
    @Column(name = "usuario_AD", nullable = false, length = 50)
    private String usuarioAd;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "senha_criptografada", length = 20, nullable = false)
    private String senha;
    @Column(name = "data_inclusao")
    private LocalDate dataInclusao;

    public UsuarioAcesso(){}

    public UsuarioAcesso(String usuario, String senha){
        this.usuarioAd = usuario;
        this.senha = senha;
    }

    public String getUsuarioAd() {
        return usuarioAd;
    }
    public void setUsuarioAd(String usuarioAd) {
        this.usuarioAd = usuarioAd;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }
    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }
}
