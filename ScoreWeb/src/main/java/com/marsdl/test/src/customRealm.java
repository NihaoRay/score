package com.marsdl.test.src;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * <p>titile  </p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/16
 */
public class customRealm extends AuthorizingRealm {


    @Override
    public String getName() {
        return "systemAuthorizingRealm";
    }

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
        if(!username.equals("zhang")){//这里模拟查询不到
            return null;
        }

        //获取从数据库查询出来的用户密码
        String password = "123";//这里使用静态数据模拟。。

        //返回认证信息由父类AuthenticatingRealm进行认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                username, password, getName());

        return simpleAuthenticationInfo;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        return null;
    }

}
