package com.xiongyu.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LogoutAction extends ActionSupport {
	
	/**登出功能
	 * @return
	 */
	public String logout(){
		//将session中存放的userId，userName字段移除
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.remove("userId");
		session.remove("userName");
		
		return "success";
	}
}
