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
        if (firstPass(charArrayID)) return true;
        return secondPass(charArrayID);
    }

    private boolean firstPass(char[] charArrayID) {
        int sum = 0;
        System.out.println("The char array is " + Arrays.toString(charArrayID));
        for (int i = 0; i < 10; i++) {
            if ((i + 1) % 9 == 0) {
                sum += (Character.getNumericValue(charArrayID[i]) * 9);
            } else {
                sum += (Character.getNumericValue(charArrayID[i]) * ((i + 1) % 9));
            }
            System.out.println(sum);
        }
        int result = sum % 11;
        System.out.print(sum + " % 11 = " + result);

        return result < 10;
    }

    private boolean secondPass(char[] charArrayID) {
        int sum = 0;
        System.out.println("The char array is " + Arrays.toString(charArrayID));
        for (int i = 0; i < 10; i++) {
            if ((i + 3) % 9 == 0) {
                sum += (Character.getNumericValue(charArrayID[i]) * 9);
            } else {
                sum += (Character.getNumericValue(charArrayID[i]) * ((i + 3) % 9));
            }
            System.out.println(sum);
        }
        int result = sum % 11;
        System.out.print(sum + " % 11 = " + result);

        return result < 10 || charArrayID[charArrayID.length-1] == 0;
    }
}
