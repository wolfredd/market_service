package com.sagatrading.marketdata.controller;

import com.sagatrading.marketdata.service.RedisPublisher;
import com.sagatrading.marketdata.service.TradingPriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private final RedisPublisher redisPublisher;
    @Autowired
    private TradingPriceHistoryService tradingPriceHistoryService;

    public MessageController(RedisPublisher redisPublisher) {
        this.redisPublisher = redisPublisher;
    }

    @PostMapping("/publish-exchange")
    public void publishExchange(@RequestBody String marketData) {
        System.out.println(marketData);
        tradingPriceHistoryService.addTradingPriceToDb(marketData);
        redisPublisher.publishMessage(marketData);
    }
    //lol
}
