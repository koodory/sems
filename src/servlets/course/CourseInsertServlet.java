package servlets.course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@WebServlet("/course/insert.bit")
@SuppressWarnings("serial")
public class CourseInsertServlet extends HttpServlet {
	
	@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		doGet(request, response);
  }
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		try {

			CourseDao dao = (CourseDao)this.getServletContext().getAttribute("courseDao");

			
			CourseVo vo = new CourseVo();
			vo.setTitle(request.getParameter("title"));
			vo.setDescription(request.getParameter("description"));
			vo.setHour(Integer.parseInt(request.getParameter("hour")));

			dao.insert(vo);
			
			response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
		}catch (Throwable e){
			e.printStackTrace();
		}
	}
}
