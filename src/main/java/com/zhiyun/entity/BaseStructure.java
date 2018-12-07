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
public class BaseStructure extends BaseEntity<Long> {

	private static final long serialVersionUID = 3986326408473343804L;

	// ~~~~实体属性
	// 模型主键
	@Max(value=9223372036854775807L,message="模型主键字段过长")
	private Long modelId;
	// 版本主键
	@Max(value=9223372036854775807L,message="版本主键字段过长")
	private Long versionId;
	// 字段名
	@Pattern(regexp="[\\S]{0,40}", message="字段名字段过长")
	private String alias;
	// 数据类型
	@Pattern(regexp="[\\S]{0,255}", message="数据类型字段过长")
	private String dataType;
	// 默认值
	@Pattern(regexp="[\\S]{0,255}", message="默认值字段过长")
	private String defaultValue;
	// 格式化
	@Pattern(regexp="[\\S]{0,255}", message="格式化字段过长")
	private String formatInfo;
	// 是否关键字
	private Boolean isKey;
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
	 * 版本主键
	 */
	public Long getVersionId() {
		return this.versionId;
	}

	/**
	 * 版本主键
	 */
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	
	/**
	 * 字段名
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * 字段名
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/**
	 * 数据类型
	 */
	public String getDataType() {
		return this.dataType;
	}

	/**
	 * 数据类型
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	/**
	 * 默认值
	 */
	public String getDefaultValue() {
		return this.defaultValue;
	}

	/**
	 * 默认值
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	/**
	 * 格式化
	 */
	public String getFormatInfo() {
		return this.formatInfo;
	}

	/**
	 * 格式化
	 */
	public void setFormatInfo(String formatInfo) {
		this.formatInfo = formatInfo;
	}
	
	/**
	 * 是否关键字
	 */
	public Boolean getIsKey() {
		return this.isKey;
	}

	/**
	 * 是否关键字
	 */
	public void setIsKey(Boolean isKey) {
		this.isKey = isKey;
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
