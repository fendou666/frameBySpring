package com.study.Spring.bean;

public class LifeStaticStudentProxy {
	public LifeStaticStudentProxy(){
		System.out.println("工厂----构造方法LifeStaticStudentProxy");
	}
	
	public static Student getStudentInstance(){
		System.out.println("工厂----getStudentInstance");
		return new Student();
	}
	public  void initStudent(){
		System.out.println("工厂已经被创建了。。。。。");
	}
//	public void initStudent(int aa){
//		System.out.println("这个是不可能触发的！！！！！");
//		System.out.println("创建对象时候触发的init 带参数aa的方法");
//	}
	public  void destroySingletonStudent(){
		System.out.println("工厂已经被销毁了。。。。。");
	}
}	
