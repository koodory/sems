package sems.controls.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.dao.DaoException;
import sems.dao.UserDao;
import sems.vo.UserVo;

@Controller
@RequestMapping("/auth")
public class LoginControl {
	@Autowired
	UserDao userDao;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "/auth/login.jsp";
	} 

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			String email,
			String password,
			@RequestParam(required=false)String saveEmail, //데이터가 없어도 처리
			HttpSession session,
			HttpServletResponse response){
		try {
			UserVo userVo = null;
			try{
				userVo = userDao.getUser(email, password);
			} catch (DaoException e) { // 로그인 실패!
				return "redirect:login.bit";
			}

			session.setAttribute("loginUser", userVo);

			if (saveEmail != null) {

				Cookie cookie = new Cookie("loginEmail", email);
				cookie.setDomain("s28.java48.com"); // 서버 범위
				cookie.setPath("/sems");					// 하위 폴더 범위

				response.addCookie(cookie);
			}
			return "redirect:/index.jsp";
		}catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}



















