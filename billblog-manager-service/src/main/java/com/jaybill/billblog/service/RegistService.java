package com.jaybill.billblog.service;

/**
 * 注册接口
 * @author jaybill
 *
 */
public interface RegistService {
	
	/**
	 * 传入账号、密码，添加用户
	 * @param userAccount
	 * @param userPassword
	 */
	long addUser(String userAccount,String userPassword);
	/**
	 * 判断账号是否存在
	 * @param userAccount
	 * @return
	 */
	boolean isAccountExisted(String userAccount);
}
