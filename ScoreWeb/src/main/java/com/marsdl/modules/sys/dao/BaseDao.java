package com.marsdl.modules.sys.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>title 基本Dao</p>
 * @author chenrui
 * @email chenrui@marsdl.com
 */
public interface BaseDao<T> {
    /**
     * 保存
     */
    void save(T entity);

    /**
     *保存数据，参数以键值对形式
     */
    void save(Map<String, Object> map);

    /**
     * 更新数据
     */
    int update(T t);

    /**
     * 更新数据，参数以键值对形式
     */
    int update(Map<String, Object> map);

    /**
     * 根据id删除数据，删除数据时候，只是修改del_flag
     */
    int delete(Object id);

    int delete(Map<String, Object> map);

    /**
     * 根据id数组批量删除数据
     */
    int delete(Object[] id);

    /**
     * 根据id获得数据对象
     */
    T queryObject(@Param("id") String id);

    /**
     * 根据集合对象获取对象
     */
    T queryObject(T entity);

    /**
     * 获得list集合对象
     */
    List<T> queryList(Map<String, Object> map);

    /**
     * 根据某个id，获取集合对象
     */
    List<T> queryList(@Param("id") String id);

    /**
     * 根据某个id，获取集合对象
     */
    List<T> queryList(T entity);

    /**
     * 获得集合对象的总数
     */
    int queryTotal(Map<String, Object> map);

    int queryTotal();

}
