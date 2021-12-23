package br.com.sis.rh.apiprogramaformacao.core.ad;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Collectors;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TokenVo;
import br.com.sis.rh.apiprogramaformacao.core.service.AutenticacaoADService;

@Component
public class ConnectAD {
	@Autowired
	private AutenticacaoADService autenticacaoADService;
	
	private final String domain = System.getenv("USERDNSDOMAIN");
	
	private static final String[] userAttributes = {
			"distinguishedName","cn","name",
			"sn","givenname","memberOf","samaccountname",
			"userPrincipalName","mail", "telephonenumber"
	};
	
    public UsuarioAD getUser(String user, String securityToken) throws NamingException {
    	//verificar o user na tabela
    	
		SearchResult sr = getSearchResult(user, securityToken, null);
		UsuarioAD usuarioAD = new UsuarioAD(sr.getAttributes());
		ResponseEntity<TokenVo> tokenLogin = autenticacaoADService.autenticacao(usuarioAD);
		usuarioAD.setTipoToken(tokenLogin.getBody().getTipo());
		usuarioAD.setToken(tokenLogin.getBody().getToken());
		return usuarioAD;
    }
    
	public boolean isAuthenticate(String user, String securityToken) {
		try {
			return authenticate(user, securityToken) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	private InitialDirContext authenticate(String user, String securityToken) {
		try {
			return new InitialDirContext((Hashtable<?, ?>) getContext(user, securityToken));
		} catch (Exception e) {
			return null;
		}
	}
	
	private Map<?, ?> getContext(String user, String securityToken) {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "LDAP://" + domain);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, user + "@" + domain);
		env.put(Context.SECURITY_CREDENTIALS, securityToken);
		return env;
	}
	
	private SearchResult getSearchResult(String user, String securityToken, String userTarget) throws NamingException {
		return authenticate(user, securityToken).search(getDomain(),
				MessageFormat.format("(SAMAccountName={0})",
						userTarget == null ? user : userTarget), getSearchControls()).next();
	}
	
	private SearchControls getSearchControls() {
		SearchControls searchCtls = new SearchControls();
		searchCtls.setReturningAttributes(userAttributes);
		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		return searchCtls;
	}
	
	private String getDomain() {
		return Arrays.stream(domain.split("\\."))
				.map(i -> "DC=" + i).collect(Collectors.joining(","));
	}

}
