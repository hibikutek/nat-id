package org.telesoftas;

import java.util.Arrays;

public class ControlDigitValidator implements Validator {
    /**
     * TODO: Implement simple version of validator
     * @param id National ID
     * @return true if control digit properly evaulates
     */
    @Override
    public boolean validate(long id) {
        char[] charArrayID = String.valueOf(id).toCharArray();
        return firstPass(charArrayID);
    }

    private boolean firstPass(char[] charArrayID) {
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

        if (result < 10 && result == controlDigit) return true;
        return secondPass(charArrayID);
    }

    private boolean secondPass(char[] charArrayID) {
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

        if (result < 10 && result == controlDigit) return true;
        return charArrayID[charArrayID.length - 1] == 0;
    }
}
