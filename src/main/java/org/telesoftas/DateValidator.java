package org.telesoftas;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateValidator implements Validator {
    /**
     * Date validation will first convert the id to a substring of the 2-7 digits. Then it
     * checks if the id matches the edge case of all 00s. Finally, it will try to parse the
     * date.  If it succeeds, the date is valid and return true.  If there's a parse exception
     * return false
     * @param id National ID to validate
     * @return true if valid date or edge case, false if failure to parse date
     */
    @Override
    public boolean validate(long id) {
        String strID = String.valueOf(id).substring(1, 7);
        if (strID.matches("000000")) return true;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(strID);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
