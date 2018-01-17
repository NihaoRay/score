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
 * <p>titile 用户工具类</p>
 * <p>description  </p>
 * @author chenrui
 * @since 2018/1/12
 */
public class UserUtil {

    private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);

    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_USERNAME_ = "ln";
    public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

    public static final String CACHE_AUTH_INFO = "authInfo";
    public static final String CACHE_ROLE_LIST = "roleList";

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    public static User get(String id) {
        //从缓存中获得数据
        User user = (User) CacheUtil.get(USER_CACHE, USER_CACHE_ID_ + id);
        if(user == null) {
           //从库中获得数据
           user = userDao.queryObject(id);
           if(user == null) {
               return null;
           }
           //给用户添加权限

           //将用户信息存入缓存
           CacheUtil.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
           CacheUtil.put(USER_CACHE, USER_CACHE_USERNAME_ + user.getLoginName(), user);
        }
        return user;
    }

    /**
     * 根据用户名名获取用户
     * 先从缓存取得，如果缓存为空，再从数据库取
     * @param username
     * @return
     */
    public static User getByUsername(String username) {
        User user = (User) CacheUtil.get(USER_CACHE, USER_CACHE_USERNAME_ + username);
        if(user == null) {
            user = userDao.queryObjectByUsername(username);
            if(user == null) {
                return null;
            }
            //数据库中取得数据放入缓存中
            CacheUtil.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
            CacheUtil.put(USER_CACHE, USER_CACHE_USERNAME_ + user.getLoginName(), user);
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
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前登录者对象
     * @return
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

    /**
     *清除指定用户缓存
     *@param user
     */
    public static void clearCache(User user) {
        CacheUtil.remove(USER_CACHE, USER_CACHE_ID_+user.getId());
        CacheUtil.remove(USER_CACHE, USER_CACHE_USERNAME_+user.getLoginName());
    }

    /**
     * 清除当前用户缓存
     */
    public static void clearCache() {
        removeCache(CACHE_AUTH_INFO);
    }
}
