package sems.controls.subject;

import java.util.Map;

import sems.annotations.Component;
import sems.controls.PageController;
import sems.dao.SubjectDao;
@Component("/subject/delete.bit")
public class SubjectDeleteControl implements PageController {
	SubjectDao subjectDao;


	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	@Override
	public String execute(Map<String, Object> model) {
		try {
			int no = Integer.parseInt((String)model.get("no"));
			subjectDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}
















