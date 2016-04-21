package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;

import play.mvc.Http.Request;

/**
 * Classe utilitaria com metodos que podem ser usados em varias partes do sistema.
 * 
 * @author Samantha Monteiro
 *
 */

public class Utils {
	
	/**
	 * Metodo que verifica se um campo esta vazio ou null.
	 * @param {String} campo
	 * 		Campo o qual sera verificado se é null ou vazio.
	 * @return {Boolean}
	 * 		Retorna true se o campo for vazio ou null, false caso contrario.
	 */
	public static boolean isCampoNaoPreenchido(String campo) {
		return Strings.isNullOrEmpty(campo);
	}
	
	public static String getAtributo(String key, JsonNode request) {
		return request.findPath(key).asText();
	}
	
}
