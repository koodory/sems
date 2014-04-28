package sems.controls.course;

import java.util.List;
import java.util.Map;

import sems.annotations.Component;
import sems.controls.PageController;
import sems.dao.CourseDao;
import sems.vo.CourseVo;
@Component("/course/list.bit")
public class CourseListControl implements PageController {
	CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
  public String execute(Map<String, Object> model) {
		try {
			int pageNo = Integer.parseInt((String)model.get("pageNo")); 
			int pageSize = Integer.parseInt((String)model.get("pageSize")); 
			List<CourseVo> list = courseDao.list(pageNo, pageSize);
			model.put("list", list);
			return "/course/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
  }

}













