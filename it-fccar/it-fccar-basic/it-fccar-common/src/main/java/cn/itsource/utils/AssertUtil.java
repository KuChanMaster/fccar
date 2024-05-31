package cn.itsource.utils;


import cn.itsource.constants.Constants;
import cn.itsource.exception.GlobalException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//断言工具
public class AssertUtil {

    //手机的正则表达式
    public static void isPhone(String phone,String message){
        Pattern CHINA_PATTERN_PHONE = Pattern.compile(Constants.CHINA_PHONE_REGEX);
        Matcher m = CHINA_PATTERN_PHONE.matcher(phone);
        if(!m.matches()){
            throw new GlobalException(message);
        }
    }


    //字符串不为空
    public static void isNotEmpty(String text, String message) {
        if (text == null || text.trim().length() == 0) {
            throw new GlobalException(message);
        }
    }

    //列表不为空
    public static void isNotEmpty(List list, String message) {
        if (list == null || list.size() == 0) {
            throw new GlobalException(message);
        }
    }

    //对象为空
    public static void isNull(Object obj , String message){
        if(obj != null){
            throw new GlobalException(message);
        }
    }
    //对象不为空
    public static void isNotNull(Object obj , String message){
        if(obj == null){
            throw new GlobalException(message);
        }
    }
    //断言为false
    public static void isFalse(boolean isFalse , String message){
        if(isFalse){
            throw new GlobalException(message);
        }
    }
    //断言为false
    public static void isTrue(boolean isTrue , String message){
        if(!isTrue){
            throw new GlobalException(message);
        }
    }
    //int值比较
    public static void isEquals(int s1,int s2 , String message){
        if(s1 != s2){
            throw new GlobalException(message);
        }
    }
    //是否包含
    public static void isIn(Integer s1,List<Integer> s2 , String message){
        if(!s2.contains(s1)){
            throw new GlobalException(message);
        }
    }
    //字符串比较
    public static void isEquals(String s1,String s2 , String message){
        isNotEmpty(s1, "不可为空");
        isNotEmpty(s2, "不可为空");
        if(!s1.equals(s2)){
            throw new GlobalException(message);
        }
    }
    //字符串去空格比较
    public static void isEqualsTrim(String s1,String s2 , String message){
        isNotEmpty(s1, "不可为空");
        isNotEmpty(s2, "不可为空");
        if(!s1.trim().equals(s2.trim())){
            throw new GlobalException(message);
        }
    }
    //字符串忽略大小写比较
    public static void isEqualsIgnoreCase(String s1,String s2 , String message){
        isNotEmpty(s1, "不可为空");
        isNotEmpty(s2, "不可为空");
        if(!s1.trim().equalsIgnoreCase(s2.trim())){
            throw new GlobalException(message);
        }
    }

}
