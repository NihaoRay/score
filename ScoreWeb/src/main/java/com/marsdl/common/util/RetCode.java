package com.marsdl.common.util;

/**
 * <p>@description 返回json串时候 </p>
 * @author chenrui
 * @since 2017/10/16
 */
public class RetCode {

    public static final String SUCCESS = "成功";
    public static final Integer SUCCESS_CODE = 0;

    public static final String ERROR = "出现错误";
    public static final Integer ERROR_CODE = 500;

    public static final String ERRORCODE = "验证码错误";
    public static final Integer ERRORCODE_CODE = 600;

    public static final String NO_USER = "不存在此用户";
    public static final Integer NO_USER_CODE = 404;

    public static final String ERROR_PASSWORD = "用户名或者密码出现错误";
    public static final Integer ERROR_PASSWORD_CODE = 700;

    public static  final String LOGIN_SUCCESS = "登录成功";
    public static  final Integer LOGIN_SUCCESS_CODE = 202;
}
