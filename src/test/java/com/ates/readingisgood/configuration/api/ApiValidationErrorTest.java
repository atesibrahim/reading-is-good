package com.ates.readingisgood.configuration.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiValidationErrorTest {

    private ApiValidationError apiValidationError;

    @BeforeEach
    public void init() {
        String object = "object";
        String message = "message";
        String field = "field";
        Object reject = "reject";
        apiValidationError = new ApiValidationError(object, field, reject, message);
    }

    @Test
    public void it_should_be_test_setter() {
        apiValidationError = new ApiValidationError("ob","mes");
        apiValidationError.setField("fie");
        apiValidationError.setRejectedValue("rej");
        assertEquals("ob", apiValidationError.getObject());
        assertEquals("mes", apiValidationError.getMessage());
        assertEquals("fie", apiValidationError.getField());
        assertEquals("rej", apiValidationError.getRejectedValue());
    }

    @Test
    public void it_should_be_test() {
        assertEquals("object", apiValidationError.getObject());
        assertEquals("message", apiValidationError.getMessage());
        assertEquals("field", apiValidationError.getField());
        assertEquals("reject", apiValidationError.getRejectedValue());
    }

}