package org.telesoftas;

public class LengthValidator implements Validator {

    @Override
    public boolean validate(long id) {
        return 11 == (int) Math.log10(id) + 1;
    }
}
