package model.pessoaModel;

import exceptions.ValidacaoFieldsException;
import javax.ws.rs.core.Response.Status;
import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.DAOParameterErrors;
import exceptions.ValidacaoErroMensagem;
import exceptions.ValidacaoParameterErrors;
import util.RegexPattern;
import util.UtilsValidacao;

/**
 * Classe responsavel pela validacao do modelo Pessoa.
 * 
 * @author Samantha Monteiro
 *
 */

public class PessoaValidador {

	private static final String PESSOA = "Pessoa";
	private static final String EMAIL = "E-mail";
	private static final String MATRICULA = "Matrícula";
	private static final String SENHA = "Senha";
	private static final String NOME = "Nome";
	private static final String BAIRRO = "Bairro";
	private static final String RUA = "Rua";
	private static final String TELEFONE = "Telefone";
	private static final int TAMANHO_MATRICULA_OBRIGATORIO = 9;
	
	private PessoaDao dao = new PessoaDao();
	
	public PessoaValidador() {}
	
	/**
	 * Valida se a pessoa a ser cadastrada eh valida.
	 * @param {Object} pessoa
	 * 		pessoa a ser validada
	 */
	public void validarCadastro(Pessoa pessoa) {
		if (pessoa == null) {
			throw new ValidacaoFieldsException().addTemplateComParametro(
					ValidacaoErroMensagem.VALOR_NULL,
					ValidacaoParameterErrors.OBJETO, PESSOA);
		}
		validarCamposPessoa(pessoa);
	}

	/**
	 * Valida se todos os campos de pessoa sao validos.
	 * @param {Object} pessoa
	 * 		pessoa cujos campos serao validados
	 */
	public void validarCamposPessoa(Pessoa pessoa) {
		validarEmail(pessoa.getEmail());
		validarMatricula(pessoa.getMatricula());
		validarSenha(pessoa.getSenha());
		validarNome(pessoa.getNome());
		validarEndereco(pessoa.getRua(), pessoa.getBairro());
		//validarTelefone(pessoa.getTelefone());
	}
	
	/**
	 * Valida se o email a ser cadastrado eh valido.
	 * @param {String} email
	 *		Email a ser validado.
	 */
	public void validarEmail(String email) {
		UtilsValidacao.validaCampoNaoPreenchido(email, EMAIL);
		if (!UtilsValidacao.validarFormato(email, RegexPattern.VALID_EMAIL_ADDRESS)) {
			throw new ValidacaoFieldsException().addTemplateComParametro(
					ValidacaoErroMensagem.FORMATO_INVALIDO,
					ValidacaoParameterErrors.OBJETO, EMAIL);
		}
	}
	
	/**
	 * Valida se a matricula a ser cadastrada eh valida.
	 * @param {String} matricula
	 *		Matricula a ser validada.
	 */
	public void validarMatricula(String matricula) {
		UtilsValidacao.validaCampoNaoPreenchido(matricula, MATRICULA);
		if (matricula.length() != TAMANHO_MATRICULA_OBRIGATORIO) {
			throw new ValidacaoFieldsException().addTemplateComParametro(
					ValidacaoErroMensagem.FORMATO_INVALIDO, 
					ValidacaoParameterErrors.OBJETO, MATRICULA);
		}
	}
	
	/**
	 * Valida se a senha a ser cadastrada eh valido.
	 * @param {String} senha
	 *		Senha a ser validada.
	 */
	public void validarSenha(String senha) {
		UtilsValidacao.validaCampoNaoPreenchido(senha, SENHA);
	}
	
	/**
	 * Valida se o nome a ser cadastrado eh valido.
	 * @param {String} nome
	 *		Nome a ser validado.
	 */
	public void validarNome(String nome) {
		UtilsValidacao.validaCampoNaoPreenchido(nome, NOME);
	}
	
	/**
	 * Valida se o endereco cadastrado eh valido.
	 * @param {String} rua
	 * 		Rua a ser cadastrada
	 * @param {String} bairro
	 * 		Bairro a ser cadastrado
	 */
	public void validarEndereco(String rua, String bairro) {
		UtilsValidacao.validaCampoNaoPreenchido(rua, RUA);
		UtilsValidacao.validaCampoNaoPreenchido(bairro, BAIRRO);
	}
	
	/**
	 * Valida se o telefone a ser cadastrado eh valido.
	 * @param {String} telefone
	 *		Telefone a ser validado.
	 */
	public void validarTelefone(String telefone) {
		UtilsValidacao.validaCampoNaoPreenchido(telefone, TELEFONE);
		if (!UtilsValidacao.validarFormato(telefone, RegexPattern.VALID_PHONE_NUMBER)) {
			throw new ValidacaoFieldsException().addTemplateComParametro(
					ValidacaoErroMensagem.FORMATO_INVALIDO, 
					ValidacaoParameterErrors.OBJETO, TELEFONE);
		}
	}
	
	/**
	 * Valida se a pessoa ja foi criada.
	 * @param {String} matricula
	 * 		Matricula referente a pessoa a ser procurada
	 */
	public void validarExistenciaPessoa(String matricula) {
		if (matricula == null) {
			throw new DAOException(DAOErroMensagem.CONSULTA_ID_NULO).setCodigoErro(Status.NOT_FOUND)
				.addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Pessoas");
		}
		boolean entidadeExiste = dao.getPessoa(matricula) != null;
		if (!entidadeExiste) {
			throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO).setCodigoErro(Status.NOT_FOUND)
				.addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Pessoas")
				.addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, matricula);
		}
	}
}
