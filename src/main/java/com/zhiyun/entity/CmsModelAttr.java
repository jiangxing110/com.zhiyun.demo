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
public class CmsModelAttr extends BaseEntity<Long> {

	private static final long serialVersionUID = 4390380803761009574L;

	// ~~~~实体属性
	// 模型主键
	@Max(value=9223372036854775807L,message="模型主键字段过长")
	private Long modelId;
	// 名称
	@Pattern(regexp="[\\S]{0,255}", message="名称字段过长")
	private String alias;
	// 数据类型
	@Pattern(regexp="[\\S]{0,255}", message="数据类型字段过长")
	private String dataType;
	// 属性类型
	@Pattern(regexp="[\\S]{0,255}", message="属性类型字段过长")
	private String attrType;
	// 排序
	@Max(value=99999999999L,message="排序字段过长")
	private Integer orders;
	// 
	@Max(value=9223372036854775807L,message="字段过长")
	private Long companyId;
	@Pattern(regexp="[\\S]{0,255}", message="字段过长")
	private String remark;
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
	 * 名称
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * 名称
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
	 * 属性类型
	 */
	public String getAttrType() {
		return this.attrType;
	}

	/**
	 * 属性类型
	 */
	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}
	
	/**
	 * 排序
	 */
	public Integer getOrders() {
		return this.orders;
	}

	/**
	 * 排序
	 */
	public void setOrders(Integer orders) {
		this.orders = orders;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
