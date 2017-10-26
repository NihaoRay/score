package com.marsdl.common.util;

/**
 * @Description 编码的转化
 * @Author chenrui
 * @since 2017/10/26
 */
public class EncodeAndDecode {

    /**
     * unicode转化为汉字
     * @param unicode
     * \u5408\u80a5
     * \u5b89\u5fbd
     * \u5b89\u5fbd\u7701\u5408\u80a5\u5e02
     * \u5b89\u5fbd\u7701
     */
    public static String unicodeToString(String unicode) {
        StringBuffer sb = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            sb.append((char) data);
        }
        return sb.toString();
    }

    /**
     * 汉字转化为unicode
     * @param string
     * @return
     */
    public static String stringToUnicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    public static void main(String[] args) {
        System.out.println(unicodeToString("\\u5b89"));
    }

}
