package com.sagatrading.marketdata.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagatrading.marketdata.model.TradingPriceHistory;
import com.sagatrading.marketdata.repository.TradingPriceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradingPriceHistoryService {
    @Autowired
    private final TradingPriceHistoryRepository tradingPriceHistoryRepository;
    private final ObjectMapper objectMapper;

    public TradingPriceHistoryService(TradingPriceHistoryRepository tradingPriceHistoryRepository, ObjectMapper objectMapper) {
        this.objectMapper = new ObjectMapper();
        this.tradingPriceHistoryRepository = tradingPriceHistoryRepository;
    }


    public void addTradingPriceToDb(String marketData) {
        try {
            TradingPriceHistory tradingPriceHistory = objectMapper.readValue(marketData, TradingPriceHistory.class);
            tradingPriceHistoryRepository.save(tradingPriceHistory);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void getTradingPriceHistory(String product) {
//        try {
//            TradingPriceHistory tradingPriceHistory = objectMapper.readValue(marketData, TradingPriceHistory.class);
//            tradingPriceHistoryRepository.save(tradingPriceHistory);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }

}
