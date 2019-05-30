package com.terrylmay.redis.example;

import com.terrylmay.redis.example.provider.ICacheProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RedisExampleApplication.class})
public class RedisExampleApplicationTests {

    @Autowired
    ICacheProvider jedisCacheProvider;
    //大三大四

    @Test
    public void contextLoads() {
        jedisCacheProvider.setString("name", "terrylmay");
        System.out.println(jedisCacheProvider.getString("name"));
        Assert.assertEquals("terrylmay", jedisCacheProvider.getString("name"));
    }

}
