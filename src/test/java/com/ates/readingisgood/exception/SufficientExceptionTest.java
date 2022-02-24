package com.ates.readingisgood.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SufficientExceptionTest {

    @Test
    public void it_should_equals_message(){
        String message = "this is sufficientexception";

        try {
            throw new SufficientException(message);
        } catch (SufficientException e) {
            assertEquals(message, e.getMessage());
        }

    }
}