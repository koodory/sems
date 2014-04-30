package sems.controls.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sems.controls.PageController;
import sems.dao.UserDao;
import sems.vo.UserVo;
@Component("/user/detail.bit")
public class UserDetailControl implements PageController {
  @Autowired
	UserDao userDao;
	
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





















