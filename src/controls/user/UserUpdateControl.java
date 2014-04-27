package controls.user;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;

import annotations.Component;
import controls.PageController;
import vo.UserVo;
import dao.UserDao;
@Component("/user/update.bit")
public class UserUpdateControl implements PageController {
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
		try {
			if (model.get("email") == null) { // 변경폼 출력
				int no = Integer.parseInt((String)model.get("no"));
				UserVo user = userDao.detail(no);
				model.put("user", user);
				return "/user/updateform.jsp";

			} else { // 변경 수행
				UserVo vo = new UserVo();
				setPhotoFile(model);
				vo.setNo(Integer.parseInt((String)model.get("no")));
				vo.setEmail((String)model.get("email"));
				vo.setPasswd((String)model.get("passwd"));
				vo.setName((String)model.get("name"));
				vo.setTel((String)model.get("tel"));
				vo.setFax((String)model.get("fax"));
				vo.setPostno((String)model.get("postno"));
				vo.setAddress((String)model.get("address"));
				vo.setPhoto(filePath);
				userDao.update(vo);
				return "redirect:detail.bit?no=" + vo.getNo();
			}
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}





















