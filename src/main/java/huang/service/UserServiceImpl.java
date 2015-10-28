package huang.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import huang.idao.IUserDAO;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    
    @Inject
    private IUserDAO userDAO ;

    public List<Map<String, Object>> findAllUser() {
        return userDAO.findAllUser();
    }

	public int addUser(String userNo, String passwd) {
		// TODO Auto-generated method stub
		return userDAO.addUser(userNo, passwd);
	}

}