package br.com.sis.rh.apiprogramaformacao.core.repository.investimentos;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.investimentos.Investimentos;

public interface InvestimentosRepository extends JpaRepository<Investimentos, Long> {
	//Busca o salário total pelo CPF do participante
    @Query(value = "select sum(remuneracao + beneficios + encargos) from TB_INVESTIMENTOS  " +
            "where cpf_participante_fk = ?1", nativeQuery = true)
    Integer buscarSalarioPeloCpf(String cpf);

    //Busca o salário total entre os periodos selecionados e pelo cpf do participante
    @Query(value = "select sum(remuneracao + beneficios + encargos) from TB_INVESTIMENTOS " +
            "where cpf_participante_fk = ?1 AND data_lancamento between ?2 AND ?3"
    , nativeQuery = true)
    Integer buscarSalarioPeloCpfData(String cpf, LocalDate dataInicio, LocalDate dataFim);

}
