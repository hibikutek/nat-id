package org.telesoftas.validators;

import org.telesoftas.Result;

public class LengthValidator implements Validator {

    @Override
    public Result validate(long id) {
        if (11 == (int) Math.log10(id) + 1) return Result.OK;
        return Result.ERROR.setMessage("ID has incorrect length");
    }
}
