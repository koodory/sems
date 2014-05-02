package sems.controls.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;
@Controller
@RequestMapping("/subject")
public class SubjectDetailControl{
  @Autowired
	SubjectDao subjectDao;
	
  @RequestMapping("/detail")
	public String detail(int no, Model model) {
		try {
			SubjectVo subject = subjectDao.detail(no);
			model.addAttribute("subject", subject);
			return "/subject/detail.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}





















