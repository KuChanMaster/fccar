package cn.itsource.service.impl;

import cn.itsource.pojo.domain.Driver;
import cn.itsource.mapper.DriverMapper;
import cn.itsource.service.IDriverService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * <p>
 * 司机对象 服务实现类
 * </p>
 *
 * @author ywj
 * @since 2024-05-31
 */
@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements IDriverService {//alt enter,implements实现
    @Override
    public Object register(String code) {
        System.out.println("拿到的授权码是:"+code);//sout//拿到的授权码是:0d30Aa0004ZheS1jDw300KEOyr30Aa0y

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx503624408a9ac099&secret=c78817f3f01704df0abdcc28b457a45d&js_code="+code+"&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();

        String json = restTemplate.getForObject(url, String.class);//.var
        System.out.println(json);//{"session_key":"pyr+zke4UZr9vfx3wWGvEA==","openid":"ogx2667c9DJ9WSNRNKBIYhouW35A"}

        Map map = JSON.parseObject(json, Map.class);//map,.var
        String openid = (String) map.get("openid");//.var

        System.out.println(openid);//openid.sout//ogx2667c9DJ9WSNRNKBIYhouW35A
        return null;
    }
}
