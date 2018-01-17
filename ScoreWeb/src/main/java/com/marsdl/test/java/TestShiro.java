package com.marsdl.test.java;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * <p>titile  </p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/16
 */
public class TestShiro {

    @Test
    public void testLogin() {

        //构建SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //通过工厂创建SecurityManager
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");

        try {
            //用户登录
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("不存在此用户");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码出现错误");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

}
