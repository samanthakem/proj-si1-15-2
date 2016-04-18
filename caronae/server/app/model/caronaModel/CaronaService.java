package model.caronaModel;

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
	
}
