package com.marsdl.modules.sys.entity;

import com.marsdl.common.persistence.DataEntity;

/**
 * @Description user实体bean
 * @Author chenrui
 * @since 2017/10/21
 */
public class User extends DataEntity<User> {

    private String area;        //地址
    private String loginName;// 登录名
    private String password;// 密码
    private String no;		// 工号
    private String username;	// 姓名
    private String email;	// 邮箱
    private String phone;	// 电话
    private String mobile;	// 手机
    private String userType;// 用户类型
    private String photo;	// 头像
    private String loginFlag;	// 是否允许登陆

    public User() {
        super();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }
}
