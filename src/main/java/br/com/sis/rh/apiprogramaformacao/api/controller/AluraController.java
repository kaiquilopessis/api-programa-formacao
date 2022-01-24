package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.openApi.AluraControllerOpenApi;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AluraDto;
import br.com.sis.rh.apiprogramaformacao.core.service.AluraService;

@RestController
@RequestMapping("/api/alura")
public class AluraController implements AluraControllerOpenApi{

	/**
	 * Controller direcionado para listagem/cadastro/exclusão dos registros relacionados à Alura. As lógicas estão
	 * nas classes Service encontradas no pacote br.com.sis.rh.apiprogramaformacao.core.service.	
	 */

	@Autowired
	private AluraService aluraService;
	
	/**
	 * Listagem dos registros(Retornando uma lista com campos para a exibição), recebe o CPF do participante na requisição para
	 * retornar os registros de um participante em específico.
	 */
	@Override
	@GetMapping("/{cpf}")
	public List<AluraDto> listaRegistros(@PathVariable String cpf) {
		return aluraService.listaRegistros(cpf);
	}

}
