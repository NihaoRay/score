package com.marsdl.modules.sys.entity;

import com.marsdl.common.persistence.DataEntity;

/**
 * @Description
 * @Author chenrui
 * @since 2018/1/12
 */
public class Role extends DataEntity<Role>{

    private static final long serialVersionUID = 1L;
    private String name;    //角色名称
    private String ename;   //角色英语名称
    private String roleType;//权限类型
    private String dataScope;   //数据范围

    private String oldName;     //角色原名称
    private String oldEname;    //角色原英文名称

    private String sysData;     //是否系统数据
    private String useable;     //是否可用

    private boolean isSys;      //是否管理员

    private User user;          //根据用户ID查询角色列表

    public Role() {
        super();
    }

    public Role(String id){
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getOldEname() {
        return oldEname;
    }

    public void setOldEname(String oldEname) {
        this.oldEname = oldEname;
    }

    public String getSysData() {
        return sysData;
    }

    public void setSysData(String sysData) {
        this.sysData = sysData;
    }

    public String getUseable() {
        return useable;
    }

    public void setUseable(String useable) {
        this.useable = useable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isSys() {
        return isSys;
    }

    public void setSys(boolean sys) {
        isSys = sys;
    }
}
