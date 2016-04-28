package controllers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import model.Endereco;
import model.Horario;
import model.caronaModel.Carona;
import model.caronaModel.GerenciadorDeCaronas;
import model.motoristaModel.GerenciadorDeMotoristas;
import model.motoristaModel.Motorista;
import model.pessoaModel.Pessoa;
import model.sessaoModel.SessaoValidador;
import play.mvc.Controller;
import play.mvc.Result;
import util.Utils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe referente ao controller de Carona
 * @author Samantha Monteiro
 */
public class CaronaController extends Controller {
	
	private GerenciadorDeCaronas gerenciadorDeCaronas;

    private GerenciadorDeMotoristas gerenciadorDeMotoristas;

    private SessaoValidador sessaoValidador;


    public CaronaController(){
        gerenciadorDeCaronas = GerenciadorDeCaronas.getGerenciador();
        gerenciadorDeMotoristas = GerenciadorDeMotoristas.getGerenciador();
        sessaoValidador = new SessaoValidador();
    }

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
    	
    	/*JsonNode request = request().body().asJson();

    	String id = Utils.getAtributo("id", request);
    	String idMotorista = Utils.getAtributo("idMotorista", request);

    	String ruaInicial = Utils.getAtributo("ruaInicial", request);
    	String bairroInicial = Utils.getAtributo("bairroInicial", request);
    	String numInicial = Utils.getAtributo("numInicial", request);
    	Endereco enderecoInicial = new Endereco(numInicial, ruaInicial, bairroInicial);

    	String ruaFinal = Utils.getAtributo("ruaInicial", request);
    	String bairroFinal = Utils.getAtributo("bairroInicial", request);
    	String numFinal = Utils.getAtributo("numInicial", request);
    	Endereco enderecoFinal = new Endereco(numFinal, ruaFinal, bairroFinal);

    	Horario horario = new Horario();

    	Carona carona = new Carona(id, idMotorista, enderecoInicial, enderecoFinal, horario);
        gerenciadorDeCaronas.addCarona(carona);
        return ok(carona.toJson());*/
		return ok();
    }

}
