package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import exceptions.HttpException;
import model.passageiroModel.GerenciadorDePassageiros;
import model.passageiroModel.Passageiro;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by stenio on 4/3/2016.
 */
public class PassageiroController extends Controller {
    private GerenciadorDePassageiros gerenciadorDePassageiros = GerenciadorDePassageiros.getGerenciador();

    /**
     * Recupera uma pessoa da coleção de passageiros
     * @param id O id do passageiro
     * @return Um JSON com as informações do passageiro se foi possível recuperar, caso contrário a explicação em formato JSON.
     */
    public Result getPassageiro(String id) {
        Result result;
        JsonNode resultJson;

        try {
            Passageiro passageiro = gerenciadorDePassageiros.getPassageiro(id);
            result = ok(passageiro.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }

    /**
     * Adiciona um passageiro a coleção de passageiros
     * @param id O id do novo Passageiro
     * @return Um JSON com as informações do passageiro se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    public Result addPassageiro(String id) {
//        Result result;
//
//        try {
//            gerenciadorDePassageiros.addPassageiro(id);
//
//            Passageiro passageiro = gerenciadorDePassageiros.getPassageiro(id);
//
//            result = ok(passageiro.toJson());
//        } catch(HttpException e) {
//            result = status(e.getStatus(), e.getJSONMessage());
//        }
//
//        return result;\
        return null;
    }

}
