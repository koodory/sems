package sems.controls.subject;

import java.util.Map;

import sems.annotations.Component;
import sems.controls.PageController;
import sems.dao.SubjectDao;
import sems.vo.SubjectVo;
@Component("/subject/update.bit")
public class SubjectUpdateControl implements PageController {
	SubjectDao subjectDao;

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	@Override
	public String execute(Map<String, Object> model) {
		try {
			if (model.get("title") == null) { // 변경폼 출
				int no = Integer.parseInt((String)model.get("no"));
				SubjectVo subject = subjectDao.detail(no);
				model.put("subject", subject);
				return "/subject/updateform.jsp";
	
			} else { // 변경 수행
					SubjectVo vo = new SubjectVo();
					vo.setNo(Integer.parseInt((String)model.get("no")));
					vo.setTitle((String)model.get("title"));
					vo.setDescription((String)model.get("description"));
					subjectDao.update(vo);
					return "redirect:detail.bit?no=" + vo.getNo();
			}
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}
	
	













	
	
	
	
	
	
