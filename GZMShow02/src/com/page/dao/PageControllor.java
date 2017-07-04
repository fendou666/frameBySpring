package com.page.dao;

public class PageControllor {
     private int max_page=0; //���ҳ��
     private int max_cap=8;   //ÿҳ�����ʾ��¼����
     private int count=5;     //�ܼ�¼��
     private int pageNo=1;    //��ǰҳ��
	 
	 
	

	public PageControllor() {
		System.out.println("Page������");
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

	//��ȡ���ҳ��
	public int getMax_page() {
		return max_page;
	}

     //��ȡ��ǰҳ��
	public  int getPageNo() {
		return pageNo;
	}

   //���õ�ǰҳ��
	public  void setPageNo(int pageNo) {
		if(pageNo<=1){
			this.pageNo =1;
		}else if(pageNo>=max_page){
			this.pageNo =max_page;
		}else{
			this.pageNo =pageNo;
		}
	}

    //��ȡ��¼����
	public  int getCount() {
		return count;
	}

    //���ü�¼����
	public void setCount(int count) {
		this.count = count;
	}

    //�������ҳ��
	public void updateMax_page() {
		if(count%max_cap==0){
		    max_page=count/max_cap;
		}else{
			max_page=count/max_cap+1;
		}
	}

	

	
	
	
}
