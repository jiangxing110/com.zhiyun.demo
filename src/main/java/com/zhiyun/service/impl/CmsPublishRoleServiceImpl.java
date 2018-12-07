/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CmsPublishRoleDao;
import com.zhiyun.entity.CmsPublishRole;
import com.zhiyun.service.CmsPublishRoleService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("cmsPublishRoleService")
public class CmsPublishRoleServiceImpl extends BaseServiceImpl<CmsPublishRole, Long> implements CmsPublishRoleService {

	@Resource
	private CmsPublishRoleDao cmsPublishRoleDao;

	@Override
	protected BaseDao<CmsPublishRole, Long> getBaseDao() {
		return this.cmsPublishRoleDao;
	}
}
