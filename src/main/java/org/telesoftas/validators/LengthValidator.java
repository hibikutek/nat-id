package org.telesoftas.validators;

import org.telesoftas.Result;

import java.util.concurrent.CompletableFuture;

public class LengthValidator implements Validator {

    private final long id;

    public LengthValidator(long id) {
        this.id = id;
    }

    @Override
    public CompletableFuture<Result> validate() {
        return CompletableFuture.supplyAsync(this::isLengthValid);
    }

    public Result isLengthValid() {
        if (11 == (int) Math.log10(this.id) + 1) return Result.OK;
        return Result.ERROR.setMessage("ID has incorrect length");
    }
}
