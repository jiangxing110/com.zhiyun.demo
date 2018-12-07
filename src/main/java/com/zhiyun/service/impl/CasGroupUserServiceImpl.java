/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CasGroupUserDao;
import com.zhiyun.entity.CasGroupUser;
import com.zhiyun.service.CasGroupUserService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("casGroupUserService")
public class CasGroupUserServiceImpl extends BaseServiceImpl<CasGroupUser, Long> implements CasGroupUserService {

	@Resource
	private CasGroupUserDao casGroupUserDao;

	@Override
	protected BaseDao<CasGroupUser, Long> getBaseDao() {
		return this.casGroupUserDao;
	}
}
