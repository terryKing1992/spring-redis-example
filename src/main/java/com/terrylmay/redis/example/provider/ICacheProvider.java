package com.terrylmay.redis.example.provider;

public interface ICacheProvider {
    void setString(String key, String value);

    String getString(String key);
}
