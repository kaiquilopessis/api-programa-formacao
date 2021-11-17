package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FiltragemFolhaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpf_participante")
    private String cpfParticipante;
    @Column(name = "nome_participante")
    private String nomeParticipante;
    @Column(name = "nome_programa")
    private String nomeFormacao;
    @Column(name = "nome_turma")
    private String nomeTurma;
    @Column(name = "bolsa_aux")
    private BigDecimal bolsaAux;
    @Column(name = "beneficios")
    private BigDecimal beneficios;
    @Column(name = "convenio")
    private BigDecimal convenio;
    @Column(name = "hr_extra")
    private BigDecimal horaExtra;
    @Column(name = "beneficio_legislacao")
    private BigDecimal beneficioLegislacao;
    @Column(name = "remun_esporadica")
    private BigDecimal remuneracaoEsporadica;
    @Column(name = "remun_extra")
    private BigDecimal remuneracaoExtra;
    @Column(name = "alura")
    private BigDecimal alura;
    @Column(name = "data_fim_programa")
    private LocalDate dataFim;
}
