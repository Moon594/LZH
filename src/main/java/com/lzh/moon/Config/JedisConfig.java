package com.lzh.moon.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis配置类
 *
 * @author LiAnGzh
 * @date 2020/4/14 20:01
 */
@Configuration
public class JedisConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private int maxWait;



    @Bean
    public JedisPool redisPoolFactory() {
        //创建jedis连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置配置参数
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        //创建jedis连接池对象
        //返回连接池对象
        return new JedisPool(jedisPoolConfig, host, port, timeout, password);
    }
}
