package sems.controls.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sems.controls.PageController;
import sems.dao.UserDao;
@Component("/user/delete.bit")
public class UserDeleteControl implements PageController {
  @Autowired
	UserDao userDao;
	
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
















