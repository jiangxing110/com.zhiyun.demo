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
public class CmsPublishRole extends BaseEntity<Long> {

	private static final long serialVersionUID = 3638457311840482162L;

	// ~~~~实体属性
	// 角色主键
	@Max(value=9223372036854775807L,message="角色主键字段过长")
	private Long roleId;
	// 栏目主键
	@Max(value=9223372036854775807L,message="栏目主键字段过长")
	private Long channelId;
	// 发布权限
	private Boolean publishPermission;
	// 审核权限
	private Boolean auditPermission;
	// 
	@Max(value=9223372036854775807L,message="字段过长")
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
	 * 角色主键
	 */
	public Long getRoleId() {
		return this.roleId;
	}

	/**
	 * 角色主键
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * 栏目主键
	 */
	public Long getChannelId() {
		return this.channelId;
	}

	/**
	 * 栏目主键
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	
	/**
	 * 发布权限
	 */
	public Boolean getPublishPermission() {
		return this.publishPermission;
	}

	/**
	 * 发布权限
	 */
	public void setPublishPermission(Boolean publishPermission) {
		this.publishPermission = publishPermission;
	}
	
	/**
	 * 审核权限
	 */
	public Boolean getAuditPermission() {
		return this.auditPermission;
	}

	/**
	 * 审核权限
	 */
	public void setAuditPermission(Boolean auditPermission) {
		this.auditPermission = auditPermission;
	}
	
	/**
	 * 
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
