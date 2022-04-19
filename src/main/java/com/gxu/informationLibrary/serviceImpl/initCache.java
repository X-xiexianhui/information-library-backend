package com.gxu.informationLibrary.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class initCache {
    private final RedisTemplate redisTemplate;

    public initCache(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @PostConstruct
    public void initCacheFunc(){
        log.info("Redis初始化成功");
    }
}
