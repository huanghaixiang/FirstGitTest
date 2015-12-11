package com.noah.manage.model;

import java.io.Serializable;

import io.searchbox.annotations.JestId;

public class UserBean implements Serializable {

    /**
	 * 人员信息bean
	 */
	private static final long serialVersionUID = 1L;
	@JestId
	private int id ;
    private String userno ;
    private String password ;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}