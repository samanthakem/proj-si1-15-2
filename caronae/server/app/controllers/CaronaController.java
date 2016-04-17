package controllers;

import model.caronaModel.Carona;
import model.caronaModel.GerenciadorDeCaronas;
import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Result;
import util.Utils;

/**
 * Classe referente ao controller de Carona
 * @author Samantha Monteiro
 */
public class CaronaController extends Controller {
	
	private GerenciadorDeCaronas gerenciadorDeCaronas = GerenciadorDeCaronas.getGerenciador();
	
	/**
     * Recupera uma carona da coleção de caronas
     * @param {String} id 
     * 		O ID da carona
     */
    public Result getCarona(String id) {
        Carona carona = gerenciadorDeCaronas.getCarona(id);
        return ok(carona.toJson());
    }
    
    /**
     * Adiciona uma carona a coleção de caronas
     * @return Um JSON com as informações da pessoa se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    public Result addCarona() {
    	Request request = request();
    	String id = Utils.getAtributo("id", request);
    	Carona carona = new Carona(id);
        gerenciadorDeCaronas.addCarona(carona);
        return ok(carona.toJson());
    }

}
