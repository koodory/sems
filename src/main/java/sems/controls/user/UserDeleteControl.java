package sems.controls.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sems.dao.UserDao;
@Controller
@RequestMapping("/user")
public class UserDeleteControl{
  @Autowired
	UserDao userDao;
	
  @RequestMapping("/delete")
	public String detail(int no) {
		try {
			userDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}
















