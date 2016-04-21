package exceptions;

import play.mvc.Http.Status;

public class DAOException extends CaronaeException {
	
	private static final long serialVersionUID = 1L;
	
	private DAOErroMensagem template;

	public DAOException(DAOErroMensagem template, Exception ex) {
		super(ex);
		this.template = template;
		if (ex instanceof HttpException) {
			setCodigoErro(((HttpException) ex).getStatus());
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
	public int getCodigoErro() { return this.codigoErro; }
}