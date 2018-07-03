package com.atguigu.gmall0416.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gamll0416.service.UserManageService;
import com.atguigu.gmall0416.bean.UserAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {
    @Reference
    UserManageService userManageService;
    @RequestMapping("/trade")
    @ResponseBody
    public String trade(HttpServletRequest request){
        String userId = request.getParameter("userId");
        List<UserAddress> userAddressList = userManageService.getUserAddressList(userId);
        String UserAddressString = JSON.toJSONString(userAddressList);
        return UserAddressString;
    }
}
