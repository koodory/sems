package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;
import dao.UserDao;

@WebServlet("/user/update.bit")
@SuppressWarnings("serial")
public class UserUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		try {
			int no = Integer.parseInt(request.getParameter("no"));
			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");
			UserVo user = dao.detail(no);

			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("/user/updateform.jsp");
			rd.forward(request, response);
			
			}catch (Throwable e){
				e.printStackTrace();
			}
		}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		try {

			UserDao dao = (UserDao)this.getServletContext().getAttribute("userDao");

			UserVo vo = new UserVo();
			vo.setNo(Integer.parseInt(request.getParameter("no")));
			vo.setEmail(request.getParameter("email"));
			vo.setPasswd(request.getParameter("passwd"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			vo.setFax(request.getParameter("fax"));
			vo.setPostno(request.getParameter("postno"));
			vo.setAddress(request.getParameter("address"));
			vo.setPhoto(request.getParameter("photo"));

			dao.update(vo);
			
			response.sendRedirect("detail.bit?no=" + vo.getNo());
		}catch (Throwable e){
			e.printStackTrace();
		}
	}
}
