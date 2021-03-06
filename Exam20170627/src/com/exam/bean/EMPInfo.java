package com.exam.bean;

public class EMPInfo {
	private String  empNo;
	private String  empName;
	private double empSal;
	
	public EMPInfo() {
	}
	public EMPInfo(String empNo, String empName, double empSal) {
		this.empNo = empNo;
		this.empName = empName;
		this.empSal = empSal;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "EMPInfo [empNo=" + empNo + ", empName=" + empName + ", empSal="
				+ empSal + "]";
	}
}
