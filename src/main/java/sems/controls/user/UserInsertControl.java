package sems.controls.user;

import java.io.File;

import javax.servlet.ServletContext;

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
public class UserInsertControl{
	static long fileCount;
	static String filename;
	@Autowired
	UserDao userDao;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String inserForm() {
		return "/user/form.jsp";
	}
	
	private void setPhotoFile(
			UserVo vo,
			MultipartFile file) throws Exception{
		String fullPath = servletContext.getRealPath("/upload");
		if (!file.isEmpty()) {
			String filename = 
					System.currentTimeMillis() + "_" + ++fileCount;
			File savedFile = new File(fullPath + "/" + filename);
			file.transferTo(savedFile); 
			vo.setPhoto(filename);
		}
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String update(UserVo vo,
			@RequestParam("file") MultipartFile file) {
		try {
       setPhotoFile(vo, file);
				userDao.insert(vo);
				return "/user/insert.jsp";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}




















