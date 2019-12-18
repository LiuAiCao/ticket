package com.company.reception.controller;

import com.company.common.framework.model.response.*;
import com.company.common.framework.model.response.code.BaseResultCode;
import com.company.reception.service.WxService;
import com.company.utils.wechat.constant.WechatContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class TestController {

    @Autowired
    private WxService wxService;

    @GetMapping("/testInter")
    public Response testInter() {
      String accesstoken =   wxService.getAccesstoken();
        MapQueryResponse response = new MapQueryResponse(BaseResultCode.SUSSESS, accesstoken);
        return response;
    }

    @GetMapping("/testUserList")
    public Response testUserList(){
      Map map =  wxService.getUserList();
        MapQueryResponse response = new MapQueryResponse(BaseResultCode.SUSSESS, map);
        return response;
    }

    @GetMapping("/testUserInfo/{openId}")
    public Response testUserInfo(@PathVariable String openId){
       Map map = wxService.getUserInfo(openId);
        MapQueryResponse response = new MapQueryResponse(BaseResultCode.SUSSESS, map);
        return response;
    }
}
