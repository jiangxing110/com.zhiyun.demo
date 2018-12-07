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
public class CasGroup extends BaseEntity<Long> {

	private static final long serialVersionUID = 7128582783411934330L;

	// ~~~~实体属性
	// 用户组名
	@Pattern(regexp="[\\S]{0,10}", message="用户组名字段过长")
	private String groupName;
	// 用户组描述
	@Pattern(regexp="[\\S]{0,50}", message="用户组描述字段过长")
	private String groupDesc;
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
	 * 用户组名
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * 用户组名
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	/**
	 * 用户组描述
	 */
	public String getGroupDesc() {
		return this.groupDesc;
	}

	/**
	 * 用户组描述
	 */
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
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
