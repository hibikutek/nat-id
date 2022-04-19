package org.telesoftas.validators;

import org.telesoftas.Result;

public class GenderValidator implements Validator {
    public GenderValidator() {
    }

    @Override
    public Result validate(long id) {
        String strID = String.valueOf(id);
        if (strID.matches("^[3456].*")) return Result.OK;
        return Result.ERROR.setMessage("ID has invalid gender digit");
    }
}
