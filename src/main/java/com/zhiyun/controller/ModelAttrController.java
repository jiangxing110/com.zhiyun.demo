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
import com.zhiyun.entity.CmsModelAttr;
import com.zhiyun.service.CmsModelAttrService;

/**
 * 结构属性相关
 * 
 * @author 庄超
 * 
 */
@Controller
@RequestMapping(value = "/modelAttr", produces = "text/json;charset=UTF-8")
public class ModelAttrController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(ModelAttrController.class);

	@Resource
	private CmsModelAttrService cmsModelAttrService;
	
	/**
	 * 结构属性获取
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object get(HttpServletRequest req, HttpServletResponse resp, CmsModelAttr cmsModelAttr) {
		BaseResult<CmsModelAttr> baseResult = new BaseResult<CmsModelAttr>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsModelAttr = cmsModelAttrService.get(cmsModelAttr.getId());
			baseResult.setModel(cmsModelAttr);
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
	 * 结构属性查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object list(HttpServletRequest req, HttpServletResponse resp, CmsModelAttr cmsModelAttr) {
		BaseResult<List<CmsModelAttr>> baseResult = new BaseResult<List<CmsModelAttr>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<CmsModelAttr> CmsModelAttrs = cmsModelAttrService.find(cmsModelAttr);
			baseResult.setModel(CmsModelAttrs);
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
	 * 结构属性分页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/grid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object grid(HttpServletRequest req, HttpServletResponse resp, CmsModelAttr cmsModelAttr, Pager pager) {
		BaseResult<DataGrid<CmsModelAttr>> baseResult = new BaseResult<DataGrid<CmsModelAttr>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			Params params = Params.create().add("entity", cmsModelAttr);
			DataGrid<CmsModelAttr> dataGrid = cmsModelAttrService.page(params, pager);
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
	 * 结构属性新增
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object add(HttpServletRequest req, HttpServletResponse resp, CmsModelAttr cmsModelAttr) {
		BaseResult<CmsModelAttr> baseResult = new BaseResult<CmsModelAttr>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			CmsModelAttr entity = new CmsModelAttr();
			entity.setModelId(cmsModelAttr.getModelId());
			entity.setAlias(cmsModelAttr.getAlias());
			List<CmsModelAttr> warehouses = cmsModelAttrService.find(entity);
			if (!CommonUtils.isEmpty(warehouses)) {
				throw new BusinessException("结构属性名称已存在");
			}
			
			entity = new CmsModelAttr();
			entity.setModelId(cmsModelAttr.getModelId());
			entity.setRemark(cmsModelAttr.getRemark());
			warehouses = cmsModelAttrService.find(entity);
			if (!CommonUtils.isEmpty(warehouses)) {
				throw new BusinessException("结构属性标识已存在");
			}
			
			cmsModelAttrService.insert(cmsModelAttr);
			
			baseResult.setModel(cmsModelAttr);
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
	 * 结构属性编辑
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object edit(HttpServletRequest req, HttpServletResponse resp, CmsModelAttr cmsModelAttr) {
		BaseResult<CmsModelAttr> baseResult = new BaseResult<CmsModelAttr>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			CmsModelAttr entity = new CmsModelAttr();
			entity.setModelId(cmsModelAttr.getModelId());
			entity.setAlias(cmsModelAttr.getAlias());
			List<CmsModelAttr> warehouses = cmsModelAttrService.find(entity);
			if (!CommonUtils.isEmpty(warehouses) && !cmsModelAttr.getId().equals(warehouses.get(0).getId())) {
				throw new BusinessException("结构属性名称已存在");
			}
			
			entity = new CmsModelAttr();
			entity.setModelId(cmsModelAttr.getModelId());
			entity.setRemark(cmsModelAttr.getRemark());
			warehouses = cmsModelAttrService.find(entity);
			if (!CommonUtils.isEmpty(warehouses) && !cmsModelAttr.getId().equals(warehouses.get(0).getId())) {
				throw new BusinessException("结构属性标识已存在");
			}
			
			cmsModelAttrService.update(cmsModelAttr);
			baseResult.setModel(cmsModelAttr);
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
	 * 结构属性删除
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object del(@RequestParam("ids") Long[] ids) {
		BaseResult<List<CmsModelAttr>> baseResult = new BaseResult<List<CmsModelAttr>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			//TODO 删除子集，还要查询结构属性下是否有模型，有不能删
			for (Long id : ids) {
				cmsModelAttrService.delete(id);
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
	

}
