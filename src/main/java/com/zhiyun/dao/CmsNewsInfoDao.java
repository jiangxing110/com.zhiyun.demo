/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.CmsNewsInfoDto;
import com.zhiyun.entity.CmsNewsInfo;

/**
 * CmsNewsInfoDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CmsNewsInfoDao extends BaseDao<CmsNewsInfo, Long> {

	DataGrid<CmsNewsInfoDto> pageWithChannel(Page page ,Params params);
}
