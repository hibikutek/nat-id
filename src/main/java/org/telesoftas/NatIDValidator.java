package org.telesoftas;


public class NatIDValidator
{
    public static boolean validateID(long id) {
        CompositeValidator compositeValidator = new CompositeValidator();
        // Validate number is exactly 11 digits
        compositeValidator.addValidator(obj -> 11 == (int) Math.log10(obj) + 1);

        return compositeValidator.validate(id);
    }
}
