package com.chinasofti.test.action;

import com.opensymphony.xwork2.ActionSupport;

public class JsonAndJspAction  extends ActionSupport{

	private String returnSign;
	private String result;
	
	public String getReturnSign() {
		return returnSign;
	}

	public void setReturnSign(String returnSign) {
		this.returnSign = returnSign;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("returnSign " + returnSign);
		if(returnSign.equals("input")){
			result= "{\"result:\":\"input\"}";
			result= "[{\"result:\":\"input1\"}, {\"result:\":\"input2\"}, {\"result:\":\"input3\"}]";
			System.out.println("进入input");
			//return SUCCESS;
			return LOGIN;
		}
		if(returnSign.equals("login")){
			System.out.println("进入LOGIN");
			result= "{\"result:\":\"LOGIN\"}";
			result= "[{\"result:\":\"LOGIN1\"}, {\"result:\":\"LOGIN2\"}, {\"result:\":\"LOGIN3\"}]";
			return LOGIN;
		}
		if(returnSign.equals("error")){
			System.out.println("进入ERROR");
			result= "{\"result:\":\"ERROR\"}";
			result= "[{\"result:\":\"ERROR1\"}, {\"result:\":\"ERROR2\"}, {\"result:\":\"ERROR3\"}]";
			return ERROR;
		}
		System.out.println("进入success");
		result= "{\"result:\":\"SUCCESS\"}";
		result= "[{\"result:\":\"SUCCESS1\"}, {\"result:\":\"SUCCESS2\"}, {\"result:\":\"SUCCESS3\"}]";
		return SUCCESS;
	}
}
