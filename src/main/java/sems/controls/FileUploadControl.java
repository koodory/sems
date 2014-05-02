package sems.controls;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sems.vo.FileVo;
@Controller
@RequestMapping("/file")
public class FileUploadControl{
	static long fileCount;

	@Autowired
	ServletContext servletContext;

	@RequestMapping("/upload")
	private String setPhotoFile(
			String name,
			@RequestParam("file") MultipartFile file,
			Model model){
		try{
			String fullPath = servletContext.getRealPath("/upload");
			if(!file.isEmpty()){
				String filename =
						System.currentTimeMillis()+"_" + ++fileCount;
				File savedFile = new File(fullPath + "/" + filename);
				file.transferTo(savedFile);

				model.addAttribute("name",name);
				model.addAttribute("filename",filename);
			}
			return "/file/uploadResult.jsp";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}





