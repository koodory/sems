package servlets.auth;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.UserVo;
import dao.UserDao;

@WebServlet("/auth/login.bit")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {

			RequestDispatcher rd = 
					request.getRequestDispatcher("/auth/login.jsp");
			rd.forward(request, response);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String saveEmail = request.getParameter("saveEmail");

			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");			
			UserVo userVo = null;

			try {
				userVo = dao.getUser(email, password);
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", userVo);
				
			} catch (Throwable ex) {
				ex.printStackTrace();
				response.sendRedirect("login.bit");
				return;
			}

			if (saveEmail != null) {
				Cookie cookie = new Cookie("loginEmail", email);
				cookie.setDomain("s28.java48.com"); 
				cookie.setPath("/sems");					
	
				// 유효기간 지정
				//cookie.setMaxAge(40);
				response.addCookie(cookie);
			}
			response.sendRedirect("/sems/index.jsp");

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















