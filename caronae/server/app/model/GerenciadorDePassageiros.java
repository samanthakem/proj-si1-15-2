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
    public static Passageiro getPassageiro(Integer id) {
        return passageiros.get(id);
    }

    /**
     * Adiciona um passageiro a coleção de passageiros
     * @param id O id do novo passageiro
     * @return retorna false se não for possível adicionar o passageiro a coleção, caso contrário retorna true.
     */
    public static boolean addPassageiro(Integer id) {
        boolean result;

        if (passageiros.containsKey(id)) {
            result = false;
        } else {
            passageiros.put(id, new Passageiro(id));
            result = true;
        }

        return result;
    }
}
