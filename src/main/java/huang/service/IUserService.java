package huang.service;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public List<Map<String, Object>> findAllUser() ;
    public int addUser(String userNo,String passwd);
}