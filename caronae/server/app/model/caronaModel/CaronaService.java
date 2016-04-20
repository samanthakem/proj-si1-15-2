package model.caronaModel;

import java.util.List;

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
	void addCarona(Carona carona);
	
	/**
	 * Recupera a quantidade total de caronas no sistema.
	 * @return {int} numero de caronas
	 */
	int getQuantidadeTotalCaronas();
	
	List<Carona> getCaronasDePassageiro(String matricula, Integer limite);
	
	List<Carona> getCaronasDeMotorista(String matricula, Integer limite);
	
}
