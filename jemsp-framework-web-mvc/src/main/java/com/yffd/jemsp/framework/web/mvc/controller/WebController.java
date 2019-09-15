package com.yffd.jemsp.framework.web.mvc.controller;

import com.yffd.jemsp.framework.web.mvc.constants.WebConstants;
import com.yffd.jemsp.module.support.page.PageInfo;
import com.yffd.jemsp.module.support.param.CurrentParam;

import java.util.Date;

public class WebController {

    protected CurrentParam currentParam() {
        CurrentParam currentParam = new CurrentParam();
        currentParam.setOperateTime(new Date());
        return currentParam;
    }

    protected PageInfo pageInfo(Integer pageNum, Integer pageSize) {
        if (null == pageNum) pageNum = 0;
        if (null == pageSize) pageNum = WebConstants.KEY_PAGE_SIZE;
        return new PageInfo(pageNum, pageSize);
    }



/*
    protected static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @InitBinder
    public void intDate(WebDataBinder dataBinder) {
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }

    @InitBinder("page")
    public void initPage(WebDataBinder binder){
        System.out.println(">>>>>InitBinder>>>>initPage");
        binder.setFieldDefaultPrefix("page.");
    }

    @InitBinder("condition")
    public void initCondition(WebDataBinder binder){
        System.out.println(">>>>InitBinder>>>>>criteria");
        binder.setFieldDefaultPrefix("condition.");
    }
*/

}
