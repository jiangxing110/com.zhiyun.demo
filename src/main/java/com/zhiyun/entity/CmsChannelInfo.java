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
public class CmsChannelInfo extends BaseEntity<Long> {

	private static final long serialVersionUID = 2316412503452316163L;

	// ~~~~实体属性
	// 名称
	@Pattern(regexp="[\\S]{0,255}", message="名称字段过长")
	private String alias;
	// 模型主键
	@Max(value=9223372036854775807L,message="模型主键字段过长")
	private Long modelId;
	// 排序
	@Max(value=99999999999L,message="排序字段过长")
	private Integer orders;
	// 父ID
	@Max(value=9223372036854775807L,message="父ID字段过长")
	private Long parentId;
	// 是否节点
	private Boolean isLeaf;
	// 是否启用
	private Boolean isAble;
	// 路径
	@Pattern(regexp="[\\S]{0,255}", message="路径字段过长")
	private String treeIdPath;
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
	 * 父ID
	 */
	public Long getParentId() {
		return this.parentId;
	}

	/**
	 * 父ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 是否节点
	 */
	public Boolean getIsLeaf() {
		return this.isLeaf;
	}

	/**
	 * 是否节点
	 */
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
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
	 * 路径
	 */
	public String getTreeIdPath() {
		return this.treeIdPath;
	}

	/**
	 * 路径
	 */
	public void setTreeIdPath(String treeIdPath) {
		this.treeIdPath = treeIdPath;
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
