package model.motoristaModel;

import model.caronaModel.Carona;

public interface MotoristaService {
	
	/**
	 * Recupera um motorista da colecao de motoristas
	 * @param {String} idMotorista
	 * 		id do motorista a ser recuperado
	 * @return {Object} motorista
	 * 		Retorna um motorista
	 */
	Motorista getMotorista(String idMotorista);
	
	/**
	 * Adiciona um motorista em uma carona
	 * @param {Object} motorista
	 * 		motorista a ser adicionado na carona
	 * @param {Object} carona
	 * 		carona a ser adicionada na carona
	 */
	void addMotoristaNaCarona(Motorista motorista, Carona carona);
	
}
