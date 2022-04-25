package org.telesoftas.validators;

import org.telesoftas.Result;

import java.util.concurrent.CompletableFuture;

public class GenderValidator implements Validator {
    private final long id;

    public GenderValidator(long id) {
        this.id = id;
    }

    @Override
    public CompletableFuture<Result> validate() {
        return CompletableFuture.supplyAsync(this::isGenderValid);
    }

    public Result isGenderValid() {
        String strID = String.valueOf(this.id);
        if (strID.matches("^[3456].*")) return Result.OK;
        return Result.ERROR.setMessage("ID has invalid gender digit");
    }
}
