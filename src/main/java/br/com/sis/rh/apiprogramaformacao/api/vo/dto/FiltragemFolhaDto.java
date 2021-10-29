package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FiltragemFolhaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_participante")
    private String nomeParticipante;
    @Column(name = "nome_formacao")
    private String nomeFormacao;
    @Column(name = "nome_turma")
    private String nomeTurma;
    @Column(name = "bolsa_aux")
    private BigDecimal bolsaAux;
}
