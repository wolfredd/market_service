package com.sagatrading.marketdata.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;
@Configuration
public class RedisPubSubConfig {
    @Value("${CHANNEL_TOPIC}")
    private String channelTopic;

    @Bean
    ChannelTopic channelTopic() {
        System.out.println(channelTopic);
        return new ChannelTopic(channelTopic);
    }
}
