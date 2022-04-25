package org.telesoftas;


import org.telesoftas.validators.*;

public class NatIDValidator
{
    public static Result validateID(long id) {
        CompositeValidator compositeValidator = new CompositeValidator();
        // Validate id is exactly 11 digits
        compositeValidator.addValidator(new LengthValidator(id));
        // Validate id starts with correct digit
        compositeValidator.addValidator(new GenderValidator(id));
        // Validate id digits 2-7 represent a valid date format
        compositeValidator.addValidator(new DateValidator(id));
        // Validate id control digit
        compositeValidator.addValidator(new ControlDigitValidator(id));

        return compositeValidator.validate();
    }
}
