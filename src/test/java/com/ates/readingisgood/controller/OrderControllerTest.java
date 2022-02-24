package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.service.order.OrderService;
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

@WebMvcTest(controllers = {OrderController.class, AuthController.class})
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private AuthController authController;

    private ObjectMapper objectMapper = new ObjectMapper();

    private String token;

    @Captor
    private ArgumentCaptor<OrderDto> orderDtoArgumentCaptor;


    @BeforeEach
    public void it_should_return_token() throws Exception {

        mockMvc.perform(get("/token")
                .contentType(MediaType.APPLICATION_JSON));
        //Then
        token = authController.getToken();
    }

    @Test
    public void it_should_get_order_by_id() throws Exception {
        //Given & //When
        Integer id = 1;
        OrderDto orderDto = OrderDto.builder().customerId(id).build();
        List<OrderDto> customerOrders = new ArrayList<>();
        customerOrders.add(orderDto);
        when(orderService.get(id)).thenReturn(orderDto);

        final ResultActions resultActions =
                mockMvc.perform(get("/orders/{id}", id)
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON));
        //Then
        verify(orderService).get(id);
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void it_should_save_order() throws Exception {
        //Given & //When
        Integer id = 1;
        OrderDto orderDto = OrderDto.builder().customerId(id).build();
        when(orderService.create(orderDto)).thenReturn(orderDto);

        final ResultActions resultActions =
                mockMvc.perform(post("/orders")
                        .header("Authorization", token)
                        .content(objectMapper.writeValueAsString(orderDto))
                        .contentType(MediaType.APPLICATION_JSON));
        //Then
        verify(orderService).create(orderDtoArgumentCaptor.capture());
        resultActions.andExpect(status().isOk());
    }

}