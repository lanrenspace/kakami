package com.lanrenspace.kakami.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @Author lanrenspace@163.com
 * @Description: redis常用操作
 **/
public class RedisUtils {

    @Autowired
    private ReactiveRedisTemplate<String, Object> redisTemplate;


    /**
     * set
     *
     * @param key
     * @param value
     * @param seconds
     */
    public void set(String key, Object value, long seconds) {
        set(key, value, Duration.ofSeconds(seconds));
    }

    /**
     * set
     *
     * @param key
     * @param value
     * @param duration
     */
    public void set(String key, Object value, Duration duration) {
        redisTemplate.opsForValue().set(key, value, duration);
    }

    /**
     * set
     *
     * @param key
     * @param value
     */
    public void setNeverExpires(String key, Object value) {
        set(key, value, -1);
    }


    /**
     * get
     *
     * @param key
     * @return
     */
    public Mono<Object> get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * del
     *
     * @param key
     * @return
     */
    public Mono<Long> del(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * hasKey
     *
     * @param key
     * @return
     */
    public Mono<Boolean> hasKey(String key) {
        return redisTemplate.hasKey(key);
    }
}
