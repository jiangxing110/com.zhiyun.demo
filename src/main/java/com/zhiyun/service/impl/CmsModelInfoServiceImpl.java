/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CmsModelInfoDao;
import com.zhiyun.dto.CmsModelInfoDto;
import com.zhiyun.entity.CmsModelInfo;
import com.zhiyun.service.CmsModelInfoService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("cmsModelInfoService")
public class CmsModelInfoServiceImpl extends BaseServiceImpl<CmsModelInfo, Long> implements CmsModelInfoService {

	@Resource
	private CmsModelInfoDao cmsModelInfoDao;

	@Override
	protected BaseDao<CmsModelInfo, Long> getBaseDao() {
		return this.cmsModelInfoDao;
	}

	@Override
	public List<CmsModelInfoDto> findWithTemplate(CmsModelInfo cmsModelInfo) {
		return cmsModelInfoDao.findWithTemplate(cmsModelInfo);
	}
}
