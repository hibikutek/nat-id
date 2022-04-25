package org.telesoftas.validators;


import org.telesoftas.Result;

import java.util.concurrent.CompletableFuture;

public interface Validator{
    CompletableFuture<Result> validate();
}
