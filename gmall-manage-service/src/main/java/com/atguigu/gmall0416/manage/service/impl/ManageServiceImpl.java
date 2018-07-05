package com.atguigu.gmall0416.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gamll0416.service.ManageService;
import com.atguigu.gmall0416.bean.BaseAttrInfo;
import com.atguigu.gmall0416.bean.BaseCatalog1;
import com.atguigu.gmall0416.bean.BaseCatalog2;
import com.atguigu.gmall0416.bean.BaseCatalog3;
import com.atguigu.gmall0416.manage.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService{
    @Autowired
    BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    BaseCatalog3Mapper baseCatalog3Mapper;
    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;

    @Override
    public List<BaseCatalog1> getCatalog1() {
        List<BaseCatalog1> baseCatalog1List = baseCatalog1Mapper.selectAll();
        return baseCatalog1List;
    }

    @Override
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        BaseCatalog2 baseCatalog2Query = new BaseCatalog2();
        baseCatalog2Query.setCatalog1Id(catalog1Id);
        List<BaseCatalog2> baseCatalog2List = baseCatalog2Mapper.select(baseCatalog2Query);
        return baseCatalog2List;
    }

    @Override
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        BaseCatalog3 baseCatalog3Query = new BaseCatalog3();
        baseCatalog3Query.setCatalog2Id(catalog2Id);
        List<BaseCatalog3> baseCatalog3List = baseCatalog3Mapper.select(baseCatalog3Query);
        return baseCatalog3List;
    }
    @Override
    public List<BaseAttrInfo> getAttrInfoList(String catalog3Id){
        BaseAttrInfo baseAttrInfoQuery = new BaseAttrInfo();
        baseAttrInfoQuery.setCatalog3Id(catalog3Id);
        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoMapper.select(baseAttrInfoQuery);
        return baseAttrInfoList;
    }
}
