/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.CmsNewsInfoDto;
import com.zhiyun.entity.CmsNewsInfo;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CmsNewsInfoService extends BaseService<CmsNewsInfo, Long> {
	DataGrid<CmsNewsInfoDto> pageWithChannel(Page page ,Params params);
}
