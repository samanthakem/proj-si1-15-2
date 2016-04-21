package exceptions;

import play.http.HttpErrorHandler;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by stenio on 4/17/2016.
 */
public class ErrorHandler extends RuntimeException implements HttpErrorHandler {

	private static final long serialVersionUID = 1L;

	@Override
    public CompletionStage<Result> onClientError(Http.RequestHeader request, int statusCode, String message) {
        return CompletableFuture.completedFuture(Results.status(statusCode, "{\"error\": \"" + message + "\"}").as("application/json"));
    }

    @Override
    public CompletionStage<Result> onServerError(Http.RequestHeader request, Throwable exception) {
		exception = exception.getCause();

		String mensagem = exception.getMessage();

		int statusCode = 500;
		if (exception instanceof CaronaeException) {
			statusCode = ((CaronaeException) exception).getCodigoErro();
		}

    	return CompletableFuture.completedFuture(Results.status(statusCode, "{\"error\": \"" + mensagem + "\"}").as("application/json"));
    }
}
