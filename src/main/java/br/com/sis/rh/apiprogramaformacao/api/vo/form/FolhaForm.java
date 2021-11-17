package br.com.sis.rh.apiprogramaformacao.api.vo.form;


import br.com.sis.rh.apiprogramaformacao.api.model.Investimentos;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class FolhaForm {

    private String nome;
    private String mesAno;
    private String remuneracao;
    private String encargos;
    private String beneficios;
    private String descricao;

    public static Investimentos converter(FolhaForm folhaForm, Participante participante){
        DateTimeFormatter nome = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        BigDecimal remuneracaoFormatada = new BigDecimal(folhaForm.getRemuneracao());
        BigDecimal encargoFormatado = new BigDecimal(folhaForm.getEncargos());
        BigDecimal beneficiosFormatado = new BigDecimal(folhaForm.getBeneficios());
        LocalDate dataFormatada = LocalDate.parse(folhaForm.getMesAno(), nome);
        return new Investimentos(participante, dataFormatada, remuneracaoFormatada, encargoFormatado, beneficiosFormatado, descricao);
    }

}
