package cn.itsource.result;

import cn.itsource.constants.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//返回JSON结果
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JSONResult<T> {

    //结果状态
    private boolean success = true;
    //响应码
    private int code = ErrorCode.OK.getCode();
    //默认消息
    private String message = ErrorCode.OK.getMessage();
    //返回的数据
    private T data;

    /**
     * 创建无参数的成功的JSON结果对象
     * @return JSONResult:JSON结果对象
     */
    public static JSONResult success(){
        return new JSONResult();
    }

    /**
     * 创建成功的JSON结果对象
     * @return JSONResult:JSON结果对象
     * @param data: 数据
     */
    public static JSONResult success(Object data){
        JSONResult<Object> jsonResult = new JSONResult<>();
        jsonResult.setData(data);
        return jsonResult;
    }

    /**
     * 创建成功的JSON结果对象
     * @return JSONResult:JSON结果对象
     * @param code: 响应码
     * @param data: 数据
     */
    public static JSONResult success(int code,Object data){
        JSONResult jsonResult = success(data);
        jsonResult.setCode(code);
        return jsonResult;
    }
    /**
     * 创建失败的JSON结果对象
     * @return JSONResult:JSON结果对象
     * @param code: 响应码
     * @param message: 错误信息
     */
    public static JSONResult error(int code,String message){
        return new JSONResult(false,code, message,null);
    }
    /**
     * 创建失败的JSON结果对象
     * @return JSONResult:JSON结果对象
     */
    public static JSONResult error(){
        return error(ErrorCode.SERVICE_ERROR.getCode(), ErrorCode.SERVICE_ERROR.getMessage());
    }
    /**
     * 创建失败的JSON结果对象
     * @return JSONResult:JSON结果对象
     */
    public static JSONResult error(String message){
        return error(ErrorCode.SERVICE_ERROR.getCode(),message);
    }

    //直接传递一个错误码
    public static JSONResult error(ErrorCode errorCode){
        return error(errorCode.getCode(),errorCode.getMessage());
    }

    public JSONResult<T> data(T data){
        this.data = data;
        return this;
    }
}
