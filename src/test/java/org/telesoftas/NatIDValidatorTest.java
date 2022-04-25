package org.telesoftas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.telesoftas.validators.ControlDigitValidator;
import org.telesoftas.validators.DateValidator;
import org.telesoftas.validators.LengthValidator;
import org.telesoftas.validators.GenderValidator;

import java.util.Arrays;
import java.util.List;

/**
 * Unit tests for the Nat ID Validator class.
 */
public class NatIDValidatorTest
{

    public static final long VALID_ID = 36412170085L;
    public static final long INVALID_ID = 20018320000L;
    public static final long INVALID_LENGTH_ID = 364121700L;
    public static  List<Long> VALID_STARTING_ID_LIST = Arrays.asList(
            36412170085L, 56412170085L, 46412170085L, 66412170085L);
    public static List<Long> INVALID_STARTING_ID_LIST = Arrays.asList(26412170085L, 86412170085L);
    public static  List<Long> VALID_DATE_ID_LIST = Arrays.asList(
            36412170085L, 39403169485L, 32002290085L, 30000000085L); //includes leap year
    public static  List<Long> INVALID_DATE_ID_LIST = Arrays.asList(
            36413170085L, 39403329485L, 32302290085L, 30001000085L);
    public static  List<Long> VALID_CONTROL_DIGIT_LIST = Arrays.asList(
            36412170085L, 49210022922L, 30001000085L);
    public static  List<Long> INVALID_CONTROL_DIGIT_LIST = Arrays.asList(
            36413170085L, 39403329485L, 32102290085L);

    @Test
    public void validID() {
        assertTrue(NatIDValidator.validateID(VALID_ID).isValid());
    }

    @Test
    public void invalidID() {
        assertFalse(NatIDValidator.validateID(INVALID_ID).isValid());
    }

    @Test
    public void validLength()
    {
        assertTrue(new LengthValidator(VALID_ID).validate().join().isValid());
    }

    @Test
    public void invalidLength() {
        assertFalse(new LengthValidator(INVALID_LENGTH_ID).validate().join().isValid());
    }

    @Test
    public void validStartingDigit() {
        for(long id : VALID_STARTING_ID_LIST) {
            assertTrue(new GenderValidator(id).validate().join().isValid());
        }
    }

    @Test
    public void invalidStartingDigit() {
        for (long id : INVALID_STARTING_ID_LIST) {
            assertFalse(new GenderValidator(id).validate().join().isValid());
        }
    }

    @Test
    public void validDate() {
        for (long id : VALID_DATE_ID_LIST) {
            assertTrue(new DateValidator(id).validate().join().isValid());
        }
    }

    @Test
    public void invalidDate() {
        for (long id : INVALID_DATE_ID_LIST) {
            assertFalse(new DateValidator(id).validate().join().isValid());
        }
    }

    @Test
    public void validControlDigit() {
        for (long id : VALID_CONTROL_DIGIT_LIST) {
            assertTrue(new ControlDigitValidator(id).validate().join().isValid());
        }
    }

    @Test
    public void invalidControlDigit() {
        for (long id : INVALID_CONTROL_DIGIT_LIST) {
            assertFalse(new ControlDigitValidator(id).validate().join().isValid());
        }
    }
}
