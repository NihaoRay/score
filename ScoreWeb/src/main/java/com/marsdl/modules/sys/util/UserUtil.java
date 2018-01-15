package com.marsdl.modules.sys.util;

import com.marsdl.common.util.CacheUtil;
import com.marsdl.common.util.SpringContextHolder;
import com.marsdl.modules.sys.dao.UserDao;

import com.marsdl.modules.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.marsdl.modules.sys.security.SystemAuthorizingRealm.Principal;
/**
 * @Description
 * @Author chenrui
 * @since 2018/1/12
 */
public class UserUtil {

    private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);

    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_LOGIN_NAME_ = "ln";
    public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

    public static final String CACHE_AUTH_INFO = "authInfo";
    public static final String CACHE_ROLE_LIST = "roleList";

    /**
     * 根据id获取用户
     */
    public static User get(String id) {
       User user = (User) CacheUtil.get(USER_CACHE, USER_CACHE_ID_ + id);
       if(user == null) {
           user = userDao.queryObject(id);
           if(user == null) {
               return null;
           }
           //给用户添加权限

           //将用户信息存入缓存
           CacheUtil.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
           CacheUtil.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
       }
       return user;
    }


    /**
     * 根据登录名获取用户
     * 先从缓存取得，如果缓存为空，再从数据库取
     * @param loginName
     * @return
     */
    public static User getByUsername(String loginName) {
        User param = new User();
        param.setUsername(loginName);

        User user = (User) CacheUtil.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
        if(user == null) {
            user = userDao.findByEntityParams(param).get(0);
            if(user == null) {
                return null;
            }
            //数据库中取得数据放入缓存中
            CacheUtil.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
            CacheUtil.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
        }
        return user;
    }

    /**
     * 获取当前用户
     * @return
     */
    public static User getUser() {
        Principal principal = getPrincipal();
        if(principal != null) {
            User user = get(principal.getId());
            if(user != null) {
                return user;
            }
            return new User();
        }
        return new User();
    }

    /**
     * 获得主要对象
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前登录者对象
     */
    public static Principal getPrincipal() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Principal principal = (Principal) subject.getPrincipal();
            if(principal != null) {
                return principal;
            }
        } catch (UnavailableSecurityManagerException e) {

        } catch (InvalidSessionException e) {

        }
        return null;
    }

    /**
     * 获得shiro管理的session
     * servlet容器中的session交给了shiro进行管理
     * @return
     */
    public static Session getSession() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession(false);
            if(session == null) {
                session = subject.getSession();
            }
            if(session != null) {
                return session;
            }
        } catch (InvalidSessionException e) {

        }
        return null;
    }

    // -------User Cache------
    /**
     *  User Cache使用是基于shiro中的session缓存
     *  存入缓存时候，session执行setAttribute
     *  清除缓存时候，session执行removeAttribute
     */
    public static Object getCache(String key) {
        return getCache(key, null);
    }

    public static Object getCache(String key, Object defaultValue) {
        Object obj = getSession().getAttribute(key);
        return obj == null ? defaultValue : obj;
    }

    public static void putCache(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static void removeCache(String key) {
        getSession().removeAttribute(key);
    }
}
