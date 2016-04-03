package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.GerenciadorDePassageiros;
import model.Passageiro;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by stenio on 4/3/2016.
 */
public class PassageiroController extends Controller {

    public Result getPassageiro(Integer id) {
        Result result;
        JsonNode resultJson;
        Passageiro passageiro = GerenciadorDePassageiros.getPassageiro(id);

        if (passageiro == null) {
            result = notFound(Json.parse("{\"error\": \"id does not exist\"}")).as("application/json");
        } else {
            resultJson = Json.toJson(passageiro);
            result = ok(resultJson);
        }

        return result;
    }

    public Result addPassageiro(Integer id) {
        Result result = ok();
        JsonNode resultJson;

        if (GerenciadorDePassageiros.addPassageiro(id)) {
            resultJson = Json.toJson(GerenciadorDePassageiros.getPassageiro(id));
            result = ok(resultJson);
        } else {
            // STATUS 409 Conflict
            result = status(409, Json.parse("{\"error\": \"id is already in use\"}")).as("application/json");
        }

        return result;
    }
}
