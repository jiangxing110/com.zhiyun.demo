package com.zhiyun.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zhiyun.base.config.Config;
import com.zhiyun.base.util.CommonUtils;
import com.zhiyun.client.UserHolder;
import com.zhiyun.context.OnlineUser;
import com.zhiyun.context.RequestHolder;
import com.zhiyun.entity.CasCompany;
import com.zhiyun.entity.CasUser;
import com.zhiyun.internal.server.auth.service.InterfaceForUser;
import com.zhiyun.service.CasCompanyService;
import com.zhiyun.service.CasUserService;

/**
 * 请求拦截。<br>
 * @author 庄超
 */
public class RequestContextInterceptor extends HandlerInterceptorAdapter implements InitializingBean {


	@Resource
	private Config config;
	@Resource
	private CasUserService casUserService;
	@Resource
	private CasCompanyService casCompanyService;
	@Resource
	private InterfaceForUser interfaceForUser;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		RequestHolder.init();
		OnlineUser user = (OnlineUser) request.getSession().getAttribute("user");
		//判断是否调试模式
		if (config.getIsDev()) {
			//调试模式使用默认账户
			user = new OnlineUser();
			user.setCompanyId(234411L);
			user.setCompanyName("测试企业");
			user.setUserName("test");
			user.setId(1L);
		}else {
			if (user == null) {
				response.setHeader("Content-type", "application/json;charset=UTF-8");  
				response.getWriter().write("{\"errorMsg\":\"没有访问权限,请先登录账号\"}");
				return false;
			}
			UserHolder.clear();
			//通过登录账号查询用户信息
			CasUser casUser = new CasUser();
			casUser.setAccount(user.getAccountName());
			List<CasUser> casUsers = casUserService.find(casUser);
			if (!CommonUtils.isEmpty(casUsers) && casUsers.size()==1) {
				
				Boolean res = false;
				try {
					res = interfaceForUser.getIsAble(casUsers.get(0).getId(), "mes", "1");
				} catch (Exception e) {
					response.setHeader("Content-type", "application/json;charset=UTF-8");  
					response.getWriter().write("{\"errorMsg\":\"授权中心异常,请稍后再试\"}");
					return false;
				}
				if (!res) {
					response.setHeader("Content-type", "application/json;charset=UTF-8");  
					response.getWriter().write("{\"errorMsg\":\"没有权限\"}");
					return false;
                }
				
				//设置用户信息
				CasUser entity = casUsers.get(0);
				user.setCompanyId(entity.getCompanyId());
				user.setOrgId(entity.getOrgId());
				user.setUserName(entity.getName());
				user.setId(entity.getId());
				user.setIp(request.getRemoteAddr());
				//设置企业名称
				CasCompany casCompany = casCompanyService.get(entity.getCompanyId());
				user.setCompanyName(casCompany.getCompanyName());
				
				request.getSession().setAttribute("user", user);
			}else {
				response.setHeader("Content-type", "application/json;charset=UTF-8");  
				response.getWriter().write("{\"errorMsg\":\"账号信息不匹配,请重新登录\"}");
				return false;
			}
				
		}
		UserHolder.setUser(user);
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

}
