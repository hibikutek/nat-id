package org.telesoftas.validators;

import org.jetbrains.annotations.NotNull;
import org.telesoftas.Result;

import java.util.concurrent.CompletableFuture;

public class ControlDigitValidator implements Validator {

    private final long id;

    public ControlDigitValidator(long id) {
        this.id = id;
    }

    @Override
    public CompletableFuture<Result> validate() {
        return CompletableFuture.supplyAsync(this::isControlDigitValid);
    }

    public Result isControlDigitValid() {
        char[] charArrayID = String.valueOf(this.id).toCharArray();
        return firstPass(charArrayID);
    }

    private Result firstPass(char @NotNull [] charArrayID) {
        int sum = 0;
        int controlDigit = Character.getNumericValue(charArrayID[charArrayID.length - 1]);

        for (int i = 0; i < charArrayID.length - 1; i++) {
            if ((i + 1) % 9 == 0) {
                sum += (Character.getNumericValue(charArrayID[i]) * 9);
            } else {
                sum += (Character.getNumericValue(charArrayID[i]) * ((i + 1) % 9));
            }
        }
        int result = sum % 11;

        if (result < 10 && result == controlDigit) return Result.OK;
        return secondPass(charArrayID);
    }

    private Result secondPass(char @NotNull [] charArrayID) {
        int sum = 0;
        int controlDigit = Character.getNumericValue(charArrayID[charArrayID.length - 1]);

        for (int i = 0; i < charArrayID.length - 1; i++) {
            if ((i + 3) % 9 == 0) {
                sum += (Character.getNumericValue(charArrayID[i]) * 9);
            } else {
                sum += (Character.getNumericValue(charArrayID[i]) * ((i + 3) % 9));
            }
        }
        int result = sum % 11;

        if (result < 10 && result == controlDigit) return Result.OK;
        if (charArrayID[charArrayID.length - 1] == 0) return Result.OK;
        return Result.ERROR.setMessage("ID Has an invalid Control digit");
    }
}
