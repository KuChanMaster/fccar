package cn.itsource.constants;

//错误码封装
public enum ErrorCode {

    OK(200, "成功"),
    NO_PERMISSION(403, "没有访问权限"),
    PARAM_ERROR(400, "参数校验异常"),
    SERVICE_ERROR(500, "系统异常，我们正在殴打程序员"),
    SERVICE_REQUEST_ERROR(501, "远程服务调用异常"),
    PARAM_PHONE_ERROR(1000, "手机号错误"),
    PARAM_CODE_ERROR(1002, "授权码无效"),
    PARAM_PHONE_EXIST(1001, "账号已经存在")
    ;
    //错误码
    private int code;
    //错误信息
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
