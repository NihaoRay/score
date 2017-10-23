package com.marsdl.common.util;

/**
 * @Description 返回json串时候
 * @Author chenrui
 * @since 2017/10/16
 */
public class RetCode {

    public static String SUCCESS = "{\"code\":\"200\", \"data\":\"执行成功\"}";

    public static String ERROR = "{\"code\":\"500\", \"data\":\"出现错误\"}";

    public static String NOTHING = "{\"code\":\"400\", \"data\":\"没有\"}";

    public static String UNKONW = "{\"code\":\"404\", \"data\":\"出现未知数据\"}";

}
