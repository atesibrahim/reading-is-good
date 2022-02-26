package com.ates.readingisgood.configuration.api;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowerCaseClassNameResolverTest {

    private LowerCaseClassNameResolver lowerCaseClassNameResolver;

    @Test
    public void it_should_be_test (){
        lowerCaseClassNameResolver = new LowerCaseClassNameResolver();
        Object value = "value";
        assertEquals("string", lowerCaseClassNameResolver.idFromValue(value));
        assertEquals("string", lowerCaseClassNameResolver.idFromValueAndType(value, String.class));
        assertEquals(JsonTypeInfo.Id.CUSTOM, lowerCaseClassNameResolver.getMechanism());
    }

}