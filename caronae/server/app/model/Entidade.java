package model;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

public class Entidade {
	
	public Entidade() {}
	
    public JsonNode toJson() {
        return Json.toJson(this);
    }
}
