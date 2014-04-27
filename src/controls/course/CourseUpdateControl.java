package controls.course;

import java.util.Map;

import annotations.Component;
import controls.PageController;
import vo.CourseVo;
import dao.CourseDao;
@Component("/course/update.bit")
public class CourseUpdateControl implements PageController {
	CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public String execute(Map<String, Object> model) {
		try {
			if (model.get("title") == null) { // 변경폼 출력
				int no = Integer.parseInt((String)model.get("no"));
				CourseVo course = courseDao.detail(no);
				model.put("course", course);
				return "/course/updateform.jsp";
	
			} else { // 변경 수행
					CourseVo vo = new CourseVo();
					vo.setNo(Integer.parseInt((String)model.get("no")));
					vo.setTitle((String)model.get("title"));
					vo.setDescription((String)model.get("description"));
					vo.setHour(Integer.parseInt((String)model.get("hour")));
					courseDao.update(vo);
					return "redirect:detail.bit?no=" + vo.getNo();
			}
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}
	
	













	
	
	
	
	
	
