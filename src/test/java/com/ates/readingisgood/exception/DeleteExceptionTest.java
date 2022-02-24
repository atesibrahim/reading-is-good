package com.ates.readingisgood.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteExceptionTest {

    @Test
    public void it_should_equals_message(){
        String message = "this is deleteexception";

        try {
            throw new DeleteException(message);
        }catch (DeleteException e) {
            assertEquals(message, e.getMessage());
        }

    }
}