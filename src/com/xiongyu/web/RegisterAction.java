package com.xiongyu.web;

import com.opensymphony.xwork2.ActionSupport;
import com.xiongyu.model.User;
import com.xiongyu.service.UserService;
import com.xiongyu.utils.AppException;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**注册功能
	 * @return
	 */
	public String regist() {
		if(user==null){
			return "usccess";
		}
		UserService userService = new UserService();
		try {
			if (userService.register(user)) {
				return "success";
			} else {
				return "fail";
			}
		} catch (AppException e) {
			e.printStackTrace();
			return "fail";
		}
	}
}