package model;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

/**
 * Created by stenio on 4/3/2016.
 */
public class HttpException extends Exception {
    private Integer statusCode;
    private String message;

    public HttpException(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatus() {
        return this.statusCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public JsonNode getJSONMessage() {
        return Json.parse("{\"error\": \"" + this.message + "\"}");
    }
}
