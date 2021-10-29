package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FiltragemInstrutorDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpf_instrutor")
    private String cpf_instrutor;
    @Column(name = "nome_instrutor")
    private String nomeInstrutor;
    @Column(name = "nome_programa")
    private String nomeFormacao;
    @Column(name = "nome_turma")
    private String nomeTurma;
    @Column(name = "vlr_hora_instrutor")
    private BigDecimal ValorHora;


    // Retirar o cpf do get pelo front
}
