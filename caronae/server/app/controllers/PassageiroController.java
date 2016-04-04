package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.GerenciadorDePassageiros;
import model.HttpException;
import model.Passageiro;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by stenio on 4/3/2016.
 */
public class PassageiroController extends Controller {

    public Result getPassageiro(Integer id) {
        Result result;
        JsonNode resultJson;

        try {
            Passageiro passageiro = GerenciadorDePassageiros.getPassageiro(id);
            result = ok(passageiro.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }

    public Result addPassageiro(Integer id) {
        Result result = ok();
        JsonNode resultJson;

        try {
            GerenciadorDePassageiros.addPassageiro(id);

            Passageiro passageiro = GerenciadorDePassageiros.getPassageiro(id);

            result = ok(passageiro.toJson());
        } catch(HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }
}
