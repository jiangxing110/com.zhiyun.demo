/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.CmsNewsInfoDao;
import com.zhiyun.dto.CmsNewsInfoDto;
import com.zhiyun.entity.CmsNewsInfo;

/**
 * CmsNewsInfoDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("cmsNewsInfoDao")
public class CmsNewsInfoDaoImpl extends BaseDaoImpl<CmsNewsInfo, Long> implements CmsNewsInfoDao {

	@Override
	public DataGrid<CmsNewsInfoDto> pageWithChannel(Page page, Params params) {
		return selectPage(getMethodName(), params, page);
	}

}
