package cn.itsource.exception;

import cn.itsource.result.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//全局异常捕获
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 捕捉Exception异常，返回统一的错误提示
    @ExceptionHandler(value = Exception.class)
    public JSONResult exceptionErrorMethod(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("发生异常错误，请求地址：{}，异常信息{}", request.getRequestURI(), e.getMessage());
        return JSONResult.error("服务器内部异常，请联系管理员");
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public JSONResult exceptionErrorMethod(ArithmeticException e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("发生异常错误，请求地址：{}，异常信息{}", request.getRequestURI(), e.getMessage());
        return JSONResult.error("算术异常除数为0了");
    }

    // 捕捉GlobalException异常，把错误日志抛给用户
    @ExceptionHandler(value = GlobalException.class)
    public JSONResult globalCustomMethod(GlobalException e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("发生异常错误，请求地址：{}，异常信息：{}", request.getRequestURI(), e.getMessage());
        return JSONResult.error(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public JSONResult globalCustomMethod(MethodArgumentNotValidException e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("发生异常错误，请求地址：{}，异常信息：{}", request.getRequestURI(), e.getMessage());
        //return JSONResult.error(e.getMessage().substring(e.getMessage().lastIndexOf("[")+1, e.getMessage().lastIndexOf("]")-1));

        //拿到所有异常信息,拿到里面的中文,存到容器al里面去
        String inputText = e.getMessage();
        String chineseRegex = "[\\u4e00-\\u9fa5]+"; // 匹配Unicode中的中文范围

        Pattern pattern = Pattern.compile(chineseRegex);
        Matcher matcher = pattern.matcher(inputText);

        String chineseText = null;//容器a
        ArrayList<String> al = new ArrayList();
        while (matcher.find()) {
            chineseText = matcher.group();
            System.out.println(chineseText);
            al.add(chineseText);
        }

        return JSONResult.error(al.toString());//把al里面的东西变成字符串[]给前端
    }
}

