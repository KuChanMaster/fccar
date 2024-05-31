package cn.itsource.service.impl;

import cn.itsource.pojo.domain.Driver;
import cn.itsource.mapper.DriverMapper;
import cn.itsource.service.IDriverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 司机对象 服务实现类
 * </p>
 *
 * @author ywj
 * @since 2024-05-31
 */
@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements IDriverService {

}
