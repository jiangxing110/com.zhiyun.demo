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
import com.zhiyun.dao.CmsChannelInfoDao;
import com.zhiyun.dto.CmsChannelInfoDto;
import com.zhiyun.entity.CmsChannelInfo;
import com.zhiyun.service.CmsChannelInfoService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("cmsChannelInfoService")
public class CmsChannelInfoServiceImpl extends BaseServiceImpl<CmsChannelInfo, Long> implements CmsChannelInfoService {

	@Resource
	private CmsChannelInfoDao cmsChannelInfoDao;

	@Override
	protected BaseDao<CmsChannelInfo, Long> getBaseDao() {
		return this.cmsChannelInfoDao;
	}

	@Override
	public List<CmsChannelInfoDto> findWithAuth(
			CmsChannelInfoDto cmsChannelInfoDto) {
		return cmsChannelInfoDao.findWithAuth(cmsChannelInfoDto);
	}

	@Override
	public List<CmsChannelInfo> findLike(CmsChannelInfo cmsChannelInfo) {
		return cmsChannelInfoDao.findLike(cmsChannelInfo);
	}
}
