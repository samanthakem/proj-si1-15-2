package model.pessoaModel;

import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.DAOParameterErrors;
import model.HttpException;

/**
 * Created by gustavooliveira on 4/7/16.
 */
public class PessoaDao {
    private PessoaMock pessoaMock;

    
    public PessoaDao() {
        pessoaMock = PessoaMock.getPessoaMock();
    }

    /**
     * Recupera um objeto {@Pessoa} dado uma matricula.
     * @param {String} matricula 
     * 		A matricula da pessoa
     * @return {Object} pessoa 
     * 		Retorna null se não existir alguma pessoa com a mesma id que a id especificada, caso contrário retorna a pessoa
     */
    public Pessoa getPessoa(String matricula) {
    	Pessoa pessoa;
		// @formatter:off
		try {
			pessoa = pessoaMock.get(matricula);
		} catch (HttpException ex) {
			throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO, ex)
					.addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Pessoas")
					.addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, matricula);
		}
        return pessoa;
    }
    
    /**
     * Salva a pessoa
     * @param {Object} pessoa
     * 		Pessoa que sera salva
     */
    public void persistirPessoa(Pessoa pessoa) {
    	try {
    		pessoaMock.add(pessoa);
    	} catch (HttpException ex) {
    		throw new DAOException(DAOErroMensagem.SALVAR_ENTIDADE_JA_EXISTENTE, ex)
				.addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, pessoa.getMatricula());
    	}
    }
    
    public Pessoa atualizarPessoa(Pessoa pessoa) {
    	return null;
    }
}
