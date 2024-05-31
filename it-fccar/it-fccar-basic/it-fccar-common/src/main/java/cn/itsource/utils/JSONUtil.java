package cn.itsource.utils;

import com.alibaba.fastjson.JSON;

//JSON转换工具
public class JSONUtil {

    //把对象转为某类型的对象
    public static <T> T object2Class(Object obj, Class<T> cls){
        return JSON.parseObject(JSON.toJSONString(obj),cls);
    }


}
