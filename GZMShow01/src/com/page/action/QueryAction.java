package com.page.action;


import java.util.List;
import net.sf.json.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.page.bean.User;
import com.page.dao.PageControllor;
import com.page.service.IQueryService;
public class QueryAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9207565439169540894L;
	private IQueryService service;
	private PageControllor pageControl;
	private String name;
    private String action;
    String result;
	public QueryAction() {
		System.out.println("我被创建了");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public IQueryService getService() {
		return service;
	}
	public void setService(IQueryService service) {
		this.service = service;
	}
	public PageControllor getPageControl() {
		return pageControl;
	}
	public void setPageControl(PageControllor pageControl) {
		this.pageControl = pageControl;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(service);
		if(action!=null&&!action.equals("")){
		//根据指令参数设置查询页码
		switch (action) {
		case "pre":
			pageControl.setPageNo(pageControl.getPageNo()-1);
			break;
        case "next":
        	pageControl.setPageNo(pageControl.getPageNo()+1);
			break;
        case "last":
        	pageControl.setPageNo(pageControl.getMax_page());
	        break;
        case "first":
        	pageControl.setPageNo(1);
	        break;
		default:
			pageControl.setPageNo(Integer.parseInt(action));
			break;
		}
		}
//		查询记录
		List<User> query = service.queryOracle(name);
 //输出JSON数据
		if(query!=null){
		JSONArray fromObject = JSONArray.fromObject(query);
		result = fromObject.toString();
		System.out.println(result);
		}
		return SUCCESS;
	}
	
	
	
	

}
