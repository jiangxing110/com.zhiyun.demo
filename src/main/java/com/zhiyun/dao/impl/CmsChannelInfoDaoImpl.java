/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.CmsChannelInfoDao;
import com.zhiyun.dto.CmsChannelInfoDto;
import com.zhiyun.entity.CmsChannelInfo;

/**
 * CmsChannelInfoDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("cmsChannelInfoDao")
public class CmsChannelInfoDaoImpl extends BaseDaoImpl<CmsChannelInfo, Long> implements CmsChannelInfoDao {

	@Override
	public List<CmsChannelInfoDto> findWithAuth(
			CmsChannelInfoDto cmsChannelInfoDto) {
		return selectList(getMethodName(), cmsChannelInfoDto);
	}

	@Override
	public List<CmsChannelInfo> findLike(CmsChannelInfo cmsChannelInfo) {
		return selectList(getMethodName(), cmsChannelInfo);
	}

}
