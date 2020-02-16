package saveInterface;

import java.util.List;

import com.userpojo.Test;

public interface IUserDaoInterface {

	public void saveUser(Test test);
	public List<Test> loginUser (String email,String password);
	public List<Test> userList();
	public int deleteUser(String id);
}
