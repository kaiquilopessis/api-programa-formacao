package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AluraDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ApiAluraDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AluraForm;
import br.com.sis.rh.apiprogramaformacao.core.service.AluraService;

@RestController
@RequestMapping("/api/alura")
public class AluraController {

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
	@GetMapping("/{cpf}")
	public List<AluraDto> listaRegistros(@PathVariable String cpf) {
		return aluraService.listaRegistros(cpf);
	}
	
	/**
	 * Cadastro dos registros. Recebe o CPF do participante na requisição para realizar o cadastro específico.
	 */
	@PostMapping("/novo/{cpf}")
	public ResponseEntity<AluraDto> cadastrar(@PathVariable String cpf, @RequestBody AluraForm aluraForm,
			UriComponentsBuilder uriComponentsBuilder) {
		return aluraService.cadastrar(cpf, aluraForm, uriComponentsBuilder);
	}
	
	/**
	 * Delete dos registros. Recebe o ID do registro na requisição para realizar a deleção.
	 */
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<AluraDto> deletar(@PathVariable Long id) {
		return aluraService.deletar(id);
	}
	
	@GetMapping("/consulta")
	public void listarRegistrosApi(){
		aluraService.aluraSchedule();
	}
}
