package model.motoristaModel;

import model.HttpException;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;

import java.util.HashMap;

/**
 * Created by stenio on 4/3/2016.
 */
public class GerenciadorDeMotoristas {
    private HashMap<Integer, Motorista> motoristas = new HashMap<>();
    private static GerenciadorDeMotoristas gerenciador;
    private GerenciadorDePessoas gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();

    private GerenciadorDeMotoristas(){};

    /**
     * @return A instancia de GerenciadorDeMotoristas
     */
    public static GerenciadorDeMotoristas getGerenciador() {
        if (gerenciador == null)
            gerenciador = new GerenciadorDeMotoristas();

        return gerenciador;
    }

    /**
     * Recupera um motorista da coleção de motoristas
     * @param id O id do motorista
     * @return retorna null se o não existir algum passgeiro com a mesma id que a id especificada, caso contrário retorna o passgeiro
     */
    public Motorista getMotorista(Integer id) throws HttpException {
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
    public void addMotorista(Integer id) throws HttpException {
//        if (motoristas.containsKey(id)) {
//            throw new HttpException(409, "Motorista already exists");
//        } else if (!gerenciadorDePessoas.existePessoa(id)) {
//            throw new HttpException(404, "There is no Pessoa with this id. It is necessary to create a person before creating a motorista.");
//        } else {
//            Pessoa pessoa = gerenciadorDePessoas.getPessoa(id);
//
//            motoristas.put(id, new Motorista(pessoa));
//        }
    }

    /**
     * Verifica se existe algum motorista com aquele id;
     * @param id O id do motorista
     * @return true se existe um motorista com o mesmo id, caso contr[ario false
     */
    public boolean existeMotorista(Integer id) {
        return motoristas.containsKey(id);
    }
}
