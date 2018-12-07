/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class CasRole extends BaseEntity<Long> {

	private static final long serialVersionUID = 6634442247092554079L;

	// ~~~~实体属性
	// 角色名称
	@Pattern(regexp="[\\S]{0,20}", message="角色名称字段过长")
	private String roleName;
	// 角色描述
	@Pattern(regexp="[\\S]{0,200}", message="角色描述字段过长")
	private String roleDesc;
	// 企业主键
	@Max(value=9223372036854775807L,message="企业主键字段过长")
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
	 * 角色名称
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	/**
	 * 角色描述
	 */
	public String getRoleDesc() {
		return this.roleDesc;
	}

	/**
	 * 角色描述
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	/**
	 * 企业主键
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业主键
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
