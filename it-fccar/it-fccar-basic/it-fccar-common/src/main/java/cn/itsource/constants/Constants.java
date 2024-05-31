package cn.itsource.constants;


//常量维护
public class Constants {

    //手机号正则表达式
    public static final String CHINA_PHONE_REGEX =  "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";

    //编码
    public static final String UTF_8 = "UTF-8";

    //司机服务
    public class Driver {

        public static final int TYPE_DRIVER = 0;
        public static final int TYPE_CUSTOMER = 1;
    }
    //远程调用
    public class Remote {
        //服务名
        public static final String SERVICE_UAA = "it-fccar-service-uaa";

        public static final String PREFIX_LOGIN_REMOTE = "/login/remote";
    }

}
