package model;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

/**
 * Created by stenio on 4/3/2016.
 */
public class Motorista {
    private Pessoa pessoa;

    public Motorista(Pessoa pessoa) {
        this.pessoa = pessoa ;
    }

    public Integer getId() {
        return pessoa.getId();
    }

    /**
     * A informação do Motorista em formato JSON
     * @return A informação do Motorista
     */
    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.pessoa.getId() + "\"}");
    }
}
