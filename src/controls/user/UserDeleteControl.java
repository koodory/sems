package controls.user;

import java.util.Map;

import controls.PageController;
import dao.UserDao;

public class UserDeleteControl implements PageController {
	UserDao userDao;


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public String execute(Map<String, Object> model) {
		try {
			int no = Integer.parseInt((String)model.get("no"));
			userDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}
















