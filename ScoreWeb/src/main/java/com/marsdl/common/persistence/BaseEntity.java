package com.marsdl.common.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.util.UserUtil;

import java.io.Serializable;

/**
 * @Description Entity的支持类，基本类型
 * @Author chenrui
 * @since 2017/10/21
 */
public class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体编号（唯一标识）
     */
    protected String id;

    /**
     * 当前用户
     */
    protected User currentUser;

    @JsonIgnore
    public User getCurrentUser() {
        if(currentUser == null){
            currentUser = UserUtil.getUser();
        }
        return currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public BaseEntity() {

    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";

    /**
     * 是否发布文章
     */
    public static final String NOT_PUBLISH = "0";
    public static final String YES_PUBLISH = "1";

}
