package com.atguigu.gamll0416.service;



import com.atguigu.gmall0416.bean.UserAddress;
import com.atguigu.gmall0416.bean.UserInfo;

import java.util.List;

public interface UserManageService {
    public List<UserInfo> getAllUserInfoList();

    public List<UserInfo> getUserInfoList(UserInfo userInfoQuery);

    public UserInfo getUserInfo(UserInfo userInfoQuery);

    public void delete(UserInfo userInfoQuery);

    public void addUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);

    //第二天

    public List<UserAddress> getUserAddressList(String userId);
}
