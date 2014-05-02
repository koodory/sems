package sems.controls.user;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
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
public class UserUpdateControl{
	static long fileCount;
	static String filename;
	@Autowired
	UserDao userDao;

	@Autowired
	ServletContext servletContext;

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
	
	private void setPhotoFile(
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
			vo.setPhoto(filename);
		}
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(UserVo vo, Model model,
			@RequestParam("file") MultipartFile file) {
		try {
       setPhotoFile(vo, file, model);
				userDao.update(vo);
				return "redirect:detail.bit?no=" + vo.getNo();
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}





















