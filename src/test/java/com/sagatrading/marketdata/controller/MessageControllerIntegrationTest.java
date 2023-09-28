package com.sagatrading.marketdata.controller;

import com.sagatrading.marketdata.service.RedisPublisher;
import com.sagatrading.marketdata.service.TradingPriceHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringJUnitConfig
@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RedisPublisher redisPublisher;

    @MockBean
    private TradingPriceHistoryService tradingPriceHistoryService;

    @BeforeEach
    public void setUp() {
        Mockito.reset(redisPublisher, tradingPriceHistoryService);
    }

    @Test
    public void testPublishExchange1() throws Exception {
        String marketData = "sample market data";
        mockMvc.perform(MockMvcRequestBuilders.post("/publish-exchange1")
                        .content(marketData)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that the appropriate methods were called
        Mockito.verify(tradingPriceHistoryService).addTradingPriceToDb(marketData);
        Mockito.verify(redisPublisher).publishMessage(marketData);
    }

    @Test
    public void testPublishExchange2() throws Exception {
        String marketData = "sample market data";
        mockMvc.perform(MockMvcRequestBuilders.post("/publish-exchange2")
                        .content(marketData)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that the appropriate methods were called
        Mockito.verify(redisPublisher).publishMessage(marketData);
        Mockito.verifyNoInteractions(tradingPriceHistoryService);
    }
}
