package cn.itsource.controller.app;

import cn.itsource.exception.GlobalException;
import cn.itsource.pojo.domain.Driver;
import cn.itsource.pojo.query.PageQueryWrapper;
import cn.itsource.result.JSONResult;
import cn.itsource.result.PageResult;
import cn.itsource.service.IDriverService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "司机对象",description = "司机对象")
@RestController
@RequestMapping("/app/driver")
public class AppDriverController {
    @Autowired
    public IDriverService driverService;

    //注册
    @Operation( summary= "注册",description = "注册功能接口")
    @Parameter(name = "code",description = "授权码",required = true)
    @GetMapping("/register")
    public JSONResult register(String code){
        return JSONResult.success(driverService.register(code));//按alt enter
    }
}
