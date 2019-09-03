package com.talkingdata.tds.utils;

import java.io.File;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 2017/11/27.
 */
public class StringUtil {

    //判断字符串中是否包含汉字
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]+");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    //获得32位uuid
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    //截取倒数第num个斜杠后的字符串
    public static String getSubStr(String str, int num) {
        String result = "";
        int i = 0;
        while(i < num) {
            int lastFirst = str.lastIndexOf(File.separator);
            result = str.substring(lastFirst) + result;
            str = str.substring(0, lastFirst);
            i++;
        }
        return result.substring(1);
    }

    //截取倒数第num个斜杠前的字符串
    public static String getHeadSubStr(String str, int num) {
        int i = 0;
        while(i < num) {
            int lastFirst = str.lastIndexOf(File.separator);
            str = str.substring(0,lastFirst);
            i++;
        }
        return str;
    }

    //过滤字符串中的反斜杠和双引号
    public static String filterSpecialChar(String str){
        if (str!=null && !"".equals(str)){
            str = str.replaceAll("[\"\\\\]","");
        }
        return str;
    }

    //判断字符串是否以.开头
    public static boolean startWithPoint(String str){
        return str.substring(0, 1).equals(".") ? true : false;
    }




}
