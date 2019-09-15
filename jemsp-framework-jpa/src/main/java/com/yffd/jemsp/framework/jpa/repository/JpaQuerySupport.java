package com.yffd.jemsp.framework.jpa.repository;

import com.yffd.jemsp.module.support.page.PageData;
import com.yffd.jemsp.module.support.page.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class JpaQuerySupport {

    protected PageRequest toPageable(PageInfo pageInfo) {
        return PageRequest.of(pageInfo.getPageNum() -1 , pageInfo.getPageSize());
    }

    protected PageRequest toPageable(PageInfo pageInfo, Sort sort) {
        return PageRequest.of(pageInfo.getPageNum() -1 , pageInfo.getPageSize(), sort);
    }

    protected <T> PageData<T> toPageData(Page<T> page, PageInfo pageInfo) {
        pageInfo.setTotalRecord(Integer.parseInt(page.getTotalElements() + ""));
        List<T> list = new ArrayList<>();
        page.forEach(roleData -> list.add(roleData));
        PageData<T> pageData = new PageData<>(pageInfo, list);
        return pageData;
    }

}
