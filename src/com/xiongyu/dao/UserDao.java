package com.xiongyu.dao;

import com.xiongyu.model.User;
import com.xiongyu.utils.AppException;
public interface UserDao {
	/**
	 * 查询指定用户的用户是否存在
	 * @param name 用户名
	 * @return 用户名存在返回true 否则返回false
	 * @throws AppException 异常处理
	 */
	public boolean isExit(String name) throws AppException;

	/**
	 * 保存用户注册信息
	 * @param user 用户对象
	 * @return true表示保存成功，false表示保存失败
	 * @throws AppException 异常处理
	 */
	public boolean add(User user) throws AppException;

	/**
	 * 用户登录方法
	 * @param name 登陆名
	 * @param password 登陆密码
	 * @return 登陆用户ID
	 * @throws AppException
	 */
	public int login(String name, String password) throws AppException;

	/**
	 * 根据ID获取角色
	 * @param userId 用户Id
	 * @return 返回角色类型
	 */
	public int getRoleById(int userId)throws AppException;
}