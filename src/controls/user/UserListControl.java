package controls.user;

import java.util.List;
import java.util.Map;
import vo.UserVo;
import controls.PageController;
import dao.UserDao;

public class UserListControl implements PageController {
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
  public String execute(Map<String, Object> model) {
		try {
			int pageNo = Integer.parseInt((String)model.get("pageNo")); 
			int pageSize = Integer.parseInt((String)model.get("pageSize")); 
			List<UserVo> list = userDao.list(pageNo, pageSize);
			model.put("list", list);
			return "/user/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
  }

}













