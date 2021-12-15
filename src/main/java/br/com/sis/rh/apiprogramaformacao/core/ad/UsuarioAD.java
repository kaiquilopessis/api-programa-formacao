package br.com.sis.rh.apiprogramaformacao.core.ad;

import java.io.Serializable;

import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@NoArgsConstructor
public class UsuarioAD implements Serializable{
	
	private static final long serialVersionUID = 3773551911483960017L;
	
	private String nome;
	private String sobrenome;
	private String matricula;
	private String email;
	private String telefone;
	
	@SneakyThrows
	public UsuarioAD(Attributes attributes) {
		nome = getAttribute(attributes.get("givenname"));
		sobrenome = getAttribute(attributes.get("sn"));
		matricula = getAttribute(attributes.get("samaccountname"));
		email = getAttribute(attributes.get("mail"));
		telefone = getAttribute(attributes.get("telephonenumber"));
	}
	
	private String getAttribute(Attribute attribute) {
		try {
			return attribute != null ? attribute.get().toString() : null;
		} catch (Exception e) {
			return null;
		}
	}

}
