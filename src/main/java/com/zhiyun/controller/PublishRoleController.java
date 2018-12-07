package com.zhiyun.controller;

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
import com.zhiyun.entity.CasRole;
import com.zhiyun.entity.CmsPublishRole;
import com.zhiyun.service.CasRoleService;
import com.zhiyun.service.CmsPublishRoleService;

/**
 * 授权相关
 * 
 * @author 庄超
 * 
 */
@Controller
@RequestMapping(value = "/publishRole", produces = "text/json;charset=UTF-8")
public class PublishRoleController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(PublishRoleController.class);

	@Resource
	private CmsPublishRoleService cmsPublishRoleService;
	@Resource
	private CasRoleService casRoleService;
	
	/**
	 * 授权获取
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object get(HttpServletRequest req, HttpServletResponse resp, CmsPublishRole cmsPublishRole) {
		BaseResult<CmsPublishRole> baseResult = new BaseResult<CmsPublishRole>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsPublishRole = cmsPublishRoleService.get(cmsPublishRole.getId());
			baseResult.setModel(cmsPublishRole);
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
	 * 授权查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object list(HttpServletRequest req, HttpServletResponse resp, CmsPublishRole cmsPublishRole) {
		BaseResult<List<CmsPublishRole>> baseResult = new BaseResult<List<CmsPublishRole>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<CmsPublishRole> CmsPublishRoles = cmsPublishRoleService.find(cmsPublishRole);
			baseResult.setModel(CmsPublishRoles);
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
	 * 授权分页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/grid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object grid(HttpServletRequest req, HttpServletResponse resp, CmsPublishRole cmsPublishRole, Pager pager) {
		BaseResult<DataGrid<CmsPublishRole>> baseResult = new BaseResult<DataGrid<CmsPublishRole>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			Params params = Params.create().add("entity", cmsPublishRole);
			DataGrid<CmsPublishRole> dataGrid = cmsPublishRoleService.page(params, pager);
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
	 * 授权新增
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object add(HttpServletRequest req, HttpServletResponse resp, CmsPublishRole cmsPublishRole) {
		BaseResult<CmsPublishRole> baseResult = new BaseResult<CmsPublishRole>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			if (cmsPublishRole.getId() == null ) {
				CmsPublishRole role = new CmsPublishRole();
				role.setChannelId(cmsPublishRole.getChannelId());
				role.setRoleId(cmsPublishRole.getRoleId());
				List<CmsPublishRole> list = cmsPublishRoleService.find(role);
				if (!CommonUtils.isEmpty(list)) {
					cmsPublishRole.setId(list.get(0).getId());
					cmsPublishRoleService.update(cmsPublishRole);
				}else {
					cmsPublishRoleService.insert(cmsPublishRole);
				}
			}else {
				cmsPublishRoleService.update(cmsPublishRole);
			}
			baseResult.setModel(cmsPublishRole);
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
	 * 授权编辑
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object edit(HttpServletRequest req, HttpServletResponse resp, CmsPublishRole cmsPublishRole) {
		BaseResult<CmsPublishRole> baseResult = new BaseResult<CmsPublishRole>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsPublishRoleService.update(cmsPublishRole);
			baseResult.setModel(cmsPublishRole);
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
	 * 授权删除
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object del(@RequestParam("ids") Long[] ids) {
		BaseResult<List<CmsPublishRole>> baseResult = new BaseResult<List<CmsPublishRole>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			//TODO 删除子集，还要查询授权下是否有模型，有不能删
			for (Long id : ids) {
				cmsPublishRoleService.delete(id);
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
	 * 角色查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listRole", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object listRole(HttpServletRequest req, HttpServletResponse resp, CasRole casRole) {
		BaseResult<List<CasRole>> baseResult = new BaseResult<List<CasRole>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<CasRole> roles = casRoleService.find(casRole);
			baseResult.setModel(roles);
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
