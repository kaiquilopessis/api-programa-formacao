package br.com.sis.rh.apiprogramaformacao.core.util;

public class FormatterUtil {

    public static String removerMascara(String cpf) {
        return cpf.replace(".", "").replace("-", "");
    }
}
