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
public class CmsNewsInfo extends BaseEntity<Long> {

	private static final long serialVersionUID = 2520535059675435482L;

	// ~~~~实体属性
	// 结构主键
	@Max(value=9223372036854775807L,message="结构主键字段过长")
	private Long modelId;
	// 栏目主键
	@Max(value=9223372036854775807L,message="栏目主键字段过长")
	private Long channelId;
	// 路径
	@Pattern(regexp="[\\S]{0,255}", message="路径字段过长")
	private String url;
	// 状态
	@Pattern(regexp="[\\S]{0,255}", message="状态字段过长")
	private String status;
	// 标题
	@Pattern(regexp="[\\S]{0,255}", message="标题字段过长")
	private String title;
	// 公共属性
	private String publicAttrs;
	// 私有属性
	private String privateAttrs;
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
	 * 结构主键
	 */
	public Long getModelId() {
		return this.modelId;
	}

	/**
	 * 结构主键
	 */
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	
	/**
	 * 栏目主键
	 */
	public Long getChannelId() {
		return this.channelId;
	}

	/**
	 * 栏目主键
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	
	/**
	 * 路径
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * 路径
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 标题
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 公共属性
	 */
	public String getPublicAttrs() {
		return this.publicAttrs;
	}

	/**
	 * 公共属性
	 */
	public void setPublicAttrs(String publicAttrs) {
		this.publicAttrs = publicAttrs;
	}
	
	/**
	 * 私有属性
	 */
	public String getPrivateAttrs() {
		return this.privateAttrs;
	}

	/**
	 * 私有属性
	 */
	public void setPrivateAttrs(String privateAttrs) {
		this.privateAttrs = privateAttrs;
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
