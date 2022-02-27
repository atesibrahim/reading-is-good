package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.StatisticsDto;
import com.ates.readingisgood.service.statistics.StatisticsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {StatisticsController.class, AuthController.class})
class StatisticsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatisticsService statisticsService;

    @Autowired
    private AuthController authController;

    private ObjectMapper objectMapper = new ObjectMapper();

    private String token;



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
        StatisticsDto statisticsDto = StatisticsDto.builder().build();
        List<StatisticsDto> customerStatistics = new ArrayList<>();
        customerStatistics.add(statisticsDto);
        when(statisticsService.getCustomerMonthlyStatistics(id, 0, 4)).thenReturn(customerStatistics);

        final ResultActions resultActions =
                mockMvc.perform(get("/statistics/{id}", id)
                                .param("page_no", "0")
                                .param("page_size", "4")
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON));
        //Then
        verify(statisticsService).getCustomerMonthlyStatistics(id, 0, 4);
        resultActions.andExpect(status().isOk());
    }

}