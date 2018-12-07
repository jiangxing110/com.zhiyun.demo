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
public class BaseWarehouse extends BaseEntity<Long> {

	private static final long serialVersionUID = 7192453761945473467L;

	// ~~~~实体属性
	// 仓库名称
	@Pattern(regexp="[\\S]{0,40}", message="仓库名称字段过长")
	private String alias;
	// 父主键
	@Max(value=9223372036854775807L,message="父主键字段过长")
	private Long parentId;
	// 是否叶节点
	private Boolean isLeaf;
	// ID路径
	@Pattern(regexp="[\\S]{0,255}", message="ID路径字段过长")
	private String treeIdPath;
	// 名称路径
	@Pattern(regexp="[\\S]{0,255}", message="名称路径字段过长")
	private String treeNamePath;
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
	 * 仓库名称
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * 仓库名称
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/**
	 * 父主键
	 */
	public Long getParentId() {
		return this.parentId;
	}

	/**
	 * 父主键
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 是否叶节点
	 */
	public Boolean getIsLeaf() {
		return this.isLeaf;
	}

	/**
	 * 是否叶节点
	 */
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	/**
	 * ID路径
	 */
	public String getTreeIdPath() {
		return this.treeIdPath;
	}

	/**
	 * ID路径
	 */
	public void setTreeIdPath(String treeIdPath) {
		this.treeIdPath = treeIdPath;
	}
	
	/**
	 * 名称路径
	 */
	public String getTreeNamePath() {
		return this.treeNamePath;
	}

	/**
	 * 名称路径
	 */
	public void setTreeNamePath(String treeNamePath) {
		this.treeNamePath = treeNamePath;
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
