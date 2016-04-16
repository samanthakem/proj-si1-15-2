package model.pessoaModel;

import model.HttpException;

/**
 * Classe responsavel por implementar os servicos da entidade {@Pessoa}
 * @author Stenio Elson, Samantha Monteiro
 */
public class GerenciadorDePessoas implements PessoaService {

    private static GerenciadorDePessoas gerenciador;

    private PessoaDao dao = new PessoaDao();
    
    private PessoaValidador validador = new PessoaValidador();
    
    private GerenciadorDePessoas() {}

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
    public Pessoa getPessoa(String matricula) throws HttpException {
        Pessoa pessoa = dao.getPessoa(matricula);

        if(pessoa == null){
            throw new HttpException(404, "This Matricula does not exist");
        }
        return pessoa;
    }

    /**
     * Adiciona um passageiro a coleção de pessoas
	 * @param {Object} pessoa
	 * 		Pessoa que sera adicionada no sistema
     */
    public void addPessoa(Pessoa pessoa) {
        validador.validarCadastro(pessoa);
		dao.persistirPessoa(pessoa);
    }

    public Pessoa addPessoa(String nome, String bairro, String rua, String email, String telefone, String senha, String matricula) throws HttpException {
        Pessoa pessoa = new Pessoa(nome, bairro, rua, email, telefone, senha, matricula);
        validador.validarCadastro(pessoa);
        dao.persistirPessoa(pessoa);
        return pessoa;
    }

    public static void setGerenciador(GerenciadorDePessoas gerenciador) {
        GerenciadorDePessoas.gerenciador = gerenciador;
    }
}
