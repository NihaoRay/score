package com.marsdl.modules.sys.security;

import com.marsdl.modules.sys.dao.UserDao;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.util.UserUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 *  <p>description 此类应该spring-context-shiro.xml已经注入到spring中管理</p>
 * @author chenrui
 * @since 2018/1/16
 */
public class SystemAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    //支持UsernamePasswordToken
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        //从token中 获取用户身份信息
        String username = (String) token.getPrincipal();
        //拿username从数据库中查询
        //....
        //如果查询不到则返回null
        User userParam = new User();
        userParam.setUsername(username);
        /*
        //验证用户名
        if(!username.equals("admin")){
            return null;
        }*/
        User user = userDao.queryObjectByLoginName(username);
        if(user != null) {
            return new SimpleAuthenticationInfo(new Principal(user), user.getPassword(), getName());
        } else {
            throw new UnknownAccountException("账号或者密码不正确");
            /*return null;*/
        }
        //获取从数据库查询出来的用户密码
       /* String password = "123";//这里使用静态数据模拟。。*/

        //返回认证信息由父类AuthenticatingRealm进行认证
      /*  SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                username, password, getName());*/

       /* return info;*/
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        // TODO Auto-generated method stub
        System.out.println("nihao");
        return null;
    }

    /**
     * 授权用户信息
     */
    public static class Principal implements Serializable {
        private static final long serialVersionUID = 1L;

        private String id;  //编号
        private String loginName;//登录名
        private String username;    //姓名
        private String email;

        public Principal(User user) {
            this.id = user.getId();
            this.loginName = user.getLoginName();
            this.username = user.getUsername();
            this.email = user.getEmail();
        }

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * 获取SESSIONID
         */
        public String getSessionid() {
            try{
                return (String) UserUtil.getSession().getId();
            }catch (Exception e) {
                return "";
            }
        }

        @Override
        public String toString() {
            return id;
        }
    }
}
