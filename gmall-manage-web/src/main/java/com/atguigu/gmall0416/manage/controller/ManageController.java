package com.atguigu.gmall0416.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gamll0416.service.ManageService;
import com.atguigu.gmall0416.bean.BaseAttrInfo;
import com.atguigu.gmall0416.bean.BaseCatalog1;

import com.atguigu.gmall0416.bean.BaseCatalog2;
import com.atguigu.gmall0416.bean.BaseCatalog3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ManageController {
    @Reference
    ManageService manageService;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/attrListPage")
    public String attrListPage(){
        return "attrListPage";
    }
    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        List<BaseCatalog1> baseCatalog1List=manageService.getCatalog1();
        return baseCatalog1List;
    }
    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(HttpServletRequest request){
        String catalog1Id = request.getParameter("catalog1Id");
        List<BaseCatalog2> baseCatalog2List=manageService.getCatalog2(catalog1Id);
        return baseCatalog2List;
    }
    @RequestMapping("/getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(HttpServletRequest request){
        String catalog2Id = request.getParameter("catalog2Id");
        List<BaseCatalog3> baseCatalog3List=manageService.getCatalog3(catalog2Id);
        return baseCatalog3List;
    }
    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<BaseAttrInfo> getAttrInfoList(HttpServletRequest request){
        String catalog3Id = request.getParameter("catalog3Id");
        List<BaseAttrInfo> attrInfoList = manageService.getAttrInfoList(catalog3Id);
        return attrInfoList;
    }
    @RequestMapping("/saveAttrInfo")
    public String saveAttrInfo(){
        //1.获取三级分类的id

        //2.添加平台属性值，并返回主键值

        //3.根据主键值，插入value值
        return null;
    }
}
