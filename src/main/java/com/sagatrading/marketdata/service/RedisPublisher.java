package com.sagatrading.marketdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisPublisher {
    @Autowired
    private final RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private final ChannelTopic channelTopic;

    public RedisPublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic channelTopic) {
        this.redisTemplate = redisTemplate;
        this.channelTopic = channelTopic;
    }
    public void publishMessage(String message) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), message);
    }

}
