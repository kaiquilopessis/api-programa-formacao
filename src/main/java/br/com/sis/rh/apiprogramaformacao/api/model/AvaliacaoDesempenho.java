package br.com.sis.rh.apiprogramaformacao.api.model;

import br.com.sis.rh.apiprogramaformacao.core.enums.Avaliacao;
import br.com.sis.rh.apiprogramaformacao.core.enums.Parecer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "TB_AVALIACAO_DESEMPENHO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDesempenho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "avaliacao")
    @Enumerated(EnumType.STRING)
    private Avaliacao avaliacao;
    @Column(name = "parecer")
    @Enumerated(EnumType.STRING)
    private Parecer parecer;
    @Column(name = "adaptacao")
    private Double adaptacao;
    @Column(name = "qualidade")
    private Double qualidade;
    @Column(name = "cap_tecnica")
    private Double capTecnica;
    @Column(name = "comunicabilidade")
    private Double comunicabilidade;
    @Column(name = "ap_pratica")
    private Double apPratica;
    @Column(name = "dedicacao")
    private Double dedicacao;
    @Column(name = "cooperacao")
    private Double cooperacao;
    @Column(name = "iniciativa")
    private Double iniciativa;
    @Column(name = "disciplina")
    private Double disciplina;
    @Column(name = "organizacao")
    private Double organizacao;
    @Column(name = "responsabilidade")
    private Double responsabilidade;
    @Column(name = "sociabilidade")
    private Double sociabilidade;
    @Column(name = "media")
    private Double media;
}
