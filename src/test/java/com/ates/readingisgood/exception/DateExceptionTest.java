package com.ates.readingisgood.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateExceptionTest {

    @Test
    public void it_should_equals_message(){
        String message = "this is dateexception";

        try {
            throw new DateException(message);
        } catch (DateException e) {
            assertEquals(message, e.getMessage());
        }

    }
}