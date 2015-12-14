package com.noah.manage.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.noah.manage.dao.domain.MUsers;
import com.noah.manage.dao.domain.MUsersExample;
import com.noah.manage.dao.domain.MUsersExample.Criteria;
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
		MUsersExample me = new MUsersExample();
		me.or().andIsDeleteEqualTo(0);
		return musersMapper.selectByExample(me);
	}
	
	public MUsers getByUsername(String userName){
		if(StringUtils.isEmpty(userName)){
			return null;
		}
		MUsersExample me = new MUsersExample();
		Criteria cr = me.createCriteria();
		cr.andIsDeleteEqualTo(0);
		cr.andUserNameEqualTo(userName);
		
		List<MUsers> list = musersMapper.selectByExample(me);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@Cacheable(value = "manage", key = "'getAuthUrlByUserId_'+#userId")
	public List<String> getAuthUrlByUserId(String userId){
		return musersMapper.getAuthUrlListByUserId(userId);
//		if(list==null || list.size()==0){
//			return "";
//		}
//		return StringUtils.join(list,",");
	}
}
