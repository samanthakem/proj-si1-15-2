package util;

import exceptions.ValidacaoFieldsException;
import exceptions.ValidacaoParameterErrors;
import java.util.regex.Pattern;
import exceptions.ValidacaoErroMensagem;

/**
 * Classe utilitaria com metodos que podem ser usados na validacao dos objetos.
 * 
 * @author Samantha Monteiro
 *
 */
public class UtilsValidacao {
	
	/**
	 * Verifica se o formato de determinada string eh valida.
	 * @param {String} campo
	 * 		Campo a ser verificado
	 * @param {Pattern} regex
	 * 		Pattern do regex
	 * @return {Boolean}
	 * 		Retorna true se o formato eh valido, false caso contrario.
	 */
	public static boolean validarFormato(String campo, Pattern regex) {
		return regex.matcher(campo).find();
	}
	
	/**
	 * Verifica se um campo nao foi preenchido.
	 * @param {String} campo
	 * 		Campo a ser verificado
	 * @param {String} objeto
	 * 		Nome do campo que sera verificado
	 */
	public static void validaCampoNaoPreenchido(String campo, String nomeCampo) {
		if (Utils.isCampoNaoPreenchido(campo)) {
			throw new ValidacaoFieldsException().addTemplateComParametro(
					ValidacaoErroMensagem.VALOR_NULL, 
					ValidacaoParameterErrors.OBJETO, nomeCampo);
		}
	}
}
