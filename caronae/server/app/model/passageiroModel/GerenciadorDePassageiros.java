package model.passageiroModel;

import model.HttpException;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;

import java.util.HashMap;

/**
 * Created by stenio on 4/3/2016.
 */
public class GerenciadorDePassageiros {
    private HashMap<String, Passageiro> passageiros = new HashMap<>();
    private static GerenciadorDePassageiros gerenciador;
    private GerenciadorDePessoas gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();

    private GerenciadorDePassageiros(){};

    /**
     * @return A instancia de GerenciadorDePassageiros
     */
    public static GerenciadorDePassageiros getGerenciador() {
        if (gerenciador == null)
            gerenciador = new GerenciadorDePassageiros();

        return gerenciador;
    }
    /**
     * Recupera um passageiro da coleção de passageiros
     * @param id O id do passageiro
     * @return retorna null se o não existir algum passgeiro com a mesma id que a id especificada, caso contrário retorna o passgeiro
     */
    public Passageiro getPassageiro(String id) throws HttpException {
        Passageiro passageiro = passageiros.get(id);

        if (passageiro == null) {
            throw new HttpException(404, "Passageiro does not exist");
        }

        return passageiro;
    }

    /**
     * Adiciona um passageiro a coleção de passageiros
     * @param id O id do novo passageiro
     * @return retorna false se não for possível adicionar o passageiro a coleção, caso contrário retorna true.
     */
    public void addPassageiro(String id) throws HttpException {
//        if (passageiros.containsKey(id)) {
//            throw new HttpException(409, "Passageiro already exists");
//        } else if (!gerenciadorDePessoas.existePessoa(id)) {
//            throw new HttpException(404, "There is no Pessoa with this id. It is necessary to create a person before creating a Passageiro.");
//        } else {
//            Pessoa pessoa = gerenciadorDePessoas.getPessoa(id);
//
//            passageiros.put(id, new Passageiro(pessoa));
//        }
    }

    /**
     * Verifica se existe algum passageiro com aquele id;
     * @param id O id do passageiro
     * @return true se existe um passageiro com o mesmo id, caso contr[ario false
     */
    public boolean existePassageiro(String id) {
        return passageiros.containsKey(id);
    }
}
