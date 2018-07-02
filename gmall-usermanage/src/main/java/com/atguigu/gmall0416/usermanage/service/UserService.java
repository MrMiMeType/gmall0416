package com.atguigu.gmall0416.usermanage.service;

import com.atguigu.gmall0416.usermanage.bean.UserInfo;

import java.util.List;

public interface UserService {
    public List<UserInfo> getAllUserInfoList();

    public List<UserInfo> getUserInfoList(UserInfo userInfoQuery);

    public UserInfo getUserInfo(UserInfo userInfoQuery);

    public void delete(UserInfo userInfoQuery);

    public void addUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);
}
