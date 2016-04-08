package model.pessoaModel;

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
    	Pessoa pessoa = null;
        try {
			pessoa = pessoaMock.get(matricula);
		} catch (HttpException e) {
		
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
    	} catch (HttpException e) {
    		
    	}
    }
    
    public Pessoa atualizarPessoa(Pessoa pessoa) {
    	return null;
    }
}
