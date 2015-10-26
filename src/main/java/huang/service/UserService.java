package huang.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import huang.idao.IUserDAO;

@Service
public class UserService implements IUserService {
    
    @Inject
    private IUserDAO userDAO ;

    public List<Map<String, Object>> findAllUser() {
        return userDAO.findAllUser();
    }

}