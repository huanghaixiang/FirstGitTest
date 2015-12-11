package com.noah.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noah.manage.dao.domain.MUsers;
import com.noah.manage.dao.domain.MUsersExample;
import com.noah.manage.dao.mapper.MUsersMapper;

@Service
public class UserService {

 	@Autowired 
	private MUsersMapper musersMapper;
	
	/**
	 * 获取所有的用户信息
	 * @return
	 */
	public List<MUsers> getAllUsers(){
		
		return musersMapper.selectByExample(new MUsersExample());
	}
}
