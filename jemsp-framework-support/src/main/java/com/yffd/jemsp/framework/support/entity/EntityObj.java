package com.yffd.jemsp.framework.support.entity;

import com.yffd.jemsp.module.support.javabean.dataobj.IDataObject;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class EntityObj implements IDataObject {
    private static final long serialVersionUID = -1984706754577541415L;
    private String delFlag;         //删除标记，已删除=1、未删除=0
    private Integer version = 0;    //版本号
    private String createBy;        //创建者
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;        //创建时间
    private String updateBy;        //修改者
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;        //修改时间

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
