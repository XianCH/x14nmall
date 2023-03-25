package com.x14nmall.cloud.common.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

<<<<<<< HEAD

=======
/**
 * @author FrozenWatermelon
 * @date 2020/12/29
 */
>>>>>>> develop
@Configuration
public class RedisLockConfiguration {
    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory){
        return new RedisLockRegistry(redisConnectionFactory,"spring-cloud");
    }
}
