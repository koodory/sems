package sems.controls.subject;

import java.util.List;
import java.util.Map;

import sems.annotations.Component;
import sems.controls.PageController;
import sems.dao.SubjectDao;
import sems.vo.SubjectVo;
@Component("/subject/list.bit")
public class SubjectListControl implements PageController {
	SubjectDao subjectDao;

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	@Override
  public String execute(Map<String, Object> model) {
		try {
			int pageNo = Integer.parseInt((String)model.get("pageNo")); 
			int pageSize = Integer.parseInt((String)model.get("pageSize")); 
			List<SubjectVo> list = subjectDao.list(pageNo, pageSize);
			model.put("list", list);
			return "/subject/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
  }

}













