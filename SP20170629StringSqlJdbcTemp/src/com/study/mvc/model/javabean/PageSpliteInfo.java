package com.study.mvc.model.javabean;

public class PageSpliteInfo {
	private int pageMaxRows;
	private int allRecodeNum;
	private int PageMaxIndex;
	private int currentPageIndex;
	
	public int getPageMaxRows() {
		return pageMaxRows;
	}
	public void setPageMaxRows(int pageMaxRows) {
		this.pageMaxRows = pageMaxRows;
	}
	public int getAllRecodeNum() {
		return allRecodeNum;
	}
	public void setAllRecodeNum(int allRecodeNum) {
		this.allRecodeNum = allRecodeNum;
	}
	public int getPageMaxIndex() {
		return PageMaxIndex;
	}
	public void setPageMaxIndex(int pageMaxIndex) {
		PageMaxIndex = pageMaxIndex;
	}
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	public void initPageMaxIndex(){
		if(allRecodeNum%pageMaxRows!=0){
			PageMaxIndex = allRecodeNum/pageMaxRows + 1;
		}else{
			PageMaxIndex = allRecodeNum/pageMaxRows;
		}
	}
	
	public void setCurrentPageIndex(int currentPageIndex) {
		if(currentPageIndex<1){
			currentPageIndex = 1;
		}else if(currentPageIndex>PageMaxIndex){
			currentPageIndex = PageMaxIndex;
		}else{
			this.currentPageIndex = currentPageIndex;
		}
	}
	
	
}
