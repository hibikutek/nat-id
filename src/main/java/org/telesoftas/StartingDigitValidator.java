package org.telesoftas;

public class StartingDigitValidator implements Validator {
    public StartingDigitValidator() {
    }

    @Override
    public boolean validate(long id) {

        String strID = String.valueOf(id);
        return strID.matches("^[3456].*");
    }
}
