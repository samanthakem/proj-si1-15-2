package model.passageiroModel;

import model.caronaModel.Carona;

/**
 * Created by stenio, aline.
 */
public class GerenciadorDePassageiros implements PassageiroService {
    
    private static GerenciadorDePassageiros gerenciador;

    private PassageiroDao passageiroDao = new PassageiroDao();

    private PassageiroValidador passageiroValidador = new PassageiroValidador();

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
     * Recupera um passageiro
     * @param {String} matricula
     *          A matricula do passageiro
     * @return {Object} passageiro
     *          Retorna null se não existir algum passageiro com a matricula, caso contrário retorna o passageiro
     */
    public Passageiro getPassageiro(String matricula) {
        passageiroValidador.validarExistenciaPassageiro(matricula);
        Passageiro passageiro = passageiroDao.getPassageiro(matricula);
        return passageiro;
    }

    /**
     * Adiciona um passageiro a coleção de passageiros
     * @param {Object} passageiro
     *          o passageiro a ser adicionado
     */
    public void addPassageiro(Passageiro passageiro) {
        passageiroValidador.validarCadastro(passageiro);
        passageiroDao.persistirPassageiro(passageiro);
    }

    /**
     * Verifica se existe algum passageiro cadastrado com aquela matricula;
     * @param matricula A matricula do passageiro
     * @return true se existe um passageiro com a mesma matricula, caso contrário false
     */
    public boolean existePassageiro(String matricula) {
        return passageiroDao.existePassageiro(matricula);
    }

    public static void setGerenciador(GerenciadorDePassageiros gerenciador) {
        GerenciadorDePassageiros.gerenciador = gerenciador;
    }
    
	@Override
	public void addPassageiroNaCarona(Passageiro passageiro, Carona carona) {
        passageiroDao.atualizarPassageiro(passageiro);
	}
}

