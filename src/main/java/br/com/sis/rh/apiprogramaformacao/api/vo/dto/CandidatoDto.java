package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidatoParticipante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CandidatoDto {
    private Long id;
    private String nome;


    public CandidatoDto(Candidato candidato) {
        this.id = candidato.getId();
        this.nome = candidato.getNome();

    }


        public static CandidatoDto converterParaDto (Candidato candidato) {
            return new CandidatoDto(candidato);
        }

        public static List<CandidatoDto> converterListaParaDto (List< Candidato >candidatos) {
            List<CandidatoDto> CandidatoDtos = new ArrayList<>();

            candidatos.forEach(candidato -> {
                CandidatoDtos.add(new CandidatoDto(candidato));
            });
            return CandidatoDtos;
        }
    }


