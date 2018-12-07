package com.zhiyun.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.util.CommonUtils;
import com.zhiyun.dto.CmsChannelInfoDto;
import com.zhiyun.entity.CmsChannelInfo;
import com.zhiyun.service.CmsChannelInfoService;

/**
 * 栏目相关
 * 
 * @author 庄超
 * 
 */
@Controller
@RequestMapping(value = "/channelInfo", produces = "text/json;charset=UTF-8")
public class ChannelInfoController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(ChannelInfoController.class);

	@Resource
	private CmsChannelInfoService cmsChannelInfoService;
	
	/**
	 * 栏目获取
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object get(HttpServletRequest req, HttpServletResponse resp, CmsChannelInfo cmsChannelInfo) {
		BaseResult<CmsChannelInfo> baseResult = new BaseResult<CmsChannelInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsChannelInfo = cmsChannelInfoService.get(cmsChannelInfo.getId());
			baseResult.setModel(cmsChannelInfo);
		} catch (BusinessException be) {
			logger.debug("业务异常" + be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常" + e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
	
	/**
	 * 栏目查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object list(HttpServletRequest req, HttpServletResponse resp, CmsChannelInfo cmsChannelInfo) {
		BaseResult<List<CmsChannelInfo>> baseResult = new BaseResult<List<CmsChannelInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<CmsChannelInfo> CmsChannelInfos = cmsChannelInfoService.findLike(cmsChannelInfo);
			baseResult.setModel(CmsChannelInfos);
		} catch (BusinessException be) {
			logger.debug("业务异常" + be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常" + e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
	
	/**
	 * 栏目分页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/grid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object grid(HttpServletRequest req, HttpServletResponse resp, CmsChannelInfo cmsChannelInfo, Pager pager) {
		BaseResult<DataGrid<CmsChannelInfo>> baseResult = new BaseResult<DataGrid<CmsChannelInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			Params params = Params.create().add("entity", cmsChannelInfo);
			DataGrid<CmsChannelInfo> dataGrid = cmsChannelInfoService.page(params, pager);
			baseResult.setModel(dataGrid);
		} catch (BusinessException be) {
			logger.debug("业务异常" + be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常" + e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
	
	/**
	 * 栏目新增
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object add(HttpServletRequest req, HttpServletResponse resp, CmsChannelInfo cmsChannelInfo) {
		BaseResult<CmsChannelInfo> baseResult = new BaseResult<CmsChannelInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			CmsChannelInfo entity = new CmsChannelInfo();
			entity.setAlias(cmsChannelInfo.getAlias());
			List<CmsChannelInfo> warehouses = cmsChannelInfoService.find(entity);
			if (!CommonUtils.isEmpty(warehouses)) {
				throw new BusinessException("栏目名称已存在");
			}
			
			//TODO 加事务
			cmsChannelInfo.setIsLeaf(true);
			cmsChannelInfo.setIsAble(false);
			cmsChannelInfo.setAbleTime(new Date());
			cmsChannelInfoService.insert(cmsChannelInfo);
			
			if (cmsChannelInfo.getParentId() != 0) {
				//更新父节点为非叶节点
				CmsChannelInfo parent = new CmsChannelInfo();
				parent.setId(cmsChannelInfo.getParentId());
				List<CmsChannelInfo> list = cmsChannelInfoService.find(parent);
				if (CommonUtils.isEmpty(list)) {
					throw new BusinessException("父节点不存在");
				}
				parent = list.get(0);
				parent.setIsLeaf(false);
				cmsChannelInfoService.update(parent);
			}
			baseResult.setModel(cmsChannelInfo);
		} catch (BusinessException be) {
			logger.debug("业务异常" + be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常" + e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
	
	/**
	 * 栏目编辑
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object edit(HttpServletRequest req, HttpServletResponse resp, CmsChannelInfo cmsChannelInfo) {
		BaseResult<CmsChannelInfo> baseResult = new BaseResult<CmsChannelInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			CmsChannelInfo entity = new CmsChannelInfo();
			entity.setAlias(cmsChannelInfo.getAlias());
			List<CmsChannelInfo> warehouses = cmsChannelInfoService.find(entity);
			if (!CommonUtils.isEmpty(warehouses) && !cmsChannelInfo.getId().equals(warehouses.get(0).getId())) {
				throw new BusinessException("栏目名称已存在");
			}
			
			cmsChannelInfoService.update(cmsChannelInfo);
			baseResult.setModel(cmsChannelInfo);
		} catch (BusinessException be) {
			logger.debug("业务异常" + be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常" + e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
	
	/**
	 * 栏目启用
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/able", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object able(HttpServletRequest req, HttpServletResponse resp, CmsChannelInfo cmsChannelInfo) {
		BaseResult<CmsChannelInfo> baseResult = new BaseResult<CmsChannelInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsChannelInfo.setAbleTime(new Date());
			cmsChannelInfoService.update(cmsChannelInfo);
			baseResult.setModel(cmsChannelInfo);
		} catch (BusinessException be) {
			logger.debug("业务异常" + be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常" + e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
	
	/**
	 * 栏目删除
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object del(@RequestParam("ids") Long[] ids) {
		BaseResult<List<CmsChannelInfo>> baseResult = new BaseResult<List<CmsChannelInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			//TODO 删除子集，还要查询栏目下是否有模型，有不能删
			for (Long id : ids) {
				CmsChannelInfo cmsChannelInfo = cmsChannelInfoService.get(id);
				if (!cmsChannelInfo.getIsLeaf()) {
					throw new BusinessException("栏目下还存在其他栏目，无法删除");
				}
				
				CmsChannelInfo temp = new CmsChannelInfo();
				temp.setParentId(cmsChannelInfo.getParentId());
				List<CmsChannelInfo> warehouses = cmsChannelInfoService.find(temp);
				if (cmsChannelInfo.getParentId() != 0 && warehouses.size() == 1) {
					temp = cmsChannelInfoService.get(cmsChannelInfo.getParentId());
					temp.setIsLeaf(true);
					cmsChannelInfoService.update(temp);
					
				}
				
				cmsChannelInfoService.delete(id);
			}
			baseResult.setModel(null);
		} catch (BusinessException be) {
			logger.debug("业务异常" + be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常" + e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
	
	/**
	 * 栏目启用
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findWithAuth", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object findWithAuth(HttpServletRequest req, HttpServletResponse resp, CmsChannelInfoDto cmsChannelInfoDto) {
		BaseResult<List<CmsChannelInfoDto>> baseResult = new BaseResult<List<CmsChannelInfoDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<CmsChannelInfoDto> list = cmsChannelInfoService.findWithAuth(cmsChannelInfoDto);
			baseResult.setModel(list);
		} catch (BusinessException be) {
			logger.debug("业务异常" + be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常" + e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
}
