package sems.controls.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sems.dao.CourseDao;
import sems.vo.CourseVo;
@Controller
@RequestMapping("/course")
public class CourseUpdateControl{
	@Autowired
	CourseDao courseDao;

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(int no, Model model) {
		try {
			CourseVo course = courseDao.detail(no);
			model.addAttribute("course", course);
			return "/course/updateform.jsp";
		}catch (Throwable ex) {
			throw new Error(ex);
		} 
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(CourseVo vo, Model model) {
		try{
			courseDao.update(vo);
			return "redirect:detail.bit?no=" + vo.getNo();
		}catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}
