/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CasCompanyDao;
import com.zhiyun.entity.CasCompany;
import com.zhiyun.service.CasCompanyService;

/**
 * Service接口实现类。
 *
 * @author 庄超
 * @version v1.0
 * @date
 */
@Service("casCompanyService")
public class CasCompanyServiceImpl extends BaseServiceImpl<CasCompany, Long> implements CasCompanyService {

	@Resource
	private CasCompanyDao casCompanyDao;

	@Override
	protected BaseDao<CasCompany, Long> getBaseDao() {
		return this.casCompanyDao;
	}
}
