package sems.controls;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sems.dao.UserDao;
import sems.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserControl {
	static Logger log = Logger.getLogger(UserControl.class);
	static long fileCount;
	static String filename;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ServletContext servletContext;

	PhotoControl photoControl;
	
	public UserControl() {
		log.debug("UserControl 생성됨");
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
			
			List<UserVo> list = userDao.list(params);
			model.addAttribute("list", list);
			return "/user/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
  }
	
	@RequestMapping("/detail")
	public String detail(int no, Model model) {
		try {
			UserVo user = userDao.detail(no);
			model.addAttribute("user", user);
			return "/user/detail.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String inserForm() {
		return "/user/form.jsp";
	}
		
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(UserVo vo,
			@RequestParam("file") MultipartFile file) {
		try {
     setPhotoFile01(vo, file);
				userDao.insert(vo);
				return "/user/insert.jsp";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(int no, Model model){
		try {
			UserVo user = userDao.detail(no);
			model.addAttribute("user", user);
			return "/user/updateform.jsp";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(UserVo vo, Model model,
			@RequestParam("file") MultipartFile file) {
		try {
        setPhotoFile02(vo, file, model);
				userDao.update(vo);
				return "redirect:detail.bit?no=" + vo.getNo();
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String execute(int no) {
		try {
			userDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	private void setPhotoFile01(
			UserVo vo,
			MultipartFile file) throws Exception{
		String fullPath = servletContext.getRealPath("/upload");
		if (!file.isEmpty()) {
			String filename = 
					System.currentTimeMillis() + "_" + ++fileCount;
			File savedFile = new File(fullPath + "/" + filename);
			file.transferTo(savedFile); 
			vo.setPhotoPath(filename);
		}
	}
	
	private void setPhotoFile02(
			UserVo vo,
			MultipartFile file,
			Model model) throws Exception{
		String fullPath = servletContext.getRealPath("/upload");
		if (!file.isEmpty()) {
			String filename = 
					System.currentTimeMillis() + "_" + ++fileCount;
			File savedFile = new File(fullPath + "/" + filename);
			file.transferTo(savedFile); 
			
			model.addAttribute("photo", filename);
			vo.setPhotoPath(filename);
		}
	}
}
