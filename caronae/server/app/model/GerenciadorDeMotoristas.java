package model;

import java.util.HashMap;

/**
 * Created by stenio on 4/3/2016.
 */
public class GerenciadorDeMotoristas {
    private static HashMap<Integer, Motorista> motoristas = new HashMap<>();

    /**
     * Recupera um motorista da coleção de motoristas
     * @param id O id do motorista
     * @return retorna null se o não existir algum passgeiro com a mesma id que a id especificada, caso contrário retorna o passgeiro
     */
    public static Motorista getMotorista(Integer id) throws HttpException {
        Motorista motorista = motoristas.get(id);

        if (motorista == null) {
            throw new HttpException(404, "motorista does not exist");
        }

        return motorista;
    }

    /**
     * Adiciona um motorista a coleção de motoristas
     * @param id O id do novo motorista
     * @return retorna false se não for possível adicionar o motorista a coleção, caso contrário retorna true.
     */
    public static void addMotorista(Integer id) throws HttpException {
        if (motoristas.containsKey(id)) {
            throw new HttpException(409, "Motorista already exists");
        } else if (!GerenciadorDePessoas.existePessoa(id)) {
            throw new HttpException(404, "There is no Pessoa with this id. It is necessary to create a person before creating a motorista.");
        } else {
            Pessoa pessoa = GerenciadorDePessoas.getPessoa(id);

            motoristas.put(id, new Motorista(pessoa));
        }
    }

    /**
     * Verifica se existe algum motorista com aquele id;
     * @param id O id do motorista
     * @return true se existe um motorista com o mesmo id, caso contr[ario false
     */
    public static boolean existeMotorista(Integer id) {
        return motoristas.containsKey(id);
    }
}
