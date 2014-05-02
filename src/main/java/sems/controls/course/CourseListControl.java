package sems.controls.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sems.controls.PageController;
import sems.dao.CourseDao;
import sems.vo.CourseVo;
@Controller
@RequestMapping("/course")
public class CourseListControl{
  @Autowired 
	CourseDao courseDao;

  @RequestMapping("/list")
  public String execute(int pageNo, int pageSize,Model model) {
		try {
			List<CourseVo> list = courseDao.list(pageNo, pageSize);
			model.addAttribute("list", list);
			return "/course/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
  }

}













