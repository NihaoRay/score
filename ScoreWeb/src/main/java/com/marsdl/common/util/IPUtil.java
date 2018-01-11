package com.marsdl.common.util;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * IP工具类
 * @author chenrui
 * @since 2017-10-15
 */
public class IPUtil {

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理
            int index = ip.indexOf(",");
            if(index != -1)
                return ip.substring(0, index);
            else
                return ip;
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip))
            return ip;
        return request.getRemoteAddr();
    }
}
