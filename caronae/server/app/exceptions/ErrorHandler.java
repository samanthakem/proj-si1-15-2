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
    @Override
    public CompletionStage<Result> onClientError(Http.RequestHeader request, int statusCode, String message) {
        return CompletableFuture.completedFuture(Results.status(statusCode, "{\"error\": \"" + message + "\"}").as("application/json"));
    }

    @Override
    public CompletionStage<Result> onServerError(Http.RequestHeader request, Throwable exception) {
        if (exception instanceof CaronaeException) {
            CaronaeException excep = (CaronaeException) exception;

            return CompletableFuture.completedFuture(Results.ok(excep.getMessage()));
        } else {
            return CompletableFuture.completedFuture(Results.status(500, "{\"error\": \"" + exception.getLocalizedMessage() + "\"}").as("application/json"));
        }

    }
}
