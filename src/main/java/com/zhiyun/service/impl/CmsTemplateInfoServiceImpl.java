/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CmsTemplateInfoDao;
import com.zhiyun.entity.CmsTemplateInfo;
import com.zhiyun.service.CmsTemplateInfoService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("cmsTemplateInfoService")
public class CmsTemplateInfoServiceImpl extends BaseServiceImpl<CmsTemplateInfo, Long> implements CmsTemplateInfoService {

	@Resource
	private CmsTemplateInfoDao cmsTemplateInfoDao;

	@Override
	protected BaseDao<CmsTemplateInfo, Long> getBaseDao() {
		return this.cmsTemplateInfoDao;
	}
}
