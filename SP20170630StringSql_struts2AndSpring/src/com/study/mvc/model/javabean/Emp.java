package com.study.mvc.model.javabean;

public class Emp {
	private int empNo;
	private String eName;
	
	public Emp() {
	}
	
	public Emp(int empNo, String eName) {
		this.empNo = empNo;
		this.eName = eName;
	}


	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", eName=" + eName + "]";
	}
	
}
