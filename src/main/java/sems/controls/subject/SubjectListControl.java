package sems.controls.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;
@Controller
@RequestMapping("/subject")
public class SubjectListControl{
  @Autowired
	SubjectDao subjectDao;

  @RequestMapping("/list")
  public String execute(int pageNo, int pageSize, Model model) {
		try {
			List<SubjectVo> list = subjectDao.list(pageNo, pageSize);
			model.addAttribute("list", list);
			return "/subject/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
  }

}













