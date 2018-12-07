/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class CmsModelInfo extends BaseEntity<Long> {

	private static final long serialVersionUID = 1770731043468688886L;

	// ~~~~实体属性
	// 结构名称
	@Pattern(regexp="[\\S]{0,255}", message="结构名称字段过长")
	private String alias;
	// 是否启用
	private Boolean isAble;
	// 启用时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date ableTime;
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
	 * 结构名称
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * 结构名称
	 */
	public void setAlias(String alias) {
		this.alias = alias;
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
