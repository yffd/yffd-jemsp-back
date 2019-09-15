package com.yffd.jemsp.framework.support.service.impl;

import com.yffd.jemsp.framework.mybatis.constant.MybatisConstants;
import com.yffd.jemsp.framework.support.entity.EntityObj;
import com.yffd.jemsp.framework.support.service.IBaseService;
import com.yffd.jemsp.module.support.param.CurrentParam;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description  简单描述该类的功能（可选）.
 * @Date		 2018年6月6日 下午5:31:47 <br/>
 * @author       zhangST
 * @version		 1.0
 * @since		 JDK 1.7+
 * @see 	 
 */
public class DefaultServiceImpl<E> extends SimpleServiceImpl<E> implements IBaseService<E> {

	@Override
	protected void beforeSetPropertiesForQuery(Object domain, CurrentParam currentParam) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void beforeSetPropertiesForAdd(Object domain, CurrentParam currentParam) {
		if(domain instanceof EntityObj) {
            EntityObj entity = (EntityObj) domain;
			entity.setVersion(0);
			entity.setDelFlag("0");
			entity.setCreateTime(new Date());
			if(null!=currentParam) entity.setCreateBy(currentParam.getUserId());
		} else if(domain instanceof Map) {
			Map<String, Object> parameter = (Map<String, Object>) domain;
			parameter.put("version", 0);
			parameter.put("delFlag", "0");
			parameter.put("createTime", new Date());
			if(null!=currentParam) parameter.put("createBy", currentParam.getUserId());
		}
	}

	@Override
	protected void beforeSetPropertiesForUpdate(Object domain, CurrentParam currentParam) {
		if(domain instanceof EntityObj) {
            EntityObj entity = (EntityObj) domain;
			entity.setUpdateTime(new Date());
			if(null!=currentParam) entity.setUpdateBy(currentParam.getUserId());
		} else if(domain instanceof Map) {
			Map<String, Object> parameter = (Map<String, Object>) domain;
			parameter.put("updateTime", new Date());
			if(null!=currentParam) parameter.put("updateBy", currentParam.getUserId());
		}
		
	}

	@Override
	protected void beforeSetPropertiesForDelete(Object domain, CurrentParam currentParam) {
		// TODO Auto-generated method stub
		
	}
	
	public Integer deleteByIds(Set<?> ids, CurrentParam currentParam) {
		return this.deleteByProps(MybatisConstants.PARAM_NAME_ID_ITER, ids);
	}
	
	public Integer deleteAll() {
		Map<String, Object> propsMap = new HashMap<>();
		propsMap.put("delAll", "delAll");
		return super.deleteBy(null, propsMap);
	}
	
}

