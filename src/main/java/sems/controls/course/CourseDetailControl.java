package sems.controls.course;

import java.util.Map;

import sems.annotations.Component;
import sems.controls.PageController;
import sems.dao.CourseDao;
import sems.vo.CourseVo;
@Component("/course/detail.bit")
public class CourseDetailControl implements PageController {
	CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	@Override
	public String execute(Map<String, Object> model) {
		try {
			int no = Integer.parseInt((String)model.get("no")); 
			CourseVo course = courseDao.detail(no);
			model.put("course", course);
			return "/course/detail.jsp";
	
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}





















