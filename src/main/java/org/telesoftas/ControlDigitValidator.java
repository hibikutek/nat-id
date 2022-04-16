package org.telesoftas;

public class ControlDigitValidator implements Validator {
    /**
     * TODO: Implement simple version of validator
     * @param id National ID
     * @return true if control digit properly evaulates
     */
    @Override
    public boolean validate(long id) {
        int sum = 0;
        char[] charArrayID = String.valueOf(id).toCharArray();
        if (firstPass(charArrayID)) return true;
        return secondPass(charArrayID);
    }

    private boolean firstPass(char[] charArrayID) {
        return false;
    }

    private boolean secondPass(char[] charArrayID) {
        return false;
    }
}
