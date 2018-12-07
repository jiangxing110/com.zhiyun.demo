/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CasGroupDao;
import com.zhiyun.entity.CasGroup;
import com.zhiyun.service.CasGroupService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("casGroupService")
public class CasGroupServiceImpl extends BaseServiceImpl<CasGroup, Long> implements CasGroupService {

	@Resource
	private CasGroupDao casGroupDao;

	@Override
	protected BaseDao<CasGroup, Long> getBaseDao() {
		return this.casGroupDao;
	}
}
