package org.telesoftas;


public class NatIDValidator
{
    public static boolean validateID(long id) {
        CompositeValidator compositeValidator = new CompositeValidator();
        // Validate id is exactly 11 digits
        compositeValidator.addValidator(new LengthValidator());
        // Validate id starts with correct digit
        compositeValidator.addValidator(new StartingDigitValidator());
        // Validate id digits 2-7 represent a valid date format
        compositeValidator.addValidator(new DateValidator());
        // TODO: add Control Digit validator


        return compositeValidator.validate(id);
    }
}
