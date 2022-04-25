package org.telesoftas.validators;

import org.jetbrains.annotations.NotNull;
import org.telesoftas.Result;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompositeValidator {
    List<Mono<Result>> validationMonos = new ArrayList<>();

    public void addValidator(@NotNull Validator validator) {
        Mono<Result> val = Mono.fromFuture(validator.validate());
        validationMonos.add(val);
    }

    /**
     * Runs all the validators against the given ID
     * @return true if it passes all validators, false otherwise
     */
    public Result validate() {
        return Flux.fromStream(validationMonos.stream())
                .parallel()
                .runOn(Schedulers.parallel())
                .flatMap(mono -> mono)
                .filter(result -> !result.isValid())
                .sequential()
                .next()
                .switchIfEmpty(Mono.just(Result.OK))
                .block();
    }
}
