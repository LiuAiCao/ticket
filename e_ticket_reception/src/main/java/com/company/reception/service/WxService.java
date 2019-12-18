package com.company.reception.service;


import java.util.Map;

public interface WxService {
    //获取accesstoken
    String getAccesstoken();

    //获取关注所有关注用户列表
    public Map getUserList();

    //获取用户信息
    public Map getUserInfo(String openID);
}
