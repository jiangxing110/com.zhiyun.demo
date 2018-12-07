/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CmsNewsInfoDao;
import com.zhiyun.dto.CmsNewsInfoDto;
import com.zhiyun.entity.CmsNewsInfo;
import com.zhiyun.service.CmsNewsInfoService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("cmsNewsInfoService")
public class CmsNewsInfoServiceImpl extends BaseServiceImpl<CmsNewsInfo, Long> implements CmsNewsInfoService {

	@Resource
	private CmsNewsInfoDao cmsNewsInfoDao;

	@Override
	protected BaseDao<CmsNewsInfo, Long> getBaseDao() {
		return this.cmsNewsInfoDao;
	}

	@Override
	public DataGrid<CmsNewsInfoDto> pageWithChannel(Page page, Params params) {
		return cmsNewsInfoDao.pageWithChannel(page, params);
	}
}
