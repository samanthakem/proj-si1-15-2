package exceptions;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Response.Status;

/**
 * 
 * @author Samantha Monteiro
 */
public abstract class CaronaeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected Map<ParametersExceptions, String> parameters;
	
	protected Status codigoErro;

	public CaronaeException(Exception exception) {
		super(exception);
		parameters = new HashMap<ParametersExceptions, String>();
	}
	
	public CaronaeException() {
		parameters = new HashMap<ParametersExceptions, String>();
	}
	
	/**
	 * Recupera o código de erro http da exceção lançada.
	 * 
	 * @return {Status} 
	 * 		Retorna o código de erro http da exceção lançada.
	 */
	public abstract Status getCodigoErro();
	
	/**
	 * Recupera a mensagem de erro da exceção lançada.
	 * 
	 * @return {String} 
	 * 		Retorna a mensagem de erro da exceção lançada.
	 */
	@Override
	public abstract String getMessage();
	
	/**
	 * Seta o código de erro default da exceção lançada.
	 * 
	 * @param {Status} codigoErro
	 * 		Novo código de erro.
	 * @return {CaronaeException}
	 * 		Retorna exceção com código de erro alterado.
	 */
	public CaronaeException setCodigoErro(Status codigoErro) {
		this.codigoErro = codigoErro;
		return this;
	}
}