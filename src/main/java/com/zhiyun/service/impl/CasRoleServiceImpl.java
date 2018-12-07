/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CasRoleDao;
import com.zhiyun.entity.CasRole;
import com.zhiyun.service.CasRoleService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("casRoleService")
public class CasRoleServiceImpl extends BaseServiceImpl<CasRole, Long> implements CasRoleService {

	@Resource
	private CasRoleDao casRoleDao;

	@Override
	protected BaseDao<CasRole, Long> getBaseDao() {
		return this.casRoleDao;
	}

	@Override
	public List<CasRole> listUserRole(Params params) {
		return this.casRoleDao.listUserRole(params);
	}
}
