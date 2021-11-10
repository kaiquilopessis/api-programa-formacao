package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_REMUNERACAO_INSTRUTOR")
public class Remuneracao_Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "codigo_instrutor_fk")
    private String codigo_instrutor_fk;
    @Column(name = "data_lancamento")
    private LocalDate data_lancamento;
    @Column(name = "qtd_hora")
    private Integer qtd_hora;
    @Column(name = "vlr_hora")
    private BigDecimal vlr_hora;
}
