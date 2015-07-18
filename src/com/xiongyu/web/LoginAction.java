package com.xiongyu.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xiongyu.model.User;
import com.xiongyu.service.UserService;
import com.xiongyu.utils.AppException;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private User user;

	/**用户登录功能
	 * @return
	 */
	public String login() {
		if (user == null) {
			return "success";
		}
		UserService userService = new UserService();
		try {
			int userId = userService.login(user);
			if (userId > 0) {// 登陆成功
				int role = userService.getUserRole(userId);
				
				//登录后，将userId，userName字段存放在Session中
				Map<String,Object> session = ActionContext.getContext().getSession();
				session.put("userId", userId);
				session.put("userName", user.getName());
				
				if(role==0)//
					return "success0";
				if(role==1)//
					return "success1";
				else {
					return "fail";
				}
			} else {
				return "fail";
			}
		} catch (AppException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}