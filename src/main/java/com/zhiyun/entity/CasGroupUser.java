/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import javax.validation.constraints.Max;

import com.zhiyun.base.entity.BaseEntity;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class CasGroupUser extends BaseEntity<Long> {

	private static final long serialVersionUID = 3662457971342467784L;

	// ~~~~实体属性
	// 用户组主键
	@Max(value=9223372036854775807L,message="用户组主键字段过长")
	private Long groupId;
	// 用户
	@Max(value=9223372036854775807L,message="用户字段过长")
	private Long userId;
	// 公司主键
	@Max(value=9223372036854775807L,message="公司主键字段过长")
	private Long companyId;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 用户组主键
	 */
	public Long getGroupId() {
		return this.groupId;
	}

	/**
	 * 用户组主键
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	/**
	 * 用户
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * 用户
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * 公司主键
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 公司主键
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
