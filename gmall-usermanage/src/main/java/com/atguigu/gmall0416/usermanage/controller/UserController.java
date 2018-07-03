package com.atguigu.gmall0416.usermanage.controller;



import com.atguigu.gamll0416.service.UserManageService;
import com.atguigu.gmall0416.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserManageService userManageService;
    @RequestMapping("/getAllUserInfos")
    public ResponseEntity<List<UserInfo>> getAllUserInfos(){
        List<UserInfo> infos = userManageService.getAllUserInfoList();
        return ResponseEntity.ok(infos);
    }
    @RequestMapping("/users")
    public ResponseEntity<List<UserInfo>> getUserList( UserInfo userInfo){
        List<UserInfo> userInfoList = userManageService.getUserInfoList(userInfo);
        return ResponseEntity.ok().body(userInfoList);
    }


    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public    ResponseEntity<Void> add(UserInfo userInfo){ ;

        userManageService.addUserInfo(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.PUT)
    public    ResponseEntity<Void> update(UserInfo userInfo){
        userManageService.updateUserInfo(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.DELETE)
    public    ResponseEntity<Void> delete(UserInfo userInfo){
        userManageService.delete(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public    ResponseEntity<UserInfo> getUserInfo(UserInfo userInfoQuery){
        UserInfo userInfo = userManageService.getUserInfo(userInfoQuery);
        return ResponseEntity.ok().body(userInfo);
    }
}
