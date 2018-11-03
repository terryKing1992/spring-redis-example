package com.terrylmay.redis.example;

import com.terrylmay.redis.example.config.StandaloneRedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication(scanBasePackages = {"com.terrylmay.redis.example"})
public class RedisExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisExampleApplication.class, args);
    }

    @Autowired
    StandaloneRedisConfig standaloneRedisConfig;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    @ConditionalOnBean(value = {StandaloneRedisConfig.class})
    public RedisConnectionFactory standaloneRedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory(new RedisStandaloneConfiguration(standaloneRedisConfig.getHost(), standaloneRedisConfig.getPort()));
        return factory;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        return new StringRedisTemplate(redisConnectionFactory);
    }
}
