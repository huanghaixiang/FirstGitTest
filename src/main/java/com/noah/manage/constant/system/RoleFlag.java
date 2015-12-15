package com.noah.manage.constant.system;

public enum RoleFlag {
	
	ADMIN("admin","管理员"),
	DEFAULE("default","默认权限");
	
	
	private String flag;
	private RoleFlag(String flag,String name){
		this.flag = flag;
	}
	public String getValue(){
		return flag;
	}
	
}
