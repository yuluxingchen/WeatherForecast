package com.qianhuan.common.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * spring redis 工具类
 *
 * @author yuluxingchen
 */
@SuppressWarnings(value = { "unchecked", "rawtypes" , "boxing"})
@Component
public class RedisCache {

    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key      缓存的键
     * @param timeout  超时时间
     * @param timeUnit 时间基本单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, TimeUnit timeUnit) {
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, timeUnit));
    }

    /**
     * 设置缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键
     * @param value 缓存的值
     */
    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置缓存基本的对象，Integer、String、实体类等
     *
     * @param key      缓存的键
     * @param value    缓存的值
     * @param timeout  超时时间
     * @param timeUnit 时间基本单位
     */
    public <T> void setCacheObject(final String key, final T value, final long timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 获取缓存的基本对象
     *
     * @param key 缓存键
     * @return 缓存键对应的值
     */
    public <T> T getCacheObject(final String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 删除单个对象
     *
     * @param key 缓存键
     * @return true=删除成功；false=删除失败
     */
    public boolean deleteObject(final String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    /**
     * 删除集合对象
     *
     * @param collection 缓存键的集合
     * @return true=删除成功；false=删除失败
     */
    public long deleteObject(final Collection collection) {
        Long count = redisTemplate.delete(collection);
        return count == null ? 0 : count;
    }

    /**
     * 缓存列表数据
     *
     * @param key      缓存键
     * @param dataList 数据列表
     * @return 缓存的数据对象
     */
    public <T> long setCacheList(final String key, final List<T> dataList) {
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * 获取缓存的列表数据
     *
     * @param key 缓存键
     * @return 缓存的数据对象中的数据
     */
    public <T> List<T> getCacheList(final String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 缓存集合数据
     *
     * @param key     缓存键
     * @param dataSet 数据集合
     * @return 缓存数据的对象
     */
    public <T> BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet) {
        BoundSetOperations<String, T> setOperations = redisTemplate.boundSetOps(key);
        for (T t : dataSet) {
            setOperations.add(t);
        }
        return setOperations;
    }

    /**
     * 获取缓存的集合数据
     *
     * @param key 缓存键
     * @return 数据集合
     */
    public <T> Set<T> getCacheSet(final String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 缓存Map
     *
     * @param key     缓存键
     * @param dataMap 数据Map
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap) {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * 获得缓存的Map
     *
     * @param key 缓存键
     * @return 数据Map
     */
    public <T> Map<String, T> getCacheMap(final String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 向Map中添加数据
     *
     * @param key 缓存键
     * @param hKey 数据中的键
     * @param value 数据中的值
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取Map中对应的数据
     *
     * @param key 缓存键
     * @param hKey 数据中的键
     * @return 数据对象
     */
    public <T> T getCacheMapValue(final String key, final String hKey) {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 删除Map中的数据
     *
     * @param key 缓存键
     * @param hKey 数据中的键
     */
    public void delCacheMapValue(final String key, final String hKey)
    {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(key, hKey);
    }

    /**
     * 获取多个Map中的数据
     *
     * @param key 缓存键
     * @param hKeys 数据键集合
     * @return 对象集合
     */
    public <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hKeys) {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    public Collection<String> keys(final String pattern) {
        return redisTemplate.keys(pattern);
    }
}