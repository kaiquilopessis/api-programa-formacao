package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class FiltragemFolhaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeParticipante;
    private String nomeFormacao;
    private String nomeTurma;
    private BigDecimal bolsaAux;

}
