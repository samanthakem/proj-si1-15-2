package model;

import java.util.HashMap;

/**
 * Created by stenio on 4/3/2016.
 */
public class GerenciadorDePessoas {
    private HashMap<Integer, Pessoa> pessoas = new HashMap<>();
    private static GerenciadorDePessoas gerenciador;

    private GerenciadorDePessoas(){}

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
     * @param matricula A matricula da pessoa
     * @return retorna null se o não existir alguma pessoa com a mesma id que a id especificada, caso contrário retorna a pessoa
     * @throws HttpException se a Pessoa não existir na coleção
     */
    public Pessoa getPessoa(Integer matricula) throws HttpException{
        Pessoa pessoa = pessoas.get(matricula);

        if (pessoa == null) {
            throw new HttpException(404, "Pessoa does not exist");
        }

        return pessoa;
    }

    /**
     * Adiciona um passageiro a coleção de pessoas
     * @param nome o nome da nova pessoa
     * @param bairro o bairro da nova pessoa
     * @param rua a rua da nova pessoa
     * @param email o email da nova pessoa
     * @param telefone o telefone da nova pessoa
     * @param senha a senha da nova pessoa
     * @param matricula a matricula da nova pessoa
     * @throws HttpException se a Pessoa já existir na coleção
     */
    public void addPessoa(String nome, String bairro, String rua, String email, String telefone, String senha, Integer matricula) throws HttpException {
        if (pessoas.containsKey(matricula)) {
            throw new HttpException(409, "Pessoa already exists");
        } else {
            pessoas.put(matricula, new Pessoa(nome, bairro, rua, email, telefone, senha, matricula));
        }
    }

    /**
     * Verifica se existe alguma pessoa com aquele id;
     * @param matricula A matricula da pessoa
     * @return true se existe uma pessoa com o mesmo id, caso contr[ario false
     */
    public boolean existePessoa(Integer matricula) {
        return pessoas.containsKey(matricula);
    }
}
