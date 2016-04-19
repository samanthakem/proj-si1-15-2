package model.passageiroModel;

import model.caronaModel.Carona;
import model.passageiroModel.Passageiro;

public interface PassageiroService {

	/**
	 * Recupera um passageiro da colecao de passageiros
	 * @param {String} idPassageiro
	 * 		id do passageiro a ser recuperado
	 * @return {Object} passageiro
	 * 		Retorna um passageiro
	 */
	Passageiro getPassageiro(String idPassageiro);
	
	/**
	 * Adiciona um passageiro em uma carona
	 * @param {Object} passageiro
	 * 		passageiro a ser adicionado na carona
	 * @param {Object} carona
	 * 		carona a ser adicionada na carona
	 */
	void addPassageiroNaCarona(Passageiro passageiro, Carona carona);

}
