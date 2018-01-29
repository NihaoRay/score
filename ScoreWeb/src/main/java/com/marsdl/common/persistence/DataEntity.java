package com.marsdl.common.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marsdl.common.util.IdGen;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.util.UserUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * <p>@description </p>
 * @author chenrui
 * @since 2017/10/21
 */
public class DataEntity<T> extends BaseEntity<T>{

    private static final long serialVersionUID = 1L;

    protected String remarks;	// 备注
    protected User createBy;	// 创建者
    protected Date createDate;	// 创建日期
    protected User updateBy;	// 更新者
    protected Date updateDate;	// 更新日期
    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）

    /**
     * 是否为新纪录（默认为false），调用setIsNewRecord()设置新纪录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需要从手动传入
     */
    protected boolean isNewRecord = false;

    public DataEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public DataEntity(String id) {
        super(id);
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        //不限制id为UUID，调用setIsNewRecord()使用自定义ID
        if(!this.isNewRecord) {
            setId(IdGen.uuid());
        }
        //获得当前此用户登录时候的信息，此用户信息是保存在ehcache中
        User user = UserUtil.getUser();
        if(StringUtils.isNotBlank(user.getId())) {
            this.updateBy = user;
            this.createBy = user;
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate() {
        //获得当前登录的对象
        User user = UserUtil.getUser();
        if(StringUtils.isNotBlank(user.getId())) {
            this.updateBy = user;
        }
        this.updateDate = new Date();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getId());
    }

    public void setNewRecord(boolean newRecord) {
        isNewRecord = newRecord;
    }
}
