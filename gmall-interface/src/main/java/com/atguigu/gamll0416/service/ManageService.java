package com.atguigu.gamll0416.service;

import com.atguigu.gmall0416.bean.*;

import java.util.List;

public interface ManageService {
    public List<BaseCatalog1> getCatalog1();
    public List<BaseCatalog2> getCatalog2(String catalog1Id);
    public List<BaseCatalog3> getCatalog3(String catalog2Id);
    public List<BaseAttrInfo> getAttrInfoList(String catalog3Id);
    public void saveBaseAttrInfo(BaseAttrInfo baseAttrInfo);
    public List<SpuInfo> getSpuInfoList(String catalog3Id);
}
