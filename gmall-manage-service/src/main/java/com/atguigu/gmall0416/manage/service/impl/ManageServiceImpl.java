package com.atguigu.gmall0416.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gamll0416.service.ManageService;
import com.atguigu.gmall0416.bean.*;
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
    @Autowired
    SpuInfoMapper spuInfoMapper;
    @Autowired
    SkuInfoMapper skuInfoMapper;
    @Autowired
    SkuImageMapper skuImageMapper;
    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;

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

    @Override
    public void saveBaseAttrInfo(BaseAttrInfo baseAttrInfo) {
        //保存属性主表
        if (baseAttrInfo.getId()!=null&&baseAttrInfo.getId().length()==0){//排除长度为零的字符串
            baseAttrInfo.setId(null);
        }
        baseAttrInfoMapper.insertSelective(baseAttrInfo);
        //保存属性值
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue baseAttrValue : attrValueList) {
            if (baseAttrValue.getId()!=null&&baseAttrValue.getId().length()==0){
                baseAttrValue.setId(null);
            }
            baseAttrValue.setAttrId(baseAttrInfo.getId());
            baseAttrValueMapper.insertSelective(baseAttrValue);
        }

    }

    @Override
    public List<SpuInfo> getSpuInfoList(String catalog3Id) {
        SpuInfo spuInfoQuery = new SpuInfo();
        spuInfoQuery.setCatalog3Id(catalog3Id);
        List<SpuInfo> spuInfoList = spuInfoMapper.select(spuInfoQuery);
        return spuInfoList;
    }

    public SkuInfo getSkuInfo(String skuId){

        SkuInfo skuInfo = skuInfoMapper.selectByPrimaryKey(skuId);
        if(skuInfo==null){
            return null;
        }
        SkuImage skuImage=new SkuImage();
        skuImage.setSkuId(skuId);
        List<SkuImage> skuImageList = skuImageMapper.select(skuImage);
        skuInfo.setSkuImageList(skuImageList);

        SkuSaleAttrValue skuSaleAttrValue=new SkuSaleAttrValue();
        skuSaleAttrValue.setSkuId(skuId);
        List<SkuSaleAttrValue> skuSaleAttrValueList = skuSaleAttrValueMapper.select(skuSaleAttrValue);
        skuInfo.setSkuSaleAttrValueList(skuSaleAttrValueList);

        return  skuInfo;
    }
}
