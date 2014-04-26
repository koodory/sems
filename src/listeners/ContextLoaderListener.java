package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.MysqlCourseDao;
import dao.MysqlSubjectDao;
import dao.MysqlUserDao;
import util.DBConnectionPool;

/* ServetContextListener
 *  - 웹 애플리케이션의 시작/종료 이벤트 처리
 *  - 구현체 작성 => web.xml등록
 *  - <listener></listener>
 */

public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool dbConnectionPool = null;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed....");
		dbConnectionPool.closeAll();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized...");
		ServletContext sc = event.getServletContext();

		dbConnectionPool = new DBConnectionPool();
		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));

		MysqlSubjectDao subjectdao = new MysqlSubjectDao();
		subjectdao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("subjectDao", subjectdao);

		MysqlCourseDao coursedao = new MysqlCourseDao();
		coursedao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("courseDao", coursedao);

		MysqlUserDao userdao = new MysqlUserDao();
		userdao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("userDao", userdao);
	}

}
