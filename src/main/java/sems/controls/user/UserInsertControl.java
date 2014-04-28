package sems.controls.user;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;

import sems.annotations.Component;
import sems.controls.PageController;
import sems.dao.UserDao;
import sems.vo.UserVo;
@Component("/user/insert.bit")
public class UserInsertControl implements PageController {
	UserDao userDao;
	ServletContext servletContext;
	String filePath;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	private void setPhotoFile(Map<String, Object> model) throws Exception{
		String fullPath = servletContext.getRealPath("/upload");
		FileItem item = (FileItem)model.get("photo");
		filePath = item.getName();

		if(filePath != ""){
		  File savedFile = new File(fullPath + "/" + item.getName());
      item.write(savedFile);
		}
	}

	@Override
	public String execute(Map<String, Object> model) {
		if (model.get("email") == null) {
			return "/user/form.jsp";

		} else {
			try {
				UserVo vo= new UserVo();
				setPhotoFile(model);
				vo.setEmail((String)model.get("email"));
				vo.setPasswd((String)model.get("passwd"));
				vo.setName((String)model.get("name"));
				vo.setTel((String)model.get("tel"));
				vo.setFax((String)model.get("fax"));
				vo.setPostno((String)model.get("postno"));
				vo.setAddress((String)model.get("address"));
				vo.setPhoto(filePath);
				userDao.insert(vo);
				return "/user/insert.jsp";

			} catch (Throwable ex) {
				throw new Error(ex);
			}
		}
	}
}




















