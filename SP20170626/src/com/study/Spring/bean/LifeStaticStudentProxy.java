package com.study.Spring.bean;

public class LifeStaticStudentProxy {
	public LifeStaticStudentProxy(){
		System.out.println("����----���췽��LifeStaticStudentProxy");
	}
	
	public static Student getStudentInstance(){
		System.out.println("����----getStudentInstance");
		return new Student();
	}
	public  void initStudent(){
		System.out.println("�����Ѿ��������ˡ���������");
	}
//	public void initStudent(int aa){
//		System.out.println("����ǲ����ܴ����ģ���������");
//		System.out.println("��������ʱ�򴥷���init ������aa�ķ���");
//	}
	public  void destroySingletonStudent(){
		System.out.println("�����Ѿ��������ˡ���������");
	}
}	