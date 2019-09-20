package com.yffd.jemsp.framework.ddd.application.service;

import com.yffd.jemsp.framework.ddd.application.service.support.IApplicationService;
import com.yffd.jemsp.framework.ddd.domain.data.DataObject;
import com.yffd.jemsp.framework.ddd.domain.entity.EntityObject;
import com.yffd.jemsp.framework.ddd.infrastructure.repository.RepositorySupport;
import com.yffd.jemsp.module.support.exception.InvalidException;
import com.yffd.jemsp.module.support.param.CurrentParam;

public abstract class ApplicationServiceSupport<D extends DataObject> implements IApplicationService {

    public abstract EntityObject buildEntity(D data, CurrentParam currentParam);
    public abstract RepositorySupport repository();

    public void add(D data, CurrentParam currentParam) {
        EntityObject entity = this.buildEntity(data, currentParam);
        if (this.exsistById(entity)) {
            throw InvalidException.DATA_EXSIST("添加失败，数据已存在[ID: "+ entity.identity() +", class："+ data.getClass() +"]");
        }
        this.repository().insertOne(entity.add());
    }

    public void update(D data, CurrentParam currentParam) {
        EntityObject entity = this.buildEntity(data, currentParam);
        this.repository().updateById(entity.updateById());
    }

    public void delete(D data, CurrentParam currentParam) {
        EntityObject entity = this.buildEntity(data, currentParam);
        this.repository().deleteById(entity.deleteById());
    }

    protected Boolean exsistById(EntityObject entity) {
        return null != this.repository().findById(entity.exsistById());
    }
}
