package com.yffd.jemsp.framework.mybatis.mapper;

import com.yffd.jemsp.framework.mybatis.constant.MybatisConstants;
import com.yffd.jemsp.module.support.page.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IBaseMapper<E> {

    public int insertOneBy(E rootEntity);

    public int insertListBy(List<E> rootEntityList);

    public int updateBy(@Param(MybatisConstants.PARAM_NAME_rootEntity) E rootEntity,
                        @Param(MybatisConstants.PARAM_NAME_rootEntity_OLD) E rootEntityOld,
                        @Param(MybatisConstants.PARAM_NAME_PROPS_MAP) Map<String, Object> propsMap);

    public int deleteBy(@Param(MybatisConstants.PARAM_NAME_rootEntity) E rootEntity,
                        @Param(MybatisConstants.PARAM_NAME_PROPS_MAP) Map<String, Object> propsMap);

    public E selectOneBy(@Param(MybatisConstants.PARAM_NAME_rootEntity) E rootEntity,
                         @Param(MybatisConstants.PARAM_NAME_PROPS_MAP) Map<String, Object> propsMap);

    public Integer selectCountBy(@Param(MybatisConstants.PARAM_NAME_rootEntity) E rootEntity,
                                 @Param(MybatisConstants.PARAM_NAME_PROPS_MAP) Map<String, Object> propsMap);

    public List<E> selectListBy(@Param(MybatisConstants.PARAM_NAME_rootEntity) E rootEntity,
                                @Param(MybatisConstants.PARAM_NAME_PROPS_MAP) Map<String, Object> propsMap,
                                @Param(MybatisConstants.PARAM_NAME_ORDER_BY) String orderBy,
                                @Param(MybatisConstants.PARAM_NAME_PAGE) PageInfo page);

}
