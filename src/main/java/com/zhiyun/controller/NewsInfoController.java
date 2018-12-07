package com.zhiyun.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import com.zhiyun.base.util.StringUtil;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.CmsNewsInfoDto;
import com.zhiyun.entity.CmsNewsInfo;
import com.zhiyun.entity.CmsTemplateInfo;
import com.zhiyun.service.CasRoleService;
import com.zhiyun.service.CmsNewsInfoService;
import com.zhiyun.service.CmsTemplateInfoService;
import com.zhiyun.util.AppendToFile;
import com.zhiyun.util.ReadFromFile;
import com.zhiyun.util.UrlContent;

/**
 * 新闻相关
 * 
 * @author 庄超
 * 
 */
@Controller
@RequestMapping(value = "/newsInfo", produces = "text/json;charset=UTF-8")
public class NewsInfoController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(NewsInfoController.class);

	@Resource
	private CmsNewsInfoService cmsNewsInfoService;
	@Resource
	private CmsTemplateInfoService cmsTemplateInfoService;
	@Resource
	private CasRoleService casRoleService;
	
	/**
	 * 新闻获取
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object get(HttpServletRequest req, HttpServletResponse resp, CmsNewsInfo cmsNewsInfo) {
		BaseResult<CmsNewsInfo> baseResult = new BaseResult<CmsNewsInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsNewsInfo = cmsNewsInfoService.get(cmsNewsInfo.getId());
			baseResult.setModel(cmsNewsInfo);
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
	 * 新闻查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object list(HttpServletRequest req, HttpServletResponse resp, CmsNewsInfo cmsNewsInfo) {
		BaseResult<List<CmsNewsInfo>> baseResult = new BaseResult<List<CmsNewsInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<CmsNewsInfo> CmsNewsInfos = cmsNewsInfoService.find(cmsNewsInfo);
			baseResult.setModel(CmsNewsInfos);
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
	 * 新闻分页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/grid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object grid(HttpServletRequest req, HttpServletResponse resp, CmsNewsInfo cmsNewsInfo, Pager pager) {
		BaseResult<DataGrid<CmsNewsInfo>> baseResult = new BaseResult<DataGrid<CmsNewsInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			Params params = Params.create().add("entity", cmsNewsInfo);
			DataGrid<CmsNewsInfo> dataGrid = cmsNewsInfoService.page(params, pager);
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
	 * 新闻新增
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object add(HttpServletRequest req, HttpServletResponse resp, CmsNewsInfo cmsNewsInfo) {
		BaseResult<CmsNewsInfo> baseResult = new BaseResult<CmsNewsInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			CmsTemplateInfo cmsTemplateInfo = new CmsTemplateInfo();
			cmsTemplateInfo.setModelId(cmsNewsInfo.getModelId());
			List<CmsTemplateInfo> list = cmsTemplateInfoService.find(cmsTemplateInfo);
			if (CommonUtils.isEmpty(list) || list.size()>1) {
				throw new BusinessException("请先上传信息结构模板");
			}
			if (cmsNewsInfo.getId() != null && ("draft".equals(cmsNewsInfo.getStatus())||"reject".equals(cmsNewsInfo.getStatus()))) {
				throw new BusinessException("已提交/审核成功的信息不能变更");
			}
			
			String path = list.get(0).getTemplatePath();
			path = UrlContent.local + path.substring(UrlContent.web.length());
			String temp = ReadFromFile.readFileByLines(path+"index.txt");
			
			Map<String, String> pubMap = JSON.parseObject(cmsNewsInfo.getPublicAttrs(), Map.class);
			Map<String, String> priMap = JSON.parseObject(cmsNewsInfo.getPrivateAttrs(), Map.class);
			
			pubMap.putAll(priMap);
			//模板替换
			for (String key : pubMap.keySet()) {
				temp = temp.replaceAll("\\$\\{" + String.valueOf(key) + "!}", String.valueOf(pubMap.get(key)));
			}
			temp = temp.replaceAll("\\$.*?}", ""); 
			//删除文件
			File file=new File(path+"index.html");
			if(file.exists()&&file.isFile())
				file.delete();
			//生产文件
			AppendToFile.write(path+"index.html",temp);
			
//			cmsNewsInfo.setStatus("draft");
			cmsNewsInfo.setUrl(list.get(0).getTemplatePath()+"index.html");
			if (cmsNewsInfo.getId() == null) {
				cmsNewsInfoService.insert(cmsNewsInfo);
			}else {
				cmsNewsInfoService.update(cmsNewsInfo);
			}
			
			baseResult.setModel(cmsNewsInfo);
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
	 * 新闻编辑
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object edit(HttpServletRequest req, HttpServletResponse resp, CmsNewsInfo cmsNewsInfo) {
		BaseResult<CmsNewsInfo> baseResult = new BaseResult<CmsNewsInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			cmsNewsInfoService.update(cmsNewsInfo);
			baseResult.setModel(cmsNewsInfo);
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
	 * 新闻删除
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object del(@RequestParam("ids") Long[] ids) {
		BaseResult<List<CmsNewsInfo>> baseResult = new BaseResult<List<CmsNewsInfo>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			//TODO 删除子集，还要查询新闻下是否有模型，有不能删
			for (Long id : ids) {
				cmsNewsInfoService.delete(id);
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
	 * 操作
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/operate", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object operate(HttpServletRequest req, HttpServletResponse resp, CmsNewsInfo cmsNewsInfo, String ids) {
		BaseResult<CmsNewsInfo> baseResult = new BaseResult<CmsNewsInfo>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			if (StringUtil.isNotBlank(ids)) {
				String[] idStrs = ids.split(",");
				for (String string : idStrs) {
					cmsNewsInfo.setId(Long.valueOf(string));
					CmsNewsInfo temp = cmsNewsInfoService.get(Long.valueOf(string));
					if ("issue".equals(cmsNewsInfo.getStatus())) {
						//同意发布
						if (!"wait".equals(temp.getStatus())) {
							throw new BusinessException("提交状态的信息才能审核");
						}
					}else if ("reject".equals(cmsNewsInfo.getStatus())) {
						//拒绝驳回
						if (!"wait".equals(temp.getStatus())) {
							throw new BusinessException("提交状态的信息才能驳回");
						}
					}else if ("wait".equals(cmsNewsInfo.getStatus())) {
						//提交审核
						if (!"draft".equals(temp.getStatus()) && !"reject".equals(temp.getStatus())) {
							throw new BusinessException("草稿/驳回状态的信息才能提交");
						}
					}
					
					cmsNewsInfoService.update(cmsNewsInfo);
				}
			}else {
				CmsNewsInfo temp = cmsNewsInfoService.get(cmsNewsInfo.getId());
				if ("issue".equals(cmsNewsInfo.getStatus())) {
					//同意发布
					if (!"wait".equals(temp.getStatus())) {
						throw new BusinessException("提交状态的信息才能审核");
					}
				}else if ("reject".equals(cmsNewsInfo.getStatus())) {
					//拒绝驳回
					if (!"wait".equals(temp.getStatus())) {
						throw new BusinessException("提交状态的信息才能驳回");
					}
				}else if ("wait".equals(cmsNewsInfo.getStatus())) {
					//提交审核
					if (!"draft".equals(temp.getStatus()) && !"reject".equals(temp.getStatus())) {
						throw new BusinessException("草稿/驳回状态的信息才能提交");
					}
				}
				cmsNewsInfoService.update(cmsNewsInfo);
			}
			baseResult.setModel(cmsNewsInfo);
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
	 * 新闻分页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/gridWithChannel", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object gridWithChannel(HttpServletRequest req, HttpServletResponse resp, CmsNewsInfoDto cmsNewsInfoDto, Pager pager) {
		BaseResult<DataGrid<CmsNewsInfoDto>> baseResult = new BaseResult<DataGrid<CmsNewsInfoDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			Params params = Params.create().add("entity", cmsNewsInfoDto);
			if (StringUtil.isNotBlank(cmsNewsInfoDto.getReleaseTime())) {
				String[] times =  cmsNewsInfoDto.getReleaseTime().split(",");
				if (times.length>1) {
					cmsNewsInfoDto.setStartTime(times[0]);
					cmsNewsInfoDto.setEndTime(times[1]);
				}
			}
			if (StringUtil.isNotBlank(cmsNewsInfoDto.getStatus())) {
				String[] statuss =  cmsNewsInfoDto.getStatus().split(",");
				if (statuss.length>0) {
					params.add("list", statuss);
				}
			}
			
			DataGrid<CmsNewsInfoDto> dataGrid = cmsNewsInfoService.pageWithChannel(pager, params);
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
				String fn = UserHolder.getId()+"/";
				String path = UrlContent.local+fn;
				File saveFile = new File(path, file.getOriginalFilename());
				
				if (!saveFile.getParentFile().exists()) {
					saveFile.getParentFile().mkdirs();
				}
				
				String tm = System.currentTimeMillis()+".png";
				//将上传文件保存到一个目标文件当中
				file.transferTo(new File(path + tm));
				
				baseResult.setModel(UrlContent.web+fn + tm);
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
	
	@RequestMapping(value = "/format", method = {RequestMethod.POST })
	@ResponseBody
	public Object format(HttpServletResponse response, HttpServletRequest request, String content)
			throws IOException {
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
		    // <p>段落替换为换行 
		    content = content.replaceAll("<p .*?>", " "); 
		    // <br><br/>替换为换行 
		    content = content.replaceAll("<br\\s*/?>", " "); 
		    // 去掉其它的<>之间的东西 
		    content = content.replaceAll("\\<.*?>", ""); 
		    // 去掉空格 
		    content = content.replaceAll(" ", "");
		    if (StringUtil.isNotBlank(content) && content.length()>200) {
		    	content = content.substring(0, 200)+"...";
			}
		 baseResult.setModel(content);
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
