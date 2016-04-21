package filters;

import akka.stream.Materializer;
import play.Logger;
import play.Logger.ALogger;
import play.mvc.*;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

/**
 * Created by gustavooliveira on 4/21/16.
 */

public class LoggingFilter extends Filter {
    private final ALogger accessLogger;

    @Inject
    public LoggingFilter(Materializer mat) {
        super(mat);
        accessLogger = Logger.of("ACCESS");
    }

    @Override
    public CompletionStage<Result> apply(
            Function<Http.RequestHeader, CompletionStage<Result>> nextFilter,
            Http.RequestHeader requestHeader) {

        long startTime = System.currentTimeMillis();
        return nextFilter.apply(requestHeader).thenApply(result -> {
            long endTime = System.currentTimeMillis();
            long requestTime = endTime - startTime;

            accessLogger.info("{} {} took {}ms and returned {}",
                    requestHeader.method(), requestHeader.uri(), requestTime, result.status());

            return result.withHeader("Request-Time", "" + requestTime);
        });
    }
}
