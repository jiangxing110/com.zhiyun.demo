/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CmsModelAttrDao;
import com.zhiyun.entity.CmsModelAttr;
import com.zhiyun.service.CmsModelAttrService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("cmsModelAttrService")
public class CmsModelAttrServiceImpl extends BaseServiceImpl<CmsModelAttr, Long> implements CmsModelAttrService {

	@Resource
	private CmsModelAttrDao cmsModelAttrDao;

	@Override
	protected BaseDao<CmsModelAttr, Long> getBaseDao() {
		return this.cmsModelAttrDao;
	}
}
