/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.CasRoleDao;
import com.zhiyun.entity.CasRole;

/**
 * CasRoleDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("casRoleDao")
public class CasRoleDaoImpl extends BaseDaoImpl<CasRole, Long> implements CasRoleDao {

	@Override
	public List<CasRole> listUserRole(Params params) {
		return selectList(getMethodName(), params);
	}

}
