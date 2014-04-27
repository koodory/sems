package controls.course;

import java.util.Map;

import controls.PageController;
import dao.CourseDao;

public class CourseDeleteControl implements PageController {
	CourseDao courseDao;


	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	@Override
	public String execute(Map<String, Object> model) {
		try {
			int no = Integer.parseInt((String)model.get("no"));
			courseDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}
















