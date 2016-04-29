package model.caronaModel;

import model.motoristaModel.Motorista;
import model.passageiroModel.Passageiro;
import model.Endereco;
import model.Horario;

import java.util.List;
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

	List<Carona> getCaronas(Endereco origem, Endereco destino, Horario horario, Integer limite);
	
}
