package sems.controls.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sems.dao.UserDao;
import sems.vo.UserVo;
@Controller
@RequestMapping("/user")
public class UserDetailControl{
  @Autowired
	UserDao userDao;
	
  @RequestMapping("/detail")
	public String execute(int no, Model model) {
		try {
			UserVo user = userDao.detail(no);
			model.addAttribute("user", user);
			return "/user/detail.jsp";
	
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}





















