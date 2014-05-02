package sems.controls.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sems.controls.PageController;
import sems.dao.UserDao;
import sems.vo.UserVo;
@Controller
@RequestMapping("/user")
public class UserListControl{
  @Autowired
	UserDao userDao;

  @RequestMapping("/list")
  public String execute(int pageNo, int pageSize, Model model) {
		try {
			List<UserVo> list = userDao.list(pageNo, pageSize);
			model.addAttribute("list", list);
			return "/user/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
  }

}













