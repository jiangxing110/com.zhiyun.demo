/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import java.util.List;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.CmsModelInfoDto;
import com.zhiyun.entity.CmsModelInfo;

/**
 * CmsModelInfoDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CmsModelInfoDao extends BaseDao<CmsModelInfo, Long> {
	List<CmsModelInfoDto> findWithTemplate(CmsModelInfo cmsModelInfo);
}
