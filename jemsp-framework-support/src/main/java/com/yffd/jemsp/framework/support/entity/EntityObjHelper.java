package com.yffd.jemsp.framework.support.entity;

import com.yffd.jemsp.module.support.param.CurrentParam;

import java.util.Calendar;

public class EntityObjHelper {

    private EntityObjHelper() {
    }

    public static <T extends EntityObj> void initPropsForAdd(T data, CurrentParam currentParam) {
        data.setVersion(0);
        data.setDelFlag("0");
        data.setCreateTime(Calendar.getInstance().getTime());
        if(null!=currentParam) data.setCreateBy(currentParam.getUserId());
    }

    public static <T extends EntityObj> void initPropsForUpdate(T data, CurrentParam currentParam) {
        data.setVersion(data.getVersion() + 1);
        data.setUpdateTime(Calendar.getInstance().getTime());
        if(null!=currentParam) data.setUpdateBy(currentParam.getUserId());
    }

    /**
     * 逻辑删除
     * @param data
     * @param currentParam
     * @param <T>
     */
    public static <T extends EntityObj> void initPropsForLogicalDelete(T data, CurrentParam currentParam) {
        initPropsForUpdate(data, currentParam);
        data.setDelFlag("1");
    }

}
