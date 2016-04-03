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

    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.id + "\"}");
    }
}
