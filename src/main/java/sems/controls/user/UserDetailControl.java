package sems.controls.user;

import java.util.Map;

import sems.annotations.Component;
import sems.controls.PageController;
import sems.dao.UserDao;
import sems.vo.UserVo;
@Component("/user/detail.bit")
public class UserDetailControl implements PageController {
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public String execute(Map<String, Object> model) {
		try {
			int no = Integer.parseInt((String)model.get("no")); 
			UserVo user = userDao.detail(no);
			model.put("user", user);
			return "/user/detail.jsp";
	
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}





















