package com.page.dao;

public class PageControllor {
     private int max_page=0; //最大页码
     private int max_cap=8;   //每页最大显示记录数量
     private int count=5;     //总记录数
     private int pageNo=1;    //当前页码
	 
	 
	

	public PageControllor() {
		System.out.println("Page被创建");
	}

	public int getMax_cap() {
		return max_cap;
	}

	public void setMax_cap(int max_cap) {
		this.max_cap = max_cap;
	}
	
	public void setMax_page(int max_page) {
		this.max_page = max_page;
	}

	//获取最大页码
	public int getMax_page() {
		return max_page;
	}

     //获取当前页码
	public  int getPageNo() {
		return pageNo;
	}

   //设置当前页码
	public  void setPageNo(int pageNo) {
		if(pageNo<=1){
			this.pageNo =1;
		}else if(pageNo>=max_page){
			this.pageNo =max_page;
		}else{
			this.pageNo =pageNo;
		}
	}

    //获取记录总数
	public  int getCount() {
		return count;
	}

    //设置记录总数
	public void setCount(int count) {
		this.count = count;
	}

    //更新最大页码
	public void updateMax_page() {
		if(count%max_cap==0){
		    max_page=count/max_cap;
		}else{
			max_page=count/max_cap+1;
		}
	}

	

	
	
	
}
