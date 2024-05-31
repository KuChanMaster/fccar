package cn.itsource.service.impl;

import cn.itsource.pojo.domain.DriverSetting;
import cn.itsource.mapper.DriverSettingMapper;
import cn.itsource.service.IDriverSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 司机配置 服务实现类
 * </p>
 *
 * @author ywj
 * @since 2024-05-31
 */
@Service
public class DriverSettingServiceImpl extends ServiceImpl<DriverSettingMapper, DriverSetting> implements IDriverSettingService {

}
