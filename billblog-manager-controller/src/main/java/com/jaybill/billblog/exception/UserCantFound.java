package com.jaybill.billblog.exception;

public class UserCantFound extends RuntimeException {

	private static final long serialVersionUID = -7424942335907916953L;
	public UserCantFound(String msg){
		super(msg);
	}
}
