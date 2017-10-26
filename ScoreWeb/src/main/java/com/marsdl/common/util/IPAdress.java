package com.marsdl.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Description
 * @Author chenrui
 * @since 2017/10/25
 */
public class IPAdress {

    private static String url = "";
    //开发者密钥
    private static String ak = "";
    //IP
    //private static String ip = "";

    //用户的权限签名
    /*private static String sn = "";*/
    //输出的坐标格式 coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标；coor=gcj02时，返回为国测局坐标
    //private static String coor = "bd09ll";
    /**
     * 根据IP获得坐标地址的字符串
     * @param ip
     * @param coor
     * @return string
     */
    public static String getIPAddress(String ip, String coor) {
        // 创建url资源
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        try {
            URL localURL = new URL(url+"?ak="+ak+"&ip="+ip+"&coor="+coor);
            URLConnection connection = localURL.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type","application/text");

            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception(
                        "HTTP Request is not success, Response code is "
                                + httpURLConnection.getResponseCode());
            }

            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            //resultBuffer是百度接口返回的数据
            return resultBuffer.toString();
            /*
            Unicode转化成汉字
            int source = Integer.parseInt("80a5", 16);
            System.out.println(Integer.parseInt("80a5", 16));
            char chenrui = (char)source;
            System.out.println(chenrui);
             */
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(EncodeAndDecode.unicodeToString("\\u5b89\\u5fbd\\u7701\\u5408\\u80a5\\u5e02"));
        System.out.println(EncodeAndDecode.stringToUnicode("安徽省合肥市"));
    }
}
