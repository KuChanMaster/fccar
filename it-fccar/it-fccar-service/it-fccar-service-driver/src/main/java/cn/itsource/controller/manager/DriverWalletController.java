package cn.itsource.controller.manager;

import cn.itsource.service.IDriverWalletService;
import cn.itsource.pojo.domain.DriverWallet;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.itsource.pojo.query.PageQueryWrapper;
import cn.itsource.result.JSONResult;
import cn.itsource.result.PageResult;

@Tag(name = "司机的钱包",description = "司机的钱包")
@RestController
@RequestMapping("/manager/driverWallet")
public class DriverWalletController{

    @Autowired
    public IDriverWalletService driverWalletService;

    @Operation( summary= "保存DriverWallet",description = "基础对象保存接口")
    @Parameter(name = "driverWallet",description = "保存的对象",required = true)
    @PostMapping
    public JSONResult save(@RequestBody @Valid DriverWallet driverWallet){
        return JSONResult.success(driverWalletService.save(driverWallet));
    }

    @Operation( summary= "修改DriverWallet",description = "基础对象修改接口")
    @Parameter(name = "driverWallet",description = "修改的对象",required = true)
    @PutMapping
    public JSONResult update(@RequestBody  @Valid DriverWallet driverWallet){
        return JSONResult.success(driverWalletService.updateById(driverWallet));
    }

    //删除对象
    @Operation( summary= "删除DriverWallet",description = "基础对象删除接口，采用状态删除")
    @Parameter(name = "id",description = "删除的对象ID",required = true)
    @DeleteMapping(value="/{id}")
    public JSONResult delete(@PathVariable("id") Long id){
        return JSONResult.success(driverWalletService.removeById(id));
    }

    //获取对象
    @Operation( summary= "获取DriverWallet",description = "基础对象获取接口")
    @Parameter(name = "id",description = "查询的对象ID",required = true)
    @GetMapping(value = "/{id}")
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(driverWalletService.getById(id));
    }

    //获取列表:PageQueryWrapper作为通用的查询对象
    @Operation( summary= "查询DriverWallet列表",description = "基础对象列表查询，不带分页")
    @Parameter(name = "query",description = "查询条件",required = true)
    @PostMapping(value = "/list")
    public JSONResult list(@RequestBody PageQueryWrapper<DriverWallet> query){
        QueryWrapper<DriverWallet> wrapper = new QueryWrapper<>();
        //实体类作为查询条件
        wrapper.setEntity(query.getQuery());
        return JSONResult.success(driverWalletService.list(wrapper));
    }

    //分页查询
    @Operation( summary= "查询DriverWallet分页列表",description = "基础对象列表查询，带分页")
    @Parameter(name = "query",description = "查询条件，需要指定分页条件",required = true)
    @PostMapping(value = "/pagelist")
    public JSONResult page(@RequestBody PageQueryWrapper<DriverWallet> query){
        //分页查询
        Page<DriverWallet> page = new Page<DriverWallet>(query.getPage(),query.getRows());
        QueryWrapper<DriverWallet> wrapper = new QueryWrapper<>();
        //实体类作为查询条件
        wrapper.setEntity(query.getQuery());
        //分页查询
        page = driverWalletService.page(page,wrapper);
        //返回结果
        return JSONResult.success(new PageResult<DriverWallet>(page.getTotal(),page.getRecords()));
    }

}
