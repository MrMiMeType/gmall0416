package com.atguigu.gmall0416.order.controller.order;

import com.atguigu.gamll0416.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    UserManageService userManageService;//老师的视频中是UserService
    @RequestMapping("/trade")
    public String trade(){
        return null;
    }
}
