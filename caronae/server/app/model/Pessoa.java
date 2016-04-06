package model;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

/**
 * Created by stenio on 4/3/2016.
 */
public class Pessoa {
    private Integer id;

    public Pessoa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    /**
     * A informação da Pessoa em formato JSON
     * @return A informação da Pessoa
     */
    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.id + "\"}");
    }
}
