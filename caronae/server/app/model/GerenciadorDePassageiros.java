package model;

import java.util.HashMap;

/**
 * Created by stenio on 4/3/2016.
 */
public class GerenciadorDePassageiros {
    private static HashMap<Integer, Passageiro> passageiros = new HashMap<>();

    /**
     * Recupera um passageiro da coleção de passageiros
     * @param id O id do passageiro
     * @return retorna null se o não existir algum passgeiro com a mesma id que a id especificada, caso contrário retorna o passgeiro
     */
    public static Passageiro getPassageiro(Integer id) throws HttpException {
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
    public static void addPassageiro(Integer id) throws HttpException {
        if (passageiros.containsKey(id)) {
            throw new HttpException(409, "Passageiro already exists");
        } else if (!GerenciadorDePessoas.existePessoa(id)) {
            throw new HttpException(404, "There is no Pessoa with this id. It is necessary to create a person before creating a Passageiro.");
        } else {
            Pessoa pessoa = GerenciadorDePessoas.getPessoa(id);

            passageiros.put(id, new Passageiro(pessoa));
        }
    }

    /**
     * Verifica se existe algum passageiro com aquele id;
     * @param id O id do passageiro
     * @return true se existe um passageiro com o mesmo id, caso contr[ario false
     */
    public static boolean existePassageiro(Integer id) {
        return passageiros.containsKey(id);
    }
}
