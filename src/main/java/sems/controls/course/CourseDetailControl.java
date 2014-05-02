package sems.controls.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sems.dao.CourseDao;
import sems.vo.CourseVo;
@Controller
@RequestMapping("/course")
public class CourseDetailControl{
  @Autowired
	CourseDao courseDao;
	
  @RequestMapping("/detail")
	public String execute(int no, Model model) {
		try {
			CourseVo course = courseDao.detail(no);
			model.addAttribute("course", course);
			return "/course/detail.jsp";
	
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}





















