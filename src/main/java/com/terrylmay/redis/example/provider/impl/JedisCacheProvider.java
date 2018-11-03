package com.terrylmay.redis.example.provider.impl;

import com.terrylmay.redis.example.provider.ICacheProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class JedisCacheProvider implements ICacheProvider {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
