package com.marsdl.modules.sys.dao;

import com.marsdl.common.annotation.MyBatisDao;
import com.marsdl.modules.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao
 * @author chenrui
 * @email chenrui@marsdl.com
 */
public interface BaseDao<T> {

    void save(T t);

    void save(Map<String, Object> map);

    void saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int delete(Map<String, Object> map);

    int delete(Object[] id);

    T queryObject(@Param("id") Object id);

    List<T> queryList(Map<String, Object> map);

    List<T> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();

}
