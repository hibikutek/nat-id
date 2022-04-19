package org.telesoftas.validators;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;

public class Utils {
    /**
     * Parses the birth data using LocalDate.  Uses a datetime formatter to convert the birthdate assuming that dates
     * in the future are from 1900s.
     *
     * For example, if today's date is 19th of May 2020, and the birthdate to parse is 20th of May xx20, it will
     * assume that 1920 is the birthdate to store
     *
     * @param nationalID National ID to be parsed, birthdate is the second to seventh digit
     * @return LocalDate of birthdate
     * @throws DateTimeParseException Parse exception handled on create of CRUD operations
     */
    public static LocalDate parseBirthDate(long nationalID) throws DateTimeParseException {
        String strDate = String.valueOf(nationalID).substring(1, 7);
        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder()
                .appendValueReduced(ChronoField.YEAR, 2, 2, LocalDate.now().minusYears(100))
                .appendPattern("MMdd")
                .toFormatter();

        return LocalDate.parse(strDate, dateFormat.withResolverStyle(ResolverStyle.STRICT));
    }

    public static @NotNull String parseGender(long nationalID) {
        int genderDigit = Character.getNumericValue(String.valueOf(nationalID).charAt(0));
        if (genderDigit == 3 || genderDigit == 5) {
            return "male";
        }
        return "female";
    }
}
