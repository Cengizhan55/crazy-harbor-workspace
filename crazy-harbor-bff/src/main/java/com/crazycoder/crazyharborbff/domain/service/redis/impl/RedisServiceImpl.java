package com.crazycoder.crazyharborbff.domain.service.redis.impl;

import com.crazycoder.crazyharborbff.domain.service.redis.RedisService;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StreamOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.crazycoder.crazyharborbff.config.redis.CacheNames.DEFAULT_EXPIRE_MINUTES;

/**
 * if you need redis cache you can inject the service and use it. RedisTemplate is %99 thread-safe.
 */

@Service
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate redisTemplate;

    private final HashOperations<Object, Object, Object> hashOperations;

    private final ValueOperations<String, String> valueOperations;

    private final ListOperations<String, Object> listOperations;

    private final ClusterOperations<String, Object> clusterOperations;

    private final GeoOperations<String, Object> geoOperations;

    private final HyperLogLogOperations<String, Object> hyperLogLogOperations;

    private final StreamOperations<String, Object, Object> streamOperations;

    private final ZSetOperations<String, Object> zSetOperations;

    public RedisServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.valueOperations = redisTemplate.opsForValue();
        this.listOperations = redisTemplate.opsForList();
        this.clusterOperations = redisTemplate.opsForCluster();
        this.geoOperations = redisTemplate.opsForGeo();
        this.hyperLogLogOperations = redisTemplate.opsForHyperLogLog();
        this.streamOperations = redisTemplate.opsForStream();
        this.zSetOperations = redisTemplate.opsForZSet();
    }

    public void setStringForString(String key, String value) {
        valueOperations.set(key, value);
        redisTemplate.expire(key, Duration.ofMinutes(DEFAULT_EXPIRE_MINUTES).toMillis(), TimeUnit.MILLISECONDS);
    }

    public String getStringForString(String key) {
        return valueOperations.get(key);
    }

    public void deleteStringForString(String key) {
        valueOperations.getAndDelete(key);
    }

}
