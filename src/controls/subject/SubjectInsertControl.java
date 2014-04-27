package controls.subject;

import java.util.Map;

import annotations.Component;
import controls.PageController;
import vo.SubjectVo;
import dao.SubjectDao;
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




















