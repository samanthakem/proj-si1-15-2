package model.pessoaModel;

import exceptions.HttpException;

/**
 * Classe responsável pelos serviços de {@Pessoa}
 * 
 * @author Samantha Monteiro
 *
 */
public interface PessoaService {
	
	 /**
     * Recupera um passageiro da coleção de pessoas
     * @param {String} matricula 
     * 		A matricula da pessoa
     * @return {Object} pessoa
     * 		Retorna null se não existir alguma pessoa com a mesma id que a id especificada, caso contrário retorna a pessoa
     */
	Pessoa getPessoa(String matricula) throws HttpException;

	/**
     * Adiciona um passageiro a coleção de pessoas
	 * @param {Object} pessoa
	 * 		Pessoa que sera adicionada no sistema
     */
	void addPessoa(Pessoa pessoa) throws HttpException;

}
