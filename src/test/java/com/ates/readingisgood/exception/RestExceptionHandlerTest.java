package com.ates.readingisgood.exception;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestExceptionHandlerTest {

    RestExceptionHandler restExceptionHandler;

    @Test
    public void it_should_be_test_handle_date_exception (){
        restExceptionHandler = new RestExceptionHandler();
        DateException dateException = new DateException("This is a date exception");

        assertEquals("400 BAD_REQUEST", restExceptionHandler.handleDateException(dateException).getStatusCode().toString());
    }

    @Test
    public void it_should_be_test_handle_entity_not_found(){
        restExceptionHandler = new RestExceptionHandler();
        EntityNotFoundException entityNotFoundException = new EntityNotFoundException("Entity not found");

        assertEquals("404 NOT_FOUND", restExceptionHandler.handleEntityNotFound(entityNotFoundException).getStatusCode().toString());
    }

    @Test
    public void it_should_be_test_handle_record_not_found(){
        restExceptionHandler = new RestExceptionHandler();
        RecordNotFoundException recordNotFoundException = new RecordNotFoundException("Record not found");

        assertEquals("404 NOT_FOUND", restExceptionHandler.handleRecordNotFound(recordNotFoundException).getStatusCode().toString());
    }

    @Test
    public void it_should_be_test_handle_sufficient_exception(){
        restExceptionHandler = new RestExceptionHandler();
        SufficientException sufficientException = new SufficientException("Sufficient Exception");

        assertEquals("400 BAD_REQUEST", restExceptionHandler.handleSufficientExcedption(sufficientException).getStatusCode().toString());
    }

}