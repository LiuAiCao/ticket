package com.company.reception.service.impl;


import com.company.common.framework.exception.ExceptionCast;
import com.company.common.framework.model.response.code.WxResultCode;
import com.company.reception.annotation.Cache;
import com.company.reception.service.WxService;
import com.company.utils.wechat.constant.WechatContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service("WxService")
public class WxServiceImpl implements WxService{


    @Autowired
    private RestTemplate restTemplate;


    @Override
    @Cache(key = "wechatCount",type = String.class,expire = 2*60*60L)
    public String getAccesstoken() {
        WechatContract wechatContract = new WechatContract();
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(
                "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                        +wechatContract.getAppId()+"&secret="
                        +wechatContract.getSecret(),Map.class);
        Map forEntityBody = forEntity.getBody();
        Map<String,Object> map = new HashMap<>();
        map.putAll(forEntityBody);
        if(map.get("errmsg") !=null){
            ExceptionCast.cast(WxResultCode.ERROR_IP);
        }
        return (String) map.get("access_token");
    }

    @Override
    public Map getUserList() {
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + this.getAccesstoken(), Map.class);
        Map forEntityBody = forEntity.getBody();
        if((int)forEntityBody.get("errcode") == 48001){
            ExceptionCast.cast(WxResultCode.ERROR_AUTHENTICATION);
        }
        return forEntityBody;
    }

    @Override
    public Map getUserInfo(String openID) {
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + this.getAccesstoken() + "&openid=" + openID + "&lang=zh_CN", Map.class);
        Map body = forEntity.getBody();
        if((int)body.get("errcode") == 48001){
            ExceptionCast.cast(WxResultCode.ERROR_AUTHENTICATION);
        }
        return body;
    }
}
