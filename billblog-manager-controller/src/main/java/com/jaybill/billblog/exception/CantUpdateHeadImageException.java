package com.jaybill.billblog.exception;

/**
 * 上传头像失败
 * @author jaybill
 *
 */
public class CantUpdateHeadImageException  extends RuntimeException{

	private static final long serialVersionUID = -5762283424519159606L;

	public CantUpdateHeadImageException(String msg){
		super(msg);
	}
}
