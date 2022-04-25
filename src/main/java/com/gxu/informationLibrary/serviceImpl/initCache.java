package com.gxu.informationLibrary.serviceImpl;

import com.gxu.informationLibrary.dao.authDao;
import com.gxu.informationLibrary.entity.roleAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class initCache {
    private final StringRedisTemplate redisTemplate;
    private final authDao auth;

    public initCache(StringRedisTemplate redisTemplate, authDao auth) {
        this.redisTemplate = redisTemplate;
        this.auth = auth;
    }


    @PostConstruct
    public void initCacheFunc(){
        List<roleAuth>cache=auth.getAuth("");
        HashOperations<String,String,String> hashOps = redisTemplate.opsForHash();
        for (roleAuth r:cache) {
            String key="auth_"+r.getRole_name();
            hashOps.put(key,"add",r.getAdd());
            hashOps.put(key,"del",r.getDel());
            hashOps.put(key,"search",r.getSearch());
            hashOps.put(key,"edit",r.getEditAuth());
        }
        log.info("Redis初始化成功");
    }
}
