package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.service.customer.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {CustomerController.class, AuthController.class})
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private AuthController authController;

    private ObjectMapper objectMapper = new ObjectMapper();

    private String token;

    private CustomerDto customerDto;

    @Captor
    private ArgumentCaptor<CustomerDto> customerDtoArgumentCaptor;


    @BeforeEach
    public void it_should_return_token() throws Exception {

        mockMvc.perform(get("/token")
                .contentType(MediaType.APPLICATION_JSON));
        //Then
        token = authController.getToken();
    }

    @Test
    public void it_should_get_customer_order() throws Exception {
        //Given & //When
        Integer id = 1;
        Double balance = 2.0;
        customerDto = CustomerDto.builder().id(id).balance(balance).build();
        OrderDto orderDto = OrderDto.builder().customerId(id).build();
        List<OrderDto> customerOrders = new ArrayList<>();
        customerOrders.add(orderDto);
        when(customerService.listCustomerOrders(id)).thenReturn(customerOrders);

        final ResultActions resultActions =
                mockMvc.perform(get("/customers/{id}/orders", id)
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON));
        //Then
        verify(customerService).listCustomerOrders(id);
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void it_should_save_customer() throws Exception {
        //Given & //When
        Integer id = 1;
        Double balance = 2.0;
        customerDto = CustomerDto.builder().id(id).balance(balance).build();
        when(customerService.create(customerDto)).thenReturn(customerDto);

        final ResultActions resultActions =
                mockMvc.perform(post("/customers")
                        .header("Authorization", token)
                        .content(objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON));
        //Then
        verify(customerService).create(customerDtoArgumentCaptor.capture());
        resultActions.andExpect(status().isOk());
    }

}