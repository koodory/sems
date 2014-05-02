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
public class CourseInsertControl{
	@Autowired
	CourseDao courseDao;

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertForm(int no, Model model) {
		return "/course/form.jsp";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(CourseVo vo){
		try {
			courseDao.insert(vo);
			return "/course/insert.jsp";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}





















