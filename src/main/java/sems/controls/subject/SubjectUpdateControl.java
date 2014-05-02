package sems.controls.subject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;
@Controller
@RequestMapping("/subject")
public class SubjectUpdateControl{
	SubjectDao subjectDao;

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(int no,Model model){
		try {
			SubjectVo subject = subjectDao.detail(no);
			model.addAttribute("subject", subject);
			return "/subject/updateform.jsp";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(SubjectVo vo, Model model){
		try{
			subjectDao.update(vo);
			return "redirect:detail.bit?no=" + vo.getNo();
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}













