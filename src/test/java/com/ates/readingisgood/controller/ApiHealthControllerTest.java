package com.ates.readingisgood.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = ApiHealthController.class)
class ApiHealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ApiHealthController apiHealthController;

    @Test
    public void it_should_equal_by_given_string() throws Exception {
        //Given &  //When
        mockMvc.perform(get("/health")
                .contentType(MediaType.APPLICATION_JSON));

        //Then
        assertEquals(apiHealthController.healtCheck(), "Service is running...");
    }
}