package exceptions;

public enum DAOErroMensagem {
	
	CONSULTA_ID_NULO (
		"Erro ao realizar consulta na " + DAOParameterErrors.NOME_ARRAY + " com id nulo."
	), 
	CONSULTA_ID_NAO_ENCONTRADO (
		"Erro ao realizar consulta na " + DAOParameterErrors.NOME_ARRAY + " com id: " + DAOParameterErrors.ID_DA_ENTIDADE
	), 
	SALVAR_ENTIDADE_JA_EXISTENTE (
			"Erro ao persistir entidade com id: " + DAOParameterErrors.ID_DA_ENTIDADE + ". Entidade já existente."
	);
	
	private final String template;

	private DAOErroMensagem(String template) {
		this.template = template;
	}

	public String getTemplate() {
		return template;
	}

}
