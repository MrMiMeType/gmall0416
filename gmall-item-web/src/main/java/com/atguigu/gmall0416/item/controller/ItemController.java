package com.atguigu.gmall0416.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gamll0416.service.ManageService;
import com.atguigu.gmall0416.bean.SkuInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
    @Reference
    ManageService manageService;
    @RequestMapping("/{skuId}.html")
    public String getSkuInfo(@PathVariable("skuId") String skuId, Model model){
        SkuInfo skuInfo = manageService.getSkuInfo(skuId);
        model.addAttribute("skuInfo",skuInfo);
        return "item";
    }
}
