package com.marsdl.common.security.shiro.session;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @Description
 * @Author chenrui
 * @since 2018/1/11
 */
public class SessionManager extends DefaultWebSessionManager {

    public SessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {

        String sid = request.getParameter("_sid");
        return sid;
    }




}
