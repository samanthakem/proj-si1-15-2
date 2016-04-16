package exceptions;

import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;

/**
 * Created by stenio on 4/3/2016.
 */
public class HttpException extends CaronaeException {

	private static final long serialVersionUID = 1L;
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

	@Override
	public Status getCodigoErro() {
		// TODO Auto-generated method stub
		return null;
	}
}
