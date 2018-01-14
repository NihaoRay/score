package com.marsdl.common.util;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>titile  cache工具类</p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/14
 */
public class CacheUtil {

    private static Logger logger = LoggerFactory.getLogger(CacheUtil.class);
    private static CacheManager cacheManager = SpringContextHolder.getBean(CacheManager.class);

    private static final String SYS_CACHE = "sysCache";


    /**
     * 获取SYS_CACHE
     * @param key
     * @return
     */
    public static Object get(String key ) {
        return get(SYS_CACHE, key);
    }

    /**
     * 跟剧key获得缓存
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object get(String key, Object defaultValue) {
        Object value = get(key);
        return value;
    }

    /**
     * 获取缓存
     * @param cacheName
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object get(String cacheName, String key, Object defaultValue) {
        Object value = get(cacheName, key);
        return value != null ? value : defaultValue;
    }

    /**
     * 获取SYS_CACHE缓存
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key) {
        return getCache(cacheName).get(key);
    }

    /**
     * 写入缓存
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        getCache(cacheName).put(key, value);
    }

    /**
     * 获得一个Cache，没有字则显示日志跑出异常
     * @param cacheName
     * @return
     */
    public static Cache<String, Object> getCache(String cacheName) {
        Cache<String, Object> cache = cacheManager.getCache(cacheName);
        if(cache == null) {
            throw new RuntimeException("当前系统中没有定义“" + cacheName + "”这个缓存");
        }
        return cache;
    }
}
