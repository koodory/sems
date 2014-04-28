package sems.controls.user;

import java.util.Map;

import sems.annotations.Component;
import sems.controls.PageController;
import sems.dao.UserDao;
@Component("/user/delete.bit")
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
















