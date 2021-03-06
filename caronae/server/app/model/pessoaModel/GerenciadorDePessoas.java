package model.pessoaModel;

import model.caronaModel.Carona;
import model.caronaModel.GerenciadorDeCaronas;

import java.util.List;
import java.util.Set;

/**
 * Classe responsavel por implementar os servicos da entidade {@Pessoa}
 * @author Stenio Elson, Samantha Monteiro
 */
public class GerenciadorDePessoas implements PessoaService {

    private static GerenciadorDePessoas gerenciador;

    private PessoaDao dao = new PessoaDao();
    
    private PessoaValidador pessoaValidador = new PessoaValidador();

    private GerenciadorDeCaronas gerenciadorCaronas;


    private GerenciadorDePessoas() {
        gerenciadorCaronas = GerenciadorDeCaronas.getGerenciador();
    }

    /**
     * @return A instancia de GerenciadorDePessoas
     */
    public static GerenciadorDePessoas getGerenciador() {
        if (gerenciador == null)
            gerenciador = new GerenciadorDePessoas();
        return gerenciador;
    }

    /**
     * Recupera um passageiro da coleção de pessoas
     * @param {String} matricula 
     * 		A matricula da pessoa
     * @return {Object} pessoa
     * 		Retorna null se não existir alguma pessoa com a mesma id que a id especificada, caso contrário retorna a pessoa
     */
    public Pessoa getPessoa(String matricula) {
    	pessoaValidador.validarExistenciaPessoa(matricula);
        Pessoa pessoa = dao.getPessoa(matricula);
        return pessoa;
    }

    /**
     * Adiciona uma pessoa a coleção de pessoas
	 * @param {Object} pessoa
	 * 		Pessoa que sera adicionada no sistema
     */
    public void addPessoa(Pessoa pessoa) {
        pessoaValidador.validarCadastro(pessoa);
		dao.persistirPessoa(pessoa);
    }

    public static void setGerenciador(GerenciadorDePessoas gerenciador) {
        GerenciadorDePessoas.gerenciador = gerenciador;
    }
}
