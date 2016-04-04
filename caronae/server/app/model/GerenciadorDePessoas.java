package model;

import java.util.HashMap;

/**
 * Created by stenio on 4/3/2016.
 */
public class GerenciadorDePessoas {
    private static HashMap<Integer, Pessoa> pessoas = new HashMap<>();

    /**
     * Recupera um passageiro da coleção de pessoas
     * @param id O id da pessoa
     * @return retorna null se o não existir alguma pessoa com a mesma id que a id especificada, caso contrário retorna a pessoa
     */
    public static Pessoa getPessoa(Integer id) throws HttpException{
        Pessoa pessoa = pessoas.get(id);

        if (pessoa == null) {
            throw new HttpException(404, "Pessoa does not exist");
        }

        return pessoa;
    }

    /**
     * Adiciona um passageiro a coleção de passageiros
     * @param id O id do novo passageiro
     * @return retorna false se não for possível adicionar o passageiro a coleção, caso contrário retorna true.
     */
    public static void addPessoa(Integer id) throws HttpException {
        if (pessoas.containsKey(id)) {
            throw new HttpException(409, "Pessoa already exists");
        } else {
            pessoas.put(id, new Pessoa(id));
        }
    }

    /**
     * Verifica se existe alguma pessoa com aquele id;
     * @param id O id da pessoa
     * @return true se existe uma pessoa com o mesmo id, caso contr[ario false
     */
    public static boolean existePessoa(Integer id) {
        return pessoas.containsKey(id);
    }
}
