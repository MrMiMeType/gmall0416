package com.atguigu.gamll0416.service;

import com.atguigu.gmall0416.bean.BaseAttrInfo;
import com.atguigu.gmall0416.bean.BaseCatalog1;
import com.atguigu.gmall0416.bean.BaseCatalog2;
import com.atguigu.gmall0416.bean.BaseCatalog3;

import java.util.List;

public interface ManageService {
    public List<BaseCatalog1> getCatalog1();
    public List<BaseCatalog2> getCatalog2(String catalog1Id);
    public List<BaseCatalog3> getCatalog3(String catalog2Id);
    public List<BaseAttrInfo> getAttrInfoList(String catalog3Id);
}
