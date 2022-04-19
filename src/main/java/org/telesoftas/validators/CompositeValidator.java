package org.telesoftas.validators;

import org.telesoftas.Result;

import java.util.ArrayList;
import java.util.List;

public class CompositeValidator implements Validator{
    List<Validator> validators = new ArrayList<>();

    public void addValidator(Validator validator) {
        validators.add(validator);
    }

    /**
     * Runs all the validators against the given ID
     * @param id The National ID to validate
     * @return true if it passes all validators, false otherwise
     */
    public Result validate(long id) {
        Result result = Result.OK;
        for (Validator validator : validators) {
            result = validator.validate(id);
            if (!result.isValid()) {
                return result;
            }
        }
        return result;
    }
}
