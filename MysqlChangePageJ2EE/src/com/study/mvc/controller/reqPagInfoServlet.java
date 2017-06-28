package com.study.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.mvc.model.bean.GenericPageInfo;
import com.study.mvc.model.bean.StudentInfo;
import com.study.mvc.model.service.StudentServiceImp;

/**
 * Servlet implementation class reqPagInfoServlet
 */
@WebServlet("/reqPagInfoServlet")
public class reqPagInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reqPagInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ͨ������ȥ���־����ҳ������
		String action=request.getParameter("action");
		//Ĭ����ҳ
		StudentServiceImp bean = ac.getBean("stuService", StudentServiceImp.class);
		GenericPageInfo gPageInfo=ac.getBean("pageInfo", GenericPageInfo.class);
		
		//������ѯ�����Ĵ���
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		
		Map<String, String> map=null;
		if(id!=null||name!=null){
			map=new HashMap<String, String>();
			if(id!=null&&!id.equals("")){
				map.put("id", id);
			}
			if(name!=null&&!name.equals("")){
				map.put("name", name);
			}
		}
		
		List<StudentInfo> findStudents =null;
		//��ȷ�����ҳ��
		int maxPageNumbers = bean.getMaxPageNumbers(map);
		//�����������ҳ������
		System.out.println("11111111111111111111111");
		request.setAttribute("maxPages", maxPageNumbers);
		
		if(action!=null&&maxPageNumbers>0){
			//���ͻ���ҳ�湦������ת����ҳ�������
			switch (action) {
				case "first": //��ҳ
					System.out.println("22222222");
					gPageInfo.setCurrentPageNo(1);	
					System.out.println("33333");		
					break;
				case "pre": //ǰҳ
					gPageInfo.setCurrentPageNo(gPageInfo.getCurrentPageNo()-1);
					break;
				case "nxt": //��ҳ
					gPageInfo.setCurrentPageNo(gPageInfo.getCurrentPageNo()+1);
					break;
				case "end": //βҳ
					gPageInfo.setCurrentPageNo(gPageInfo.getMaxPageNumbers());
					break;
				default:
					//ָ��ҳ
					gPageInfo.setCurrentPageNo(Integer.parseInt(action));
					break;
			}
			System.out.println("4444");	
			findStudents = bean.findStudents(map);
			System.out.println("5555");	
			//�����������Json
			JSONArray fromObject = JSONArray.fromObject(findStudents);
			response.getWriter().write(fromObject.toString());
			System.out.println("6666");	
		}
	}
}
