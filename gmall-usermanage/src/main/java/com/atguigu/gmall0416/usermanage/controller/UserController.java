package com.atguigu.gmall0416.usermanage.controller;

import com.atguigu.gmall0416.usermanage.bean.UserInfo;
import com.atguigu.gmall0416.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/getAllUserInfos")
    public ResponseEntity<List<UserInfo>> getAllUserInfos(){
        List<UserInfo> infos = userService.getAllUserInfoList();
        return ResponseEntity.ok(infos);
    }
    @RequestMapping("/users")
    public ResponseEntity<List<UserInfo>> getUserList( UserInfo userInfo){
        List<UserInfo> userInfoList = userService.getUserInfoList(userInfo);
        return ResponseEntity.ok().body(userInfoList);
    }


    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public    ResponseEntity<Void> add(UserInfo userInfo){ ;

        userService.addUserInfo(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.PUT)
    public    ResponseEntity<Void> update(UserInfo userInfo){
        userService.updateUserInfo(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.DELETE)
    public    ResponseEntity<Void> delete(UserInfo userInfo){
        userService.delete(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public    ResponseEntity<UserInfo> getUserInfo(UserInfo userInfoQuery){
        UserInfo userInfo = userService.getUserInfo(userInfoQuery);
        return ResponseEntity.ok().body(userInfo);
    }
}
