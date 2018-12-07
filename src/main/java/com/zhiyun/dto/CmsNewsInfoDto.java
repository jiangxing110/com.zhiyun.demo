/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dto;

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
public class CmsNewsInfoDto extends BaseEntity<Long> {

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
	private String alias;
	private String releaseTime;
	private String failureTime;
	private String author;
	private String startTime;
	private String endTime;
	private String keyWord;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getFailureTime() {
		return failureTime;
	}

	public void setFailureTime(String failureTime) {
		this.failureTime = failureTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	
}
