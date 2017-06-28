package com.study.mvc.model.bean;

public class GenericPageInfo {
	private int pageSize;     //һҳ��ʾ���������
	private int currentPageNo;//��ǰҳ
	private int maxPageNumbers;//���з�����������ҳ��
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		if(currentPageNo<=1){
			this.currentPageNo=1;
		}
		else if(currentPageNo>=maxPageNumbers){
			this.currentPageNo=maxPageNumbers;
		}
		else{
			this.currentPageNo=currentPageNo;
		}
	}
	public int getMaxPageNumbers() {
		return maxPageNumbers;
	}
	public void setMaxPageNumbers(int maxPageNumbers) {
		this.maxPageNumbers = maxPageNumbers;
	}
	
}
