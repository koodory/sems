package sems.controls.course;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sems.controls.PageController;
import sems.dao.CourseDao;
import sems.vo.CourseVo;
@Component("/course/insert.bit")
public class CourseInsertControl implements PageController {
  @Autowired
	CourseDao courseDao;
	
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




















