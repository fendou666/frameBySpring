package com.study.springmvc.bean;

public class MyException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MyException(String errInfo){
		super(errInfo);
	}
}