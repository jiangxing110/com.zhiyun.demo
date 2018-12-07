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
import com.zhiyun.dto.CmsModelInfoDto;
import com.zhiyun.entity.CmsModelAttr;
import com.zhiyun.entity.CmsModelInfo;
import com.zhiyun.service.CmsModelAttrService;
import com.zhiyun.service.CmsModelInfoService;

/**
 * 结构相关
 * 
 * @author 庄超
 * 
 */
@Controller
@RequestMapping(value = "/modelInfo", produces = "text/json;charset=UTF-8")
public class ModelInfoController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(ModelInfoController.class);

	@Resource
	private CmsModelInfoService cmsModelInfoService;
	@Resource
	private CmsModelAttrService cmsModelAttrService;
	
	/**
	 * 结构获取
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object get(HttpServletRequest req, HttpServletResponse resp, CmsModelInfo cmsModelInfo) {
		BaseResult<CmsModelInfo> baseResult = new BaseResult<CmsModelInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsModelInfo = cmsModelInfoService.get(cmsModelInfo.getId());
			baseResult.setModel(cmsModelInfo);
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
	 * 结构查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object list(HttpServletRequest req, HttpServletResponse resp, CmsModelInfo cmsModelInfo) {
		BaseResult<List<CmsModelInfo>> baseResult = new BaseResult<List<CmsModelInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<CmsModelInfo> CmsModelInfos = cmsModelInfoService.find(cmsModelInfo);
			baseResult.setModel(CmsModelInfos);
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
	 * 结构分页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/grid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object grid(HttpServletRequest req, HttpServletResponse resp, CmsModelInfo cmsModelInfo, Pager pager) {
		BaseResult<DataGrid<CmsModelInfo>> baseResult = new BaseResult<DataGrid<CmsModelInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			Params params = Params.create().add("entity", cmsModelInfo);
			DataGrid<CmsModelInfo> dataGrid = cmsModelInfoService.page(params, pager);
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
	 * 结构新增
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object add(HttpServletRequest req, HttpServletResponse resp, CmsModelInfo cmsModelInfo) {
		BaseResult<CmsModelInfo> baseResult = new BaseResult<CmsModelInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			CmsModelInfo entity = new CmsModelInfo();
			entity.setAlias(cmsModelInfo.getAlias());
			List<CmsModelInfo> warehouses = cmsModelInfoService.find(entity);
			if (!CommonUtils.isEmpty(warehouses)) {
				throw new BusinessException("结构名称已存在");
			}
			
			cmsModelInfo.setIsAble(false);
			cmsModelInfo.setAbleTime(new Date());
			cmsModelInfo = cmsModelInfoService.insert(cmsModelInfo);
			
			int orders = 0;
			
			CmsModelAttr cmsModelAttr = new CmsModelAttr();
			cmsModelAttr.setAttrType("public");
			cmsModelAttr.setModelId(cmsModelInfo.getId());
			cmsModelAttr.setDataType("String");
			cmsModelAttr.setOrders(orders++);
			cmsModelAttr.setId(null);
			cmsModelAttr.setAlias("栏目");
			cmsModelAttr.setRemark("column");
			cmsModelAttrService.insert(cmsModelAttr);
			
			cmsModelAttr.setOrders(orders++);
			cmsModelAttr.setId(null);
			cmsModelAttr.setAlias("作者");
			cmsModelAttr.setRemark("author");
			cmsModelAttrService.insert(cmsModelAttr);
			
			cmsModelAttr.setOrders(orders++);
			cmsModelAttr.setId(null);
			cmsModelAttr.setAlias("标题");
			cmsModelAttr.setRemark("title");
			cmsModelAttrService.insert(cmsModelAttr);
			
			cmsModelAttr.setOrders(orders++);
			cmsModelAttr.setId(null);
			cmsModelAttr.setAlias("正文");
			cmsModelAttr.setRemark("body");
			cmsModelAttrService.insert(cmsModelAttr);
			
			cmsModelAttr.setOrders(orders++);
			cmsModelAttr.setId(null);
			cmsModelAttr.setAlias("关键字");
			cmsModelAttr.setRemark("keyword");
			cmsModelAttrService.insert(cmsModelAttr);
			
			cmsModelAttr.setOrders(orders++);
			cmsModelAttr.setId(null);
			cmsModelAttr.setAlias("来源");
			cmsModelAttr.setRemark("src");
			cmsModelAttrService.insert(cmsModelAttr);
			
			cmsModelAttr.setOrders(orders++);
			cmsModelAttr.setId(null);
			cmsModelAttr.setAlias("发布时间");
			cmsModelAttr.setDataType("date");
			cmsModelAttr.setRemark("releaseTime");
			cmsModelAttrService.insert(cmsModelAttr);
			
			cmsModelAttr.setOrders(orders++);
			cmsModelAttr.setId(null);
			cmsModelAttr.setAlias("失效时间");
			cmsModelAttr.setDataType("date");
			cmsModelAttr.setRemark("failureTime");
			cmsModelAttrService.insert(cmsModelAttr);
			
			baseResult.setModel(cmsModelInfo);
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
	 * 结构编辑
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object edit(HttpServletRequest req, HttpServletResponse resp, CmsModelInfo cmsModelInfo) {
		BaseResult<CmsModelInfo> baseResult = new BaseResult<CmsModelInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			CmsModelInfo entity = new CmsModelInfo();
			entity.setAlias(cmsModelInfo.getAlias());
			List<CmsModelInfo> warehouses = cmsModelInfoService.find(entity);
			if (!CommonUtils.isEmpty(warehouses) && !cmsModelInfo.getId().equals(warehouses.get(0).getId())) {
				throw new BusinessException("结构名称已存在");
			}
			
			cmsModelInfoService.update(cmsModelInfo);
			baseResult.setModel(cmsModelInfo);
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
	
	@ResponseBody
	@RequestMapping(value = "/able", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object able(HttpServletRequest req, HttpServletResponse resp, CmsModelInfo modelInfo) {
		BaseResult<CmsModelInfo> baseResult = new BaseResult<CmsModelInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			modelInfo.setAbleTime(new Date());
			cmsModelInfoService.update(modelInfo);
			baseResult.setModel(modelInfo);
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
	 * 结构删除
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object del(@RequestParam("ids") Long[] ids) {
		BaseResult<List<CmsModelInfo>> baseResult = new BaseResult<List<CmsModelInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			//TODO 删除子集，还要查询结构下是否有模型，有不能删
			for (Long id : ids) {
				CmsModelInfo cmsModelInfo = cmsModelInfoService.get(id);
				
				CmsModelAttr entity = new CmsModelAttr();
				entity.setModelId(cmsModelInfo.getId());
				List<CmsModelAttr> list = cmsModelAttrService.find(entity);
				if (!CommonUtils.isEmpty(list)) {
					throw new BusinessException("结构下还存在属性,不能删除");
				}
				
				cmsModelInfoService.delete(id);
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
	 * 结构查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listWithTemplate", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object listWithTemplate(HttpServletRequest req, HttpServletResponse resp, CmsModelInfo cmsModelInfo) {
		BaseResult<List<CmsModelInfoDto>> baseResult = new BaseResult<List<CmsModelInfoDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<CmsModelInfoDto> CmsModelInfos = cmsModelInfoService.findWithTemplate(cmsModelInfo);
			baseResult.setModel(CmsModelInfos);
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
