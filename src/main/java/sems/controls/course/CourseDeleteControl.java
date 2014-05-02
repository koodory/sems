package sems.controls.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sems.dao.CourseDao;
@Controller
@RequestMapping("/course")
public class CourseDeleteControl{
  @Autowired
	CourseDao courseDao;
	
  @RequestMapping("/delete")
	public String delete(int no) {
		try {
			courseDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}
















