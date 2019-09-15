package com.yffd.jemsp.framework.ddd.domain.entity;

import com.yffd.jemsp.framework.ddd.domain.data.DataObject;
import com.yffd.jemsp.framework.ddd.domain.data.DataObjectHelper;
import com.yffd.jemsp.module.support.javabean.entity.IEntityObject;
import com.yffd.jemsp.module.support.exception.InvalidException;
import com.yffd.jemsp.module.support.generator.IdentityGenerator;
import com.yffd.jemsp.module.support.param.CurrentParam;

public abstract class EntityObject<D extends DataObject> implements IEntityObject {
    private CurrentParam currentParam;
    private D data;

    public EntityObject(D data, CurrentParam currentParam) {
        if (null == data || null == currentParam)
            throw InvalidException.PARAM_IS_EMPTY("构造器参数错误["+this.getClass()+"]");
        this.data = data;
        this.currentParam = currentParam;
    }

    public abstract String identity();

    public String nextIdentity() {
        return IdentityGenerator.getId();
    }

    public D data() {
        return this.data;
    }

    public CurrentParam sysOperator() {
        return this.currentParam;
    }

    public D add() {
        DataObjectHelper.initPropsForAdd(this.data, this.currentParam);
        return this.data;
    }

    public D updateById() {
        if (this.isEmptyString(this.identity()))
            throw InvalidException.PARAM_IS_EMPTY("修改失败，数据实体ID不能为空[" + this.getClass() + "]");
        DataObjectHelper.initPropsForUpdate(this.data, this.currentParam);
        return this.data;
    }

    public String deleteById() {
        if (this.isEmptyString(this.identity()))
            throw InvalidException.PARAM_IS_EMPTY("删除失败，数据实体ID不能为空[" + this.getClass() + "]");
        return this.identity();
    }

    public String exsistById() {
        if (this.isEmptyString(this.identity()))
            throw InvalidException.PARAM_IS_EMPTY("主键查询失败，数据实体ID不能为空[" + this.getClass() + "]");
        return this.identity();
    }

    protected void initPropsForAdd() {
        DataObjectHelper.initPropsForAdd(this.data, this.currentParam);
    }
    protected void initPropsForUpdate() {
        DataObjectHelper.initPropsForUpdate(this.data, this.currentParam);
    }
    protected void initPropsForLogicalDelete() {
        DataObjectHelper.initPropsForLogicalDelete(this.data, this.currentParam);
    }

    private boolean isEmptyString(String str) {
        return (null==str || "".equals(str.trim()));
    }
}
