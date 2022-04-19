package org.telesoftas.validators;

import org.jetbrains.annotations.NotNull;
import org.telesoftas.Result;

public class ControlDigitValidator implements Validator {

    @Override
    public Result validate(long id) {
        char[] charArrayID = String.valueOf(id).toCharArray();
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
