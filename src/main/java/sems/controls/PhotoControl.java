package sems.controls;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import sems.dao.UserDao;
import sems.vo.UserVo;

public class PhotoControl {
	static long fileCount;
	static String filename;
	
//	@Autowired
//	UserDao userDao;
	
//	@Autowired
	ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public PhotoControl(UserVo vo,MultipartFile file) 
			throws Exception{
		setFile(vo,file);
	}
	
	public PhotoControl(UserVo vo, MultipartFile file, Model model) 
			throws Exception{
		setFile(vo,file);
		model.addAttribute("photo", filename);
	}
	
	public void setFile(UserVo vo, MultipartFile file) throws Exception{
		String fullPath = servletContext.getRealPath("/upload");
		if (!file.isEmpty()) {
			String filename = 
					System.currentTimeMillis() + "_" + ++fileCount;
			File savedFile = new File(fullPath + "/" + filename);
			file.transferTo(savedFile); 
			vo.setPhotoPath(filename);
		}
	}
}
