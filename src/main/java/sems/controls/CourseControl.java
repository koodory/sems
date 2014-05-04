package sems.controls;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.dao.CourseDao;
import sems.vo.CourseVo;

@Controller
@RequestMapping("/course")
public class CourseControl {
	static Logger log = Logger.getLogger(CourseControl.class);

	@Autowired
	CourseDao courseDao;

	public CourseControl() {
		log.debug("CourseControl 생성됨");
	}
	
	@RequestMapping("/list")
  public String list(
  		@RequestParam(value="pageNo",defaultValue="1") int pageNo, 
  		@RequestParam(value="pageSize",defaultValue="10") int pageSize, 
  		Model model) {
		try {
			HashMap<String,Integer> params = new HashMap<String,Integer>();
			params.put("startIndex", (pageNo - 1) * pageSize);
			params.put("pageSize", pageSize);
			
			List<CourseVo> list = courseDao.list(params);
			model.addAttribute("list", list);
			return "/course/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
  }
	
	@RequestMapping("/detail")
	public String detail(int no, Model model) {
		try {
			CourseVo course = courseDao.detail(no);
			model.addAttribute("course", course);
			return "/course/detail.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String form() {
			return "/course/form.jsp";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(CourseVo vo) {
			try {
				courseDao.insert(vo);
				return "/course/insert.jsp";
			} catch (Throwable ex) {
				throw new Error(ex);
			}
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(int no, Model model) {
		try {
			CourseVo course = courseDao.detail(no);
			model.addAttribute("course", course);
			return "/course/updateform.jsp";
	
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(CourseVo vo, Model model) {
		try {
				courseDao.update(vo);
				return "redirect:detail.bit?no=" + vo.getNo();
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String execute(int no) {
		try {
			courseDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}

