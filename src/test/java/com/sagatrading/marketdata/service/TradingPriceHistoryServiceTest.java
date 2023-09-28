package com.sagatrading.marketdata.service;


import com.sagatrading.marketdata.model.TradingPriceHistory;
import com.sagatrading.marketdata.repository.TradingPriceHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TradingPriceHistoryServiceTest {

    @Autowired
    private TradingPriceHistoryService tradingPriceHistoryService;

    @MockBean
    private TradingPriceHistoryRepository tradingPriceHistoryRepository;




    @Test
    public void testAddTradingPriceToDb_Success() throws Exception {
        // Prepare
        String marketData = "{\"orderType\":\"LIMIT\",\"product\":\"AAPL\",\"side\":\"BUY\",\"orderID\":\"23b3f5a4-1234-5678-90ab-cdef12345678\"," +
                "\"price\":150.0,\"qty\":100,\"cumQty\":50,\"cumPrx\":7500.0,\"exchange\":\"NYSE\",\"timestamp\":" +
                "\"2023-05-27T10:30:00.000Z\"}";

        // Execute
        tradingPriceHistoryService.addTradingPriceToDb(marketData);

        // Verify
        verify(tradingPriceHistoryRepository).save(any(TradingPriceHistory.class));
    }

    @Test
    public void testAddTradingPriceToDb_InvalidJson() {
        // Prepare
        String marketData = "invalid_json";

        // Execute and Verify
        assertThrows(RuntimeException.class, () -> tradingPriceHistoryService.addTradingPriceToDb(marketData));

        verify(tradingPriceHistoryRepository, never()).save(any(TradingPriceHistory.class));
    }

    @Test
    public void testAddTradingPriceToDb_NullMarketData() {
        // Execute and Verify
        assertThrows(RuntimeException.class, () -> tradingPriceHistoryService.addTradingPriceToDb(null));

        verify(tradingPriceHistoryRepository, never()).save(any(TradingPriceHistory.class));
    }



}

