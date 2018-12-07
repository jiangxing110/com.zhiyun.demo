package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CasOrgDao;
import com.zhiyun.entity.CasOrg;
import com.zhiyun.service.CasOrgService;

@Service("casOrgService")
public class CasOrgServiceImpl extends BaseServiceImpl<CasOrg, Long> implements CasOrgService {

    @Resource
    private CasOrgDao casOrgDao;

    @Override
    protected BaseDao<CasOrg, Long> getBaseDao() {
        return this.casOrgDao;
    }

}
