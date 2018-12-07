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
public class BaseVersion extends BaseEntity<Long> {

	private static final long serialVersionUID = 2599851699492756250L;

	// ~~~~实体属性
	// 模型主键
	@Max(value=9223372036854775807L,message="模型主键字段过长")
	private Long modelId;
	// 版本号
	@Max(value=99999999999L,message="版本号字段过长")
	private Integer versionNo;
	// 是否启用
	private Boolean isAble;
	// 启用时间
	private java.util.Date ableTime;
	// 启用人
	@Pattern(regexp="[\\S]{0,255}", message="启用人字段过长")
	private String ableBy;
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
	 * 模型主键
	 */
	public Long getModelId() {
		return this.modelId;
	}

	/**
	 * 模型主键
	 */
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	
	/**
	 * 版本号
	 */
	public Integer getVersionNo() {
		return this.versionNo;
	}

	/**
	 * 版本号
	 */
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	
	/**
	 * 是否启用
	 */
	public Boolean getIsAble() {
		return this.isAble;
	}

	/**
	 * 是否启用
	 */
	public void setIsAble(Boolean isAble) {
		this.isAble = isAble;
	}
	
	/**
	 * 启用时间
	 */
	public java.util.Date getAbleTime() {
		return this.ableTime;
	}

	/**
	 * 启用时间
	 */
	public void setAbleTime(java.util.Date ableTime) {
		this.ableTime = ableTime;
	}
	
	/**
	 * 启用人
	 */
	public String getAbleBy() {
		return this.ableBy;
	}

	/**
	 * 启用人
	 */
	public void setAbleBy(String ableBy) {
		this.ableBy = ableBy;
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
