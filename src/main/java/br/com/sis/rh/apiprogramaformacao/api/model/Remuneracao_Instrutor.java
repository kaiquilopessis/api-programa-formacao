package br.com.sis.rh.apiprogramaformacao.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_REMUNERACAO_INSTRUTOR")
@Getter
@Setter
@NoArgsConstructor
public class Remuneracao_Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "codigo_instrutor_fk")
    private Instrutor instrutor;
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;
    @Column(name = "qtd_hora")
    private Integer quantidadeHora;
    @Column(name = "vlr_hora")
    private BigDecimal valorHora;
    @Column(name = "cargo")
    private String cargo;

    public Remuneracao_Instrutor(Instrutor instrutor, LocalDate dataFormatada, BigDecimal valorHoraFormatado, Integer horasTrabalhadasFormatada){
        this.instrutor = instrutor;
        this.dataLancamento = dataFormatada;
        this.quantidadeHora = horasTrabalhadasFormatada;
        this.valorHora = valorHoraFormatado;
    }
}
