package org.telesoftas.validators;

import org.telesoftas.Result;

import java.time.format.DateTimeParseException;
import java.util.concurrent.CompletableFuture;


public class DateValidator implements Validator {
    private final long id;

    public DateValidator(long id) {
        this.id = id;
    }

    /**
     * Date validation will first convert the id to a substring of the 2-7 digits. Then it
     * checks if the id matches the edge case of all 00s. Finally, it will try to parse the
     * date.  If it succeeds, the date is valid and return true.  If there's a parse exception
     * return false
     * @return true if valid date or edge case, false if failure to parse date
     */
    @Override
    public CompletableFuture<Result> validate() {
        return CompletableFuture.supplyAsync(this::isDateValid);
    }

    public Result isDateValid() {
        String strID = String.valueOf(id).substring(1, 7);
        if (strID.matches("000000")) return Result.OK;
        try {
            Utils.parseBirthDate(id);
            return Result.OK;
        } catch (DateTimeParseException e) {
            return Result.ERROR.setMessage("ID birthdate is invalid");
        }
    }
}
