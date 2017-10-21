package com.marsdl.common.util;

import java.util.UUID;

/**
 * @Description 封装各种生成唯一性的ID算法工具
 * @Author chenrui
 * @since 2017/10/21
 */
public class IdGen {

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
