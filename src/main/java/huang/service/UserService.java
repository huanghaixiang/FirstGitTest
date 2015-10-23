package huang.service;

import java.util.List;

import javax.annotation.Resource;

import org.elasticsearch.common.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import huang.idao.IUserDAO;
import huang.model.UserDo;

@Service
public class UserService implements IUserService {
    
    @Inject
    private IUserDAO userDAO ;

    public List<UserDo> findAllUser() {
        return userDAO.findAllUser();
    }

}