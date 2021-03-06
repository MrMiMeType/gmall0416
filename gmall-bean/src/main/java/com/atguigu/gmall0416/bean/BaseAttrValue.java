package com.atguigu.gmall0416.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class BaseAttrValue implements Serializable {
    @Column
    @Id
    private  String id;
    @Column
    private  String attrId;
    @Column
    private  String valueName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
}
