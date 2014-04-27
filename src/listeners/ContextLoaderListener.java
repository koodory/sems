package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.DBConnectionPool;
import controls.auth.LoginControl;
import controls.auth.LogoutControl;
import controls.FileUploadControl; 
import controls.course.CourseDeleteControl;
import controls.course.CourseDetailControl;
import controls.course.CourseInsertControl;
import controls.course.CourseListControl;
import controls.course.CourseUpdateControl;
import controls.subject.SubjectDeleteControl;
import controls.subject.SubjectDetailControl;
import controls.subject.SubjectInsertControl;
import controls.subject.SubjectListControl;
import controls.subject.SubjectUpdateControl;
import controls.user.UserDeleteControl;
import controls.user.UserDetailControl;
import controls.user.UserInsertControl;
import controls.user.UserListControl;
import controls.user.UserUpdateControl;
import dao.MysqlCourseDao;
import dao.MysqlSubjectDao;
import dao.MysqlUserDao;

/* PageController를 ServletContext에 보관함.
 * - PageController가 필요로 하는 의존 객체를 주입한 후에 보관한다.
 */
public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool dbConnectionPool;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed....");
		dbConnectionPool.closeAll();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized....");
		ServletContext sc = event.getServletContext();
		dbConnectionPool = new DBConnectionPool();
		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));
		
		MysqlSubjectDao subjectDao = new MysqlSubjectDao();
		subjectDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("subjectDao", subjectDao);

		MysqlUserDao userDao = new MysqlUserDao();
		userDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("userDao", userDao);
		
		MysqlCourseDao courseDao = new MysqlCourseDao();
		courseDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("courseDao", courseDao);
		
		LoginControl loginControl = new LoginControl();
		loginControl.setUserDao(userDao);
		sc.setAttribute("/auth/login.bit", loginControl);

		LogoutControl logoutControl = new LogoutControl();
		sc.setAttribute("/auth/logout.bit", logoutControl);
		
		FileUploadControl fileUpLoadControl = new FileUploadControl();
		sc.setAttribute("/file/upload.bit", fileUpLoadControl);

		SubjectListControl subjectListControl = new SubjectListControl();
		subjectListControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/list.bit", subjectListControl);

		SubjectDetailControl subjectDetailControl = 
				new SubjectDetailControl();
		subjectDetailControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/detail.bit", subjectDetailControl);

		SubjectInsertControl subjectInsertControl = 
				new SubjectInsertControl();
		subjectInsertControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/insert.bit", subjectInsertControl);

		SubjectUpdateControl subjectUpdateControl = 
				new SubjectUpdateControl();
		subjectUpdateControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/update.bit", subjectUpdateControl);

		SubjectDeleteControl subjectDeleteControl = 
				new SubjectDeleteControl();
		subjectDeleteControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/delete.bit", subjectDeleteControl);
		
		CourseListControl courseListControl = new CourseListControl();
		courseListControl.setCourseDao(courseDao);
		sc.setAttribute("/course/list.bit", courseListControl);	
		
		CourseDetailControl courseDetailControl = 
				new CourseDetailControl();
		courseDetailControl.setCourseDao(courseDao);
		sc.setAttribute("/course/detail.bit", courseDetailControl);
		
		CourseInsertControl courseInsertControl = 
				new CourseInsertControl();
		courseInsertControl.setCourseDao(courseDao);
		sc.setAttribute("/course/insert.bit", courseInsertControl);
		
		CourseUpdateControl courseUpdateControl = 
				new CourseUpdateControl();
		courseUpdateControl.setCourseDao(courseDao);
		sc.setAttribute("/course/update.bit", courseUpdateControl);

		CourseDeleteControl courseDeleteControl = 
				new CourseDeleteControl();
		courseDeleteControl.setCourseDao(courseDao);
		sc.setAttribute("/course/delete.bit", courseDeleteControl);
		
		UserListControl userListControl = new UserListControl();
		userListControl.setUserDao(userDao);
		sc.setAttribute("/user/list.bit", userListControl);	
		
		UserDetailControl userDetailControl = 
				new UserDetailControl();
		userDetailControl.setUserDao(userDao);
		sc.setAttribute("/user/detail.bit", userDetailControl);
		
		UserInsertControl userInsertControl = 
				new UserInsertControl();
		userInsertControl.setUserDao(userDao);
		sc.setAttribute("/user/insert.bit", userInsertControl);
		
		UserUpdateControl userUpdateControl = 
				new UserUpdateControl();
		userUpdateControl.setUserDao(userDao);
		sc.setAttribute("/user/update.bit", userUpdateControl);

		UserDeleteControl userDeleteControl = 
				new UserDeleteControl();
		userDeleteControl.setUserDao(userDao);
		sc.setAttribute("/user/delete.bit", userDeleteControl);
	}
}
