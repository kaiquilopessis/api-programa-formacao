package br.com.sis.rh.apiprogramaformacao.api.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_INVESTIMENTOS")
@Getter
@Setter
@NoArgsConstructor
public class Investimentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "cpf_participante_fk")
    private Participante participante;
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;
    @Column(name = "remuneracao")
    private BigDecimal remuneracao;
    @Column(name = "encargos")
    private BigDecimal encargos;
    @Column(name = "beneficios")
    private BigDecimal beneficios;
    @Column(name = "descricao")
    private String descricao;

    public Investimentos(Participante participante, LocalDate dataFormatada, BigDecimal remuneracaoFormatada, BigDecimal encargoFormatado, BigDecimal beneficiosFormatado, String descricao) {
        this.participante = participante;
        this.dataLancamento = dataFormatada;
        this.remuneracao = remuneracaoFormatada;
        this.encargos = encargoFormatado;
        this.beneficios = beneficiosFormatado;
        this.descricao = descricao;
    }
}
