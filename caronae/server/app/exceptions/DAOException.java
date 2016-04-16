package exceptions;

import javax.ws.rs.core.Response.Status;
import exceptions.DAOErroMensagem;
import exceptions.DAOParameterErrors;
import exceptions.ParametersExceptions;
import model.HttpException;

public class DAOException extends CaronaeException {
	
	private static final long serialVersionUID = 1L;
	
	private DAOErroMensagem template;

	public DAOException(DAOErroMensagem template, Exception ex) {
		super(ex);
		this.template = template;
		if (ex instanceof HttpException) {
			setCodigoErro(Status.NOT_FOUND);
		} else {
			setCodigoErro(Status.BAD_REQUEST);
		}
	}

	public DAOException(DAOErroMensagem template) {
		this(template, null);
	}

	@Override
	public String getMessage() {
		String mensagem = template.getTemplate();
		for (ParametersExceptions key : super.parameters.keySet()) {
			mensagem = mensagem.replace(((DAOParameterErrors) key).name(),
					parameters.get(key));
		}
		return mensagem;
	}

	@Override
	public Status getCodigoErro() {
		return codigoErro;
	}
}