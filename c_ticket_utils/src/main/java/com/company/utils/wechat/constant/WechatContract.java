package com.company.utils.wechat.constant;

import com.company.utils.FileUtils.YmlUtil;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@Data
@ToString
/*
*  微信 常量
*  读取yml配置文件 实体类
* */
public class WechatContract {

    private String appId;

    private String secret;

    public WechatContract() {
        Map<String, Object> ymlConfigMap = YmlUtil.getYmlAttribute("wechatInter.yml");
        Map wechatConfig = (Map) ymlConfigMap.get("wxCount");
        this.appId = (String) wechatConfig.get("appId");
        this.secret = (String) wechatConfig.get("secret");
    }
}
