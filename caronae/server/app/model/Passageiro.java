package model;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

/**
 * Created by stenio on 4/3/2016.
 */
public class Passageiro {
    private Pessoa pessoa;

    public Passageiro(Pessoa pessoa) {
        this.pessoa = pessoa ;
    }

    public Integer getId() {
        return pessoa.getId();
    }

    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.pessoa.getId() + "\"}");
    }
}
