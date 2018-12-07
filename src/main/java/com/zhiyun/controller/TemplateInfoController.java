package com.zhiyun.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.util.CommonUtils;
import com.zhiyun.client.UserHolder;
import com.zhiyun.entity.CmsTemplateInfo;
import com.zhiyun.service.CmsTemplateInfoService;
import com.zhiyun.util.UrlContent;
import com.zhiyun.util.ZipUtil;

/**
 * 模板相关
 * 
 * @author 庄超
 * 
 */
@Controller
@RequestMapping(value = "/templateInfo", produces = "text/json;charset=UTF-8")
public class TemplateInfoController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(TemplateInfoController.class);

	@Resource
	private CmsTemplateInfoService cmsTemplateInfoService;
	
	/**
	 * 操作授权获取
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object get(HttpServletRequest req, HttpServletResponse resp, CmsTemplateInfo cmsTemplateInfo) {
		BaseResult<CmsTemplateInfo> baseResult = new BaseResult<CmsTemplateInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsTemplateInfo = cmsTemplateInfoService.get(cmsTemplateInfo.getId());
			baseResult.setModel(cmsTemplateInfo);
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
	 * 模板查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object list(HttpServletRequest req, HttpServletResponse resp, CmsTemplateInfo cmsTemplateInfo) {
		BaseResult<List<CmsTemplateInfo>> baseResult = new BaseResult<List<CmsTemplateInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<CmsTemplateInfo> CmsTemplateInfos = cmsTemplateInfoService.find(cmsTemplateInfo);
			baseResult.setModel(CmsTemplateInfos);
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
	 * 模板分页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/grid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object grid(HttpServletRequest req, HttpServletResponse resp, CmsTemplateInfo cmsTemplateInfo, Pager pager) {
		BaseResult<DataGrid<CmsTemplateInfo>> baseResult = new BaseResult<DataGrid<CmsTemplateInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			Params params = Params.create().add("entity", cmsTemplateInfo);
			DataGrid<CmsTemplateInfo> dataGrid = cmsTemplateInfoService.page(params, pager);
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
	 * 模板新增
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object add(HttpServletRequest req, HttpServletResponse resp, CmsTemplateInfo cmsTemplateInfo) {
		BaseResult<CmsTemplateInfo> baseResult = new BaseResult<CmsTemplateInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			CmsTemplateInfo entity = new CmsTemplateInfo();
			entity.setAlias(cmsTemplateInfo.getAlias());
			List<CmsTemplateInfo> warehouses = cmsTemplateInfoService.find(entity);
			if (!CommonUtils.isEmpty(warehouses)) {
				throw new BusinessException("模板名称已存在");
			}
			
			cmsTemplateInfo.setIsAble(false);
			cmsTemplateInfo.setAbleTime(new Date());
			cmsTemplateInfoService.insert(cmsTemplateInfo);
			
			baseResult.setModel(cmsTemplateInfo);
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
	 * 模板编辑
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object edit(HttpServletRequest req, HttpServletResponse resp, CmsTemplateInfo cmsTemplateInfo) {
		BaseResult<CmsTemplateInfo> baseResult = new BaseResult<CmsTemplateInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			CmsTemplateInfo entity = new CmsTemplateInfo();
			entity.setAlias(cmsTemplateInfo.getAlias());
			List<CmsTemplateInfo> warehouses = cmsTemplateInfoService.find(entity);
			if (!CommonUtils.isEmpty(warehouses) && !cmsTemplateInfo.getId().equals(warehouses.get(0).getId())) {
				throw new BusinessException("模板名称已存在");
			}
			cmsTemplateInfoService.update(cmsTemplateInfo);
			baseResult.setModel(cmsTemplateInfo);
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
	public Object able(HttpServletRequest req, HttpServletResponse resp, CmsTemplateInfo cmsTemplateInfo) {
		BaseResult<CmsTemplateInfo> baseResult = new BaseResult<CmsTemplateInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsTemplateInfo.setAbleTime(new Date());
			cmsTemplateInfoService.update(cmsTemplateInfo);
			baseResult.setModel(cmsTemplateInfo);
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
	 * 模板删除
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object del(@RequestParam("ids") Long[] ids) {
		BaseResult<List<CmsTemplateInfo>> baseResult = new BaseResult<List<CmsTemplateInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			//TODO 删除子集，还要查询模板下是否有模型，有不能删
			for (Long id : ids) {
				cmsTemplateInfoService.delete(id);
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
	
	@RequestMapping(value = "/upload", method = {RequestMethod.POST })
	@ResponseBody
	public Object upload(HttpServletResponse response, HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file)
			throws IOException {
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			String modelIdLong = request.getParameter("modelId");
			// 格式转换MultipartFile to File
			CommonsMultipartFile cf = (CommonsMultipartFile) file;
			DiskFileItem fi = (DiskFileItem) cf.getFileItem();
			File uploadFile = fi.getStoreLocation();
			
			if (uploadFile != null) {
				String tempPath = UserHolder.getId()+"/"+System.currentTimeMillis()+"/";
				String path =  UrlContent.local+tempPath;
				File saveFile = new File(path, file.getOriginalFilename());
				
				if (!saveFile.getParentFile().exists()) {
					saveFile.getParentFile().mkdirs();
				}
				//将上传文件保存到一个目标文件当中
				file.transferTo(new File(path + File.separator + file.getOriginalFilename()));
				
				CmsTemplateInfo temp = new CmsTemplateInfo();
				temp.setModelId(Long.valueOf(modelIdLong));
				List<CmsTemplateInfo> list = cmsTemplateInfoService.find(temp);
				for (CmsTemplateInfo cmsTemplateInfo : list) {
					cmsTemplateInfoService.delete(cmsTemplateInfo.getId());
				}
				
				CmsTemplateInfo cmsTemplateInfo = new CmsTemplateInfo();
				cmsTemplateInfo.setAlias("template");
				cmsTemplateInfo.setTemplatePath(UrlContent.web+tempPath);
				cmsTemplateInfo.setModelId(Long.valueOf(modelIdLong));
				cmsTemplateInfo.setIsAble(true);
				cmsTemplateInfo.setAbleTime(new Date());
				cmsTemplateInfoService.insert(cmsTemplateInfo);
				
				File zipFile = new File(path+file.getOriginalFilename());
				ZipUtil.unzip(zipFile, path);
				
				baseResult.setModel(path);
			}else {
				throw new BusinessException("上传内容为空");
			}
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
