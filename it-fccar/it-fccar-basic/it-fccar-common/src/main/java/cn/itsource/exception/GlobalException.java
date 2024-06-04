package cn.itsource.exception;

import cn.itsource.result.JSONResult;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

//全局异常

public class GlobalException extends RuntimeException{
    public GlobalException(String message){
        super(message);
    }
}
