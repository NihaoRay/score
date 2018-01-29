package com.marsdl.common.service;

import com.marsdl.common.persistence.DataEntity;
import com.marsdl.modules.sys.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>titile  service基础类，包含了基本的增删改查</p>
 * <p>@description 在这个系统中，没有使用service接口的实现，仿照了jeesit设计方法。
 * 在参考后jeesit的实践开发中，我认为这种方法挺好的，很适合个人开发和小团队的。
 * </p>
 *
 * @author chenrui
 * @since 2018/1/29
 */
public abstract class CrudService<D extends BaseDao<T>, T extends DataEntity<T>> {

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     */
    public T get(String id) {
        return dao.queryObject(id);
    }

    /**
     * 根据对象获得数据
     */
    public T get(T entity) {
        return dao.queryObject(entity);
    }

    /**
     * 根据集合对象
     */
    public List<T> queryList(T entity) {
        return dao.queryList(entity);
    }

    /**
     * 根据id删除
     */
    public void delete(String id) {
        dao.delete(id);
    }

    /**
     * 增加和修改对象，放在了一起。
     * getIsNewRecord方法以id为标志判断此数据是否为新数据
     */
    public void save(T entity) {
        if(entity.getIsNewRecord()) {
            entity.preInsert();
            dao.save(entity);
        }
        else {
            entity.preUpdate();
            dao.update(entity);
        }
    }
}
