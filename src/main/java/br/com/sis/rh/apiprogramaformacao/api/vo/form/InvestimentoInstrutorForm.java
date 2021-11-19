package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Investimentos;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao_Instrutor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor

public class InvestimentoInstrutorForm {

    private String cpf;
    private String mesAno;
    private String valorHora;
    private String horasTrabalhadas;

    public static Remuneracao_Instrutor converter(InvestimentoInstrutorForm investimentoInstrutorForm, Instrutor instrutor){
        DateTimeFormatter nome = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BigDecimal valorHoraFormatado = new BigDecimal(investimentoInstrutorForm.getValorHora());
        Integer horasTrabalhadasFormatada = Integer.parseInt(investimentoInstrutorForm.getHorasTrabalhadas());
        LocalDate dataFormatada = LocalDate.parse(investimentoInstrutorForm.getMesAno(), nome);
        return new Remuneracao_Instrutor(instrutor, dataFormatada, valorHoraFormatado, horasTrabalhadasFormatada);
    }
    
}
