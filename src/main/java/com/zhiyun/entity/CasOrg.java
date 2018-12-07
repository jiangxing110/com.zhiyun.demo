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
public class CasOrg extends BaseEntity<Long> {

	private static final long serialVersionUID = 2448051190404832601L;

	// ~~~~实体属性
	// 部门编码
	@Pattern(regexp="[\\S]{0,40}", message="部门编码字段过长")
	private String orgCode;
	// 部门名称
	@Pattern(regexp="[\\S]{0,20}", message="部门名称字段过长")
	private String orgName;
	// 父主键
	@Max(value=9223372036854775807L,message="父主键字段过长")
	private Long parentId;
	// 是否叶节点
	private Boolean isLeaf;
	// 部门权责描述
	@Pattern(regexp="[\\S]{0,255}", message="部门权责描述字段过长")
	private String description;
	// 部门第二负责人
	@Pattern(regexp="[\\S]{0,255}", message="部门第二负责人字段过长")
	private String secondleader;
	// 部门负责人
	@Pattern(regexp="[\\S]{0,255}", message="部门负责人字段过长")
	private String leader;
	// 目标雇员数
	@Max(value=99999999999L,message="目标雇员数字段过长")
	private Integer hires;
	// 
	@Pattern(regexp="[\\S]{0,255}", message="字段过长")
	private String orgIdPath;
	// 部门树
	@Pattern(regexp="[\\S]{0,255}", message="部门树字段过长")
	private String orgPath;
	// 排序
	@Max(value=99999999999L,message="排序字段过长")
	private Integer orders;
	// 企业标识
	@Max(value=9223372036854775807L,message="企业标识字段过长")
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
	 * 部门编码
	 */
	public String getOrgCode() {
		return this.orgCode;
	}

	/**
	 * 部门编码
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	/**
	 * 部门名称
	 */
	public String getOrgName() {
		return this.orgName;
	}

	/**
	 * 部门名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
	 * 部门权责描述
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 部门权责描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 部门第二负责人
	 */
	public String getSecondleader() {
		return this.secondleader;
	}

	/**
	 * 部门第二负责人
	 */
	public void setSecondleader(String secondleader) {
		this.secondleader = secondleader;
	}
	
	/**
	 * 部门负责人
	 */
	public String getLeader() {
		return this.leader;
	}

	/**
	 * 部门负责人
	 */
	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	/**
	 * 目标雇员数
	 */
	public Integer getHires() {
		return this.hires;
	}

	/**
	 * 目标雇员数
	 */
	public void setHires(Integer hires) {
		this.hires = hires;
	}
	
	/**
	 * 
	 */
	public String getOrgIdPath() {
		return this.orgIdPath;
	}

	/**
	 * 
	 */
	public void setOrgIdPath(String orgIdPath) {
		this.orgIdPath = orgIdPath;
	}
	
	/**
	 * 部门树
	 */
	public String getOrgPath() {
		return this.orgPath;
	}

	/**
	 * 部门树
	 */
	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
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
	 * 企业标识
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业标识
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
