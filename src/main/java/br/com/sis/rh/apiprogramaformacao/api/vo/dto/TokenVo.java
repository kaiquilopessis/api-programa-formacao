package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenVo {

    private String tipo;
    private String token;

}
