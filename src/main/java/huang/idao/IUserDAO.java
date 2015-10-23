package huang.idao;

import java.util.List;

import org.springframework.stereotype.Repository;

import huang.model.UserDo;
 
public interface IUserDAO {

    public List<UserDo> findAllUser() ;
}