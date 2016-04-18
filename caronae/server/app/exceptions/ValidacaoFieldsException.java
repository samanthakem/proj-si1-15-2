package exceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.core.Response.Status;

/**
 * Classe reponsável pela representação e tratamento de uma exceção de validação
 * de campos
 * 
 * @author Samantha Monteiro
 *
 */
public class ValidacaoFieldsException extends CaronaeException {

	private static final long serialVersionUID = 1L;
	
	private List<String> mensagensDeErro = new ArrayList<String>();
	
	public ValidacaoFieldsException(Exception ex) {
		super(ex);
		setCodigoErro(Status.BAD_REQUEST);
	}
	
	public ValidacaoFieldsException() {
		this(null);
	}
	
	@Override
	public int getCodigoErro() {
		return codigoErro.getStatusCode();
	}

	@Override
	public String getMessage() {
		StringBuilder builder = new StringBuilder();
		Iterator<String> iterator = mensagensDeErro.iterator();
		
		while (iterator.hasNext()) {
			String erro = iterator.next();
			builder.append(erro);
			if (iterator.hasNext()) {
				builder.append(" | ");
			}
		}
		return builder.toString() + "%%" + getCodigoErro();
	}
	
	public ValidacaoFieldsException addTemplateComParametro(
			ValidacaoErroMensagem template,
			ValidacaoParameterErrors objeto, String valorObjeto) {
		String mensagem = template.getTemplate().replace(
				objeto.name(), valorObjeto);
		mensagensDeErro.add(mensagem);
		return this;
	}
	
	public ValidacaoFieldsException addTemplate(ValidacaoErroMensagem template) {
		String mensagem = template.getTemplate();
		mensagensDeErro.add(mensagem);
		return this;
	}
	
	/**
	 * Verifica se alguma mensagem de erro foi adicionada a exceção.
	 * 
	 * @return {Boolean} 
	 * 		Retorna true se o número de mensagens for maior que zero, false caso contrário.
	 */
	public boolean temErros() {
		return !mensagensDeErro.isEmpty();
	}
	
	public List<String> getMensagensDeErro() {
		return mensagensDeErro;
	}
}