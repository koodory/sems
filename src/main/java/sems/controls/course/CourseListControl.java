package sems.controls.course;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sems.controls.PageController;
import sems.dao.CourseDao;
import sems.vo.CourseVo;
@Component("/course/list.bit")
public class CourseListControl implements PageController {
  @Autowired 
	CourseDao courseDao;

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













