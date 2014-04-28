package sems.controls.subject;

import java.util.Map;

import sems.annotations.Component;
import sems.controls.PageController;
import sems.dao.SubjectDao;
import sems.vo.SubjectVo;
@Component("/subject/insert.bit")
public class SubjectInsertControl implements PageController {
	SubjectDao subjectDao;

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	@Override
	public String execute(Map<String, Object> model) {
		if (model.get("title") == null) {
			return "/subject/form.jsp";
			
		} else {
			try {
				SubjectVo vo = new SubjectVo();
				vo.setTitle((String)model.get("title"));
				vo.setDescription((String)model.get("description"));
				subjectDao.insert(vo);
				return "/subject/insert.jsp";
				
			} catch (Throwable ex) {
				throw new Error(ex);
			}
		}
	}
}




















