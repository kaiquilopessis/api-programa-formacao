package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

public class CargoModalDto {
    private Long id;
    private String cargo;

    public CargoModalDto(String cargo, Long id){
        this.cargo = cargo;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
