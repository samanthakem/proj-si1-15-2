package exceptions;

public enum ValidacaoErroMensagem {

	VALOR_NULL (
		ValidacaoParameterErrors.OBJETO + "can't be empty"
	), FORMATO_INVALIDO (
		ValidacaoParameterErrors.OBJETO + "has invalid format"
	);

	private final String template;

	private ValidacaoErroMensagem(String template) {
		this.template = template;
	}

	public String getTemplate() {
		return template;
	}

}
