package model.caronaModel;

import model.Horario;
import model.motoristaModel.Motorista;
import model.passageiroModel.Passageiro;

import java.util.Set;

/**
 * Interface responsável pelos serviços de {@Carona}
 * 
 * @author Samantha Monteiro
 *
 */
public interface CaronaService {

	 /**
     * Recupera uma carona da coleção de caronas
     * @param {String} id
     * 		ID da carona
     * @return {Object} carona
     * 		Retorna retorna a carona
     */
	Carona getCarona(String id);

	/**
     * Adiciona uma carona a coleção de caronas
	 * @param {Object} carona
	 * 		Carona que sera adicionada no sistema
     */
	/*void addCarona(Carona carona);*/
	
	/**
	 * Recupera a quantidade total de caronas no sistema.
	 * @return {int} numero de caronas
	 */
	int getQuantidadeTotalCaronas();
	
	Set<Carona> getCaronasDePassageiro(Passageiro passageiro);
	
	Set<Carona> getCaronasDeMotorista(Motorista motorista);

	Set<Carona> getCaronas(String bairroOrigem, String bairroDestino, Horario horario);
	
}
