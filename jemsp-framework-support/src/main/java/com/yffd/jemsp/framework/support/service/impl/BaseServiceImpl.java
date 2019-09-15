package com.yffd.jemsp.framework.support.service.impl;

import com.yffd.jemsp.framework.support.dao.IBaseDao;
import com.yffd.jemsp.framework.support.service.IBaseService;
import com.yffd.jemsp.module.support.page.PageData;
import com.yffd.jemsp.module.support.page.PageInfo;
import com.yffd.jemsp.module.support.param.CurrentParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description  业务逻辑操作，需要注入自己实现的Dao类.
 * @Date		 2018年5月8日 下午5:04:19 <br/>
 * @author       zhangST
 * @version		 1.0
 * @since		 JDK 1.7+
 * @see 	 
 */
public abstract class BaseServiceImpl<E> implements IBaseService<E> {

	protected abstract IBaseDao<E> getBindDao();
	
	public abstract void beforeSetPropertiesForQuery(E rootEntity, CurrentParam currentParam);
	public abstract void beforeSetPropertiesForAdd(E rootEntity, CurrentParam currentParam);
	public abstract void beforeSetPropertiesForUpdate(E rootEntity, CurrentParam currentParam);
	public abstract void beforeSetPropertiesForDelete(E rootEntity, CurrentParam currentParam);
	
	@Override
	public Integer findCount(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return this.getBindDao().selectCount(rootEntity);
	}

	@Override
	public E findOne(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return this.getBindDao().selectOne(rootEntity);
	}

	@Override
	public List<E> findListWithOrder(E rootEntity, String orderBy, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return this.getBindDao().selectListWithOrder(rootEntity, orderBy);
	}

	@Override
	public List<E> findList(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return this.getBindDao().selectListWithOrder(rootEntity, null);
	}

	@Override
	public List<E> findAll() {
		return this.getBindDao().selectListWithOrder(null, null);
	}

	@Override
	public List<E> findAllWithOrder(String orderBy) {
		return this.getBindDao().selectListWithOrder(null, orderBy);
	}

	@Override
	public PageData<E> findPageWithOrder(E rootEntity, String orderBy, PageInfo page, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return this.getBindDao().selectPageWithOrder(rootEntity, orderBy, page);
	}

	@Override
	public PageData<E> findPage(E rootEntity, PageInfo page, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return this.getBindDao().selectPageWithOrder(rootEntity, null, page);
	}
	
	@Override
	public Boolean exsistAndUnique(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return this.getBindDao().exsistAndUnique(rootEntity);
	}

	@Override
	public Boolean exsist(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return this.getBindDao().exsist(rootEntity);
	}

	@Override
	public Integer addOne(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForAdd(rootEntity, currentParam);
		return this.getBindDao().insertOne(rootEntity);
	}

	@Override
	public Integer addList(List<E> rootEntityList, CurrentParam currentParam) {
		if(null==rootEntityList || rootEntityList.size()==0) return 0;
		List<E> tmpList = new ArrayList<E>();
		for(E rootEntity : rootEntityList) {
			this.beforeSetPropertiesForAdd(rootEntity, currentParam);
			tmpList.add(rootEntity);
		}
		return this.getBindDao().insertBatch(tmpList);
	}

	@Override
	public Integer update(E rootEntity, E rootEntityOld, CurrentParam currentParam) {
		this.beforeSetPropertiesForUpdate(rootEntity, currentParam);
		return this.getBindDao().update(rootEntity, rootEntityOld);
	}

	@Override
	public Integer delete(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForDelete(rootEntity, currentParam);
		return this.getBindDao().delete(rootEntity);
	}
	
}

