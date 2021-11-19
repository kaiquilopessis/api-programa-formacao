package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FiltragemInstrutorDto {
    private String cpfInstrutor;
    private String nomeInstrutor;
    private String nomePrograma;
    private String nomeTurma;
    private Integer qtdHora;
    private BigDecimal vlrHora;
    private LocalDate dataFim;
}
