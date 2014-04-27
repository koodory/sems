package controls.course;

import java.util.Map;

import annotations.Component;
import controls.PageController;
import vo.CourseVo;
import dao.CourseDao;
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





















