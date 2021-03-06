package com.exam.bean;

public class PageInfo {
	private int pageMaxRows;
	private int currentPage;
	private int pageMaxIndex;
	private int allRows;
	public int getPageMaxRows() {
		return pageMaxRows;
	}
	public void setPageMaxRows(int pageMaxRows) {
		this.pageMaxRows = pageMaxRows;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageMaxIndex() {
		return pageMaxIndex;
	}
	public void setPageMaxIndex(int pageMaxIndex) {
		this.pageMaxIndex = pageMaxIndex;
	}
	public int getAllRows() {
		return allRows;
	}
	public void setAllRows(int allRows) {
		this.allRows = allRows;
	}
	public void setPageMaxIndexByAllRows() {
		if(allRows%pageMaxRows == 0){
			this.pageMaxIndex = allRows/pageMaxRows;
		}else{
			this.pageMaxIndex = allRows/pageMaxRows+ 1;
		}
	}
	public int getFirst(){
		this.currentPage = 1;
		return currentPage;
	}
	
	public int getLast(){
		this.currentPage = pageMaxIndex;
		return currentPage;
	}
	public int getPre(){
		currentPage --; 
		if(currentPage<1){
			currentPage = 1;
		}
		return currentPage;
	}
	public int getNext(){
		currentPage ++; 
		if(currentPage>pageMaxIndex){
			currentPage = pageMaxIndex;
		}
		return currentPage;
	}
}
