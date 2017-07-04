package com.page.bean;

public class User {
	private String name;
	private String pwd;
	private int status;
	private String QQ;
	private String time;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User(String name, String pwd, int status, String qQ, String time) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.status = status;
		QQ = qQ;
		this.time = time;
	}




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((QQ == null) ? 0 : QQ.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + status;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (QQ == null) {
			if (other.QQ != null)
				return false;
		} else if (!QQ.equals(other.QQ))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (status != other.status)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + ", status=" + status
				+ ", QQ=" + QQ + ", time=" + time + "]";
	}
	
	
	

}
