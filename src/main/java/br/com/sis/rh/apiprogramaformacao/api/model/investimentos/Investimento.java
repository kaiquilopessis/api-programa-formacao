package br.com.sis.rh.apiprogramaformacao.api.model.investimentos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;

import java.time.LocalDate;

@Entity
@Table(name = "TB_INVESTIMENTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cpf_participante_fk")
    private Participante participante;
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;
    @Column(name = "remuneracao")
    private Double remuneracao;
    @Column(name = "beneficios")
    private Double beneficios;
    @Column(name = "encargos")
    private Double encargos;
    @Column(name = "descricao")
    private String descricao;
}
