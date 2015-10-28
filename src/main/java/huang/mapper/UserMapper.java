package huang.mapper;

import java.util.List;
import java.util.Map;
import huang.model.UserBean;
 
public interface UserMapper {

	UserBean selectByPrimaryKey(Integer bankId);

	int updateByPrimaryKeySelective(UserBean record);
	
	int countByParams(Map<Object, Object> params);
	
	List<UserBean> findByParams(Map<Object, Object> params);
	
	int insertSelective(UserBean record);
}