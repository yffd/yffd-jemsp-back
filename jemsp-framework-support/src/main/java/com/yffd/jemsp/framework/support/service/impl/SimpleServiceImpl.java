package com.yffd.jemsp.framework.support.service.impl;

import com.yffd.jemsp.framework.mybatis.dao.DefaultMybatisDao;
import com.yffd.jemsp.framework.support.service.IBaseService;
import com.yffd.jemsp.module.support.page.PageData;
import com.yffd.jemsp.module.support.page.PageInfo;
import com.yffd.jemsp.module.support.param.CurrentParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description  业务逻辑操作，直接利用DefaultMybatisDao完成持久化操作.
 * @Date		 2018年5月8日 下午5:04:19 <br/>
 * @author       zhangST
 * @version		 1.0
 * @since		 JDK 1.7+
 * @see 	 
 */
public abstract class SimpleServiceImpl<E> extends DefaultMybatisDao<E> implements IBaseService<E> {

	protected abstract void beforeSetPropertiesForQuery(Object pojo, CurrentParam currentParam);
	protected abstract void beforeSetPropertiesForAdd(Object pojo, CurrentParam currentParam);
	protected abstract void beforeSetPropertiesForUpdate(Object pojo, CurrentParam currentParam);
	protected abstract void beforeSetPropertiesForDelete(Object pojo, CurrentParam currentParam);
	
	@Override
	public Integer findCount(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return super.selectCountBy(rootEntity, null);
	}

	@Override
	public E findOne(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return (E) super.selectOneBy(rootEntity, null);
	}

	@Override
	public List<E> findListWithOrder(E rootEntity, String orderBy, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return (List<E>) super.selectListBy(rootEntity, null, orderBy);
	}

	@Override
	public List<E> findList(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return (List<E>) super.selectListBy(rootEntity, null, null);
	}

	@Override
	public List<E> findAll() {
		return (List<E>) super.selectListBy(null, null, null);
	}

	@Override
	public List<E> findAllWithOrder(String orderBy) {
		return (List<E>) super.selectListBy(null, null, orderBy);
	}

	@Override
	public PageData<E> findPageWithOrder(E rootEntity, String orderBy, PageInfo page, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return (PageData<E>) super.selectPageBy(rootEntity, null, orderBy, page);
	}

	@Override
	public PageData<E> findPage(E rootEntity, PageInfo page, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return (PageData<E>) super.selectPageBy(rootEntity, null, null, page);
	}
	
	@Override
	public Boolean exsistAndUnique(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return super.exsistAndUniqueBy(rootEntity, null);
	}

	@Override
	public Boolean exsist(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForQuery(rootEntity, currentParam);
		return super.exsistBy(rootEntity, null);
	}
	
	@Override
	public Integer addOne(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForAdd(rootEntity, currentParam);
		return super.insertOneBy(rootEntity);
	}

	@Override
	public Integer addList(List<E> rootEntityList, CurrentParam currentParam) {
		if(null==rootEntityList || rootEntityList.size()==0) return 0;
		List<E> tmpList = new ArrayList<>();
		for(E rootEntity : rootEntityList) {
			this.beforeSetPropertiesForAdd(rootEntity, currentParam);
			tmpList.add(rootEntity);
		}
		return super.insertBatchBy(tmpList);
	}

	@Override
	public Integer update(E rootEntity, E rootEntityOld, CurrentParam currentParam) {
		this.beforeSetPropertiesForUpdate(rootEntity, currentParam);
		return super.updateBy(rootEntity, rootEntityOld, null);
	}

	@Override
	public Integer delete(E rootEntity, CurrentParam currentParam) {
		this.beforeSetPropertiesForDelete(rootEntity, currentParam);
		return super.deleteBy(rootEntity, null);
	}

}

