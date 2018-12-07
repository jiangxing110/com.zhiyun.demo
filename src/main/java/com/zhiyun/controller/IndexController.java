/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.util.CommonUtils;
import com.zhiyun.client.UserHolder;
import com.zhiyun.internal.server.auth.dto.AppMenuDto;
import com.zhiyun.internal.server.auth.service.InterfaceForUser;

/**
 * 同步请求主页
 *
 * @author 庄超
 * @version v1.0
 * @date 2018 -05-05 13:01
 */
@Controller
@RequestMapping(value="/index")
public class IndexController{
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Resource
	private InterfaceForUser interfaceForUser;
	
    /**
     * 查询样式接口
     *
     * @param model 传输对象
     * @return java.lang.String 响应页面地址
     * @author 庄超
     */
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index( Model model) {
		logger.debug("request in");
		//查询权限
		System.out.println( UserHolder.getId()+"|||"+UserHolder.getCompanyId());
		List<AppMenuDto> list = interfaceForUser.getUserMenuForApp("dcnew", 1, 234397l, 234411l);
        if (!CommonUtils.isEmpty(list)) {
            model.addAttribute("menuList", JSON.toJSONString(list));
        } else {
            model.addAttribute("menuList", JSON.toJSONString("[]"));
        }
        
		model.addAttribute("userName", UserHolder.getUserName());
		model.addAttribute("usrmsg", UserHolder.getCompanyId()+"-"+UserHolder.getId());
		model.addAttribute("companyName", UserHolder.getCompanyName());
		return "/demo/index";
	}
	
}
