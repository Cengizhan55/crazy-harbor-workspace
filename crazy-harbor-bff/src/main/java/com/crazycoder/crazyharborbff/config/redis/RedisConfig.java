package com.crazycoder.crazyharborbff.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig {


    @Value("${cache.config.entryTtl:60}")
    private int entryTtl;

    @Value("${cache.config.harbor-user.entryTtl:30}")
    private int harborUsersEntityTtl;


    @Bean
    public RedisTemplate <String,String> redisTemplate (RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String,String> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setEnableTransactionSupport(true);

        return template;
    }


    /**
     * idk why do we need configs below.
     */


    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration
                .defaultCacheConfig() // serialization problems
                .entryTtl(Duration.ofMinutes(entryTtl))
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(RedisSerializer.json()));
    }



    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return builder -> {
            var harborUserConf = RedisCacheConfiguration.defaultCacheConfig()
                    .entryTtl(Duration.ofMinutes(harborUsersEntityTtl));

            builder.withCacheConfiguration(CacheNames.HARBOR_USERS, harborUserConf);
        };
    }



    //todo redis template incele...
}
