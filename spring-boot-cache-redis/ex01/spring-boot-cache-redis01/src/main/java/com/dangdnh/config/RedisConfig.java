package com.dangdnh.config;

import com.dangdnh.definition.CacheNames;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Getter
@Configuration
@EnableCaching
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.cache.redis.key-prefix}")
    private String keyPrefix;

    @Value("${app.cache.ttlInSecond}")
    private long ttlInSecond;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheConfiguration defaultCacheConfig = configureCache(keyPrefix, ttlInSecond, true);
        return RedisCacheManager.builder(redisConnectionFactory())
                .cacheDefaults(defaultCacheConfig)
                .withCacheConfiguration(CacheNames.TEACHER, configureCache(keyPrefix, ttlInSecond, true))
                .withCacheConfiguration(CacheNames.TEACHER_ALL_ENTRIES, configureCache(keyPrefix, ttlInSecond, true))
                .withCacheConfiguration(CacheNames.STUDENT, configureCache(keyPrefix, ttlInSecond, true))
                .withCacheConfiguration(CacheNames.STUDENT_ALL_ENTRIES, configureCache(keyPrefix, ttlInSecond, true))
                .transactionAware()
                .build();
    }

    private RedisCacheConfiguration configureCache(String keyPrefix, long ttlInSecond, boolean nullValueDisable) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .prefixCacheNameWith(keyPrefix)
                .entryTtl(Duration.ofSeconds(ttlInSecond))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
                        new GenericJackson2JsonRedisSerializer()));
        config = nullValueDisable ? config.disableCachingNullValues() : config;
        return config;
    }
}
