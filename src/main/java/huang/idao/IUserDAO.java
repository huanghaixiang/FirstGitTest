package huang.idao;

import java.util.List;
import java.util.Map;
 
public interface IUserDAO {

    public List<Map<String, Object>> findAllUser() ;
    
    public int addUser(String userNo,String passwd);
}