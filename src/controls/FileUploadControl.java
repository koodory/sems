package controls;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;

import annotations.Component;
import vo.FileVo;
@Component("/file/upload.bit")
public class FileUploadControl implements PageController {
	ServletContext servletContext;
	String filePath;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	private void setPhotoFile(Map<String, Object> model) throws Exception{
		String fullPath = servletContext.getRealPath("/upload");
		FileItem item = (FileItem)model.get("file1");
		filePath = item.getName();

		if(filePath != ""){
		  File savedFile = new File(fullPath + "/" + item.getName());
      item.write(savedFile);
		}
	}

	@Override
	public String execute(Map<String, Object> model) {
		try {
			FileVo file = new FileVo();
			setPhotoFile(model);
			if(filePath !=""){
				file.setFilename(filePath);
			}
			return "/file/uploadResult.jsp";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}





