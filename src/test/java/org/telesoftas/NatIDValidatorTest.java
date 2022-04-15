package org.telesoftas;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for the Nat ID Validator class.
 */
public class NatIDValidatorTest
{

    public static final long VALID_ID = 36412170085L;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void validID()
    {
        assertTrue(NatIDValidator.validate(VALID_ID));
    }
}
