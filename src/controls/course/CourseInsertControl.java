package controls.course;

import java.util.Map;

import annotations.Component;
import controls.PageController;
import vo.CourseVo;
import dao.CourseDao;
@Component("/course/insert.bit")
public class CourseInsertControl implements PageController {
	CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	@Override
	public String execute(Map<String, Object> model) {
		if (model.get("title") == null) {
			return "/course/form.jsp";
			
		} else {
			try {
				CourseVo vo = new CourseVo();
				vo.setTitle((String)model.get("title"));
				vo.setDescription((String)model.get("description"));
				vo.setHour(Integer.parseInt((String)model.get("hour")));
				courseDao.insert(vo);
				return "/course/insert.jsp";
				
			} catch (Throwable ex) {
				throw new Error(ex);
			}
		}
	}
}




















