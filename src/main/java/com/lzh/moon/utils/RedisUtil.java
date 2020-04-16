package com.lzh.moon.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 操作redis的工具类
 *
 * @author LiAnGzh
 * @date 2020/4/14 20:26
 */
@Component
public class RedisUtil {

    @Autowired
    private JedisPool jedisPool;


    /**
     * @return 返回redis连接对象
     */
    private Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * @param client
     * 关闭redis流
     */
    private void returnJedis(Jedis client) {
        client.close();
    }
    public void set(String key, String value) {
        Jedis client = getJedis();
        try {
            boolean keyExist = client.exists(key);
            // NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
            if (keyExist) {
                client.del(key);
            }
            client.set(key,value,"nx","ex",120);
        }finally{
            returnJedis(client);
        }
    }


    //根据key获取value
    public String get(String key) {
        Jedis client = getJedis();
        try {
            return client.get(key);
        } finally {
            returnJedis(client);
        }
    }

    //根据键值获取value
    public String hashGet(String key, String field) {
        Jedis client = getJedis();
        try {
            return client.hget(key, field);
        } finally {
            returnJedis(client);
        }

    }

    public void hashSet(String key, String field, String value) {
        Jedis client = getJedis();
        try {
            client.hset(key, field, value);
        } finally {
            returnJedis(client);
        }

    }


    //判断key是否存在
    public boolean existKey(String key) {
        Jedis client = getJedis();
        try {
            return client.exists(key);
        } finally {
            returnJedis(client);
        }
    }
}
