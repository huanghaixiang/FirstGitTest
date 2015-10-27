package huang.idao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImp implements IUserDAO{
	
	@Inject private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> findAllUser() {
		return jdbcTemplate.queryForList(" SELECT USER_ID id,USER_NO userno,PASSWORD password FROM M_USERS ");
	}

	public int addUser(String userNo,String passwd) {
		return jdbcTemplate.update(" INSERT INTO M_USERS(USER_NO,PASSWORD) VALUES(?,?) ",userNo,passwd);
	}
	
}
