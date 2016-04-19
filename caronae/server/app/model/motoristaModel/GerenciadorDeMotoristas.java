package model.motoristaModel;

import model.passageiroModel.GerenciadorDePassageiros;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;

import java.util.HashMap;

import exceptions.HttpException;

/**
 * Created by stenio, aline.
 */
public class GerenciadorDeMotoristas {

    private static GerenciadorDeMotoristas gerenciador;

    private MotoristaDao motoristaDao = new MotoristaDao();

    private MotoristaValidador motoristaValidador = new MotoristaValidador();

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
     * @param {String} matricula
     *          A matricula do motorista
     * @return {Object} motorista
     *          Retorna null se não existir algum motorista com a mesma matricula que a especificada, caso contrário retorna o motorista
     */
    public Motorista getMotorista(String matricula) {
        motoristaValidador.validarExistenciaMotorista(matricula);
        Motorista motorista = motoristaDao.getMotorista(matricula);
        return motorista;
    }

    /**
     * Adiciona um motorista a coleção de motoristas
     * @param {Object} motorista
     *          o motorista a ser adicionado
     */
    public void addMotorista(Motorista motorista) {
       motoristaValidador.validarCadastro(motorista);
       motoristaDao.persistirMotorista(motorista);
    }

    /**
     * Verifica se existe algum motorista cadastrado com aquela matricula;
     * @param matricula A matricula do motorista
     * @return true se existe um motorista com a mesma matricula, caso contrário false
     */
    public boolean existeMotorista(String matricula) {
        return motoristaDao.existeMotorista(matricula);
    }

    public static void setGerenciador(GerenciadorDeMotoristas gerenciador) {
        GerenciadorDeMotoristas.gerenciador = gerenciador;
    }
}