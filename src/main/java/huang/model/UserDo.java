package huang.model;

import java.io.Serializable;

public class UserDo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id ;
    private String userno ;
    private String password ;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}