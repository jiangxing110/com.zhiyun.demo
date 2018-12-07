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
public class BaseDatamodel extends BaseEntity<Long> {

	private static final long serialVersionUID = 4665968969691887458L;

	// ~~~~实体属性
	// 仓库主键
	@Max(value=9223372036854775807L,message="仓库主键字段过长")
	private Long warehouseId;
	// 编码
	@Pattern(regexp="[\\S]{0,20}", message="编码字段过长")
	private String modelCode;
	// 别名
	@Pattern(regexp="[\\S]{0,40}", message="别名字段过长")
	private String alias;
	// 备注
	@Pattern(regexp="[\\S]{0,255}", message="备注字段过长")
	private String remark;
	// 是否数据授权
	private Boolean isPermission;
	// 是否启用
	private Boolean isAble;
	// 启用时间
	private java.util.Date ableTime;
	// 启用人
	@Pattern(regexp="[\\S]{0,255}", message="启用人字段过长")
	private String ableBy;
	// 是否操作授权
	private Boolean isOperation;
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
	
	
	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * 编码
	 */
	public String getModelCode() {
		return this.modelCode;
	}

	/**
	 * 编码
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	
	/**
	 * 别名
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * 别名
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/**
	 * 备注
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 是否数据授权
	 */
	public Boolean getIsPermission() {
		return this.isPermission;
	}

	/**
	 * 是否数据授权
	 */
	public void setIsPermission(Boolean isPermission) {
		this.isPermission = isPermission;
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
	public Boolean getIsOperation() {
		return this.isOperation;
	}

	/**
	 * 
	 */
	public void setIsOperation(Boolean isOperation) {
		this.isOperation = isOperation;
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
