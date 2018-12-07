/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.CmsModelInfoDao;
import com.zhiyun.dto.CmsModelInfoDto;
import com.zhiyun.entity.CmsModelInfo;

/**
 * CmsModelInfoDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("cmsModelInfoDao")
public class CmsModelInfoDaoImpl extends BaseDaoImpl<CmsModelInfo, Long> implements CmsModelInfoDao {

	@Override
	public List<CmsModelInfoDto> findWithTemplate(CmsModelInfo cmsModelInfo) {
		return selectList(getMethodName(), cmsModelInfo);
	}

}
