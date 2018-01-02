package com.marsdl.modules.sys.interceptor;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.persistence.SessionKey;
import com.marsdl.modules.sys.entity.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 登录拦截器
 * @Author chenrui
 * @since 2017/12/31
 */
public class IsLoginInterceptor implements HandlerInterceptor {


    /**
     * 登录拦截器，如果没有登录的情况返回首页或者登录页面，
     * 如果没有登录，也不允许只有登录情况下使用的方法
     * @param request
     * @param response
     * @param object
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String url = request.getRequestURI();
        if(object instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) object;
            //判断用户是否登录
            if(request.getSession(true).getAttribute(SessionKey.SYS_USER) == null) {
               /* //没有登录的情况下，
                request.getRequestDispatcher("/404.html").forward(request, response);
                return false;*/
               return true;
            }
            else {
               /* Boolean bool = true;
                User sysUser = (User) request.getSession(bool).getAttribute(SessionKey.SYS_USER);
                String loginName = sysUser.getLoginName();
                String requestType = request.getHeader("X-Requested-With");*/
                return true;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
