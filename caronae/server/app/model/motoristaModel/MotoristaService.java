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
	 * Adiciona um motorista a coleção de motoristas
	 * @param {Object} motorista
	 * 		Motorista que sera adicionada no sistema
	 */
	void addMotorista(Motorista motorista);
}
