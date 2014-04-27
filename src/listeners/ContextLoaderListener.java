package listeners;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import util.DBConnectionPool;

/* 애플리케이션을 실행하는 중에 기록을 남기기
 * - 조건에 따라 기록을 남기는 걸 활성화하고 또는 비활성화 시키기
 * - log4j
 * 
 * .properties 파일을 이용해 빈 자동 생성 및 의존 객체 자동 주입
 */
public class ContextLoaderListener implements ServletContextListener {
	Logger log = Logger.getLogger(ContextLoaderListener.class);
	
	ServletContext sc;
	DBConnectionPool dbConnectionPool;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed....");
		dbConnectionPool.closeAll();

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("contextInitialized() 호출");
		sc = event.getServletContext();
		dbConnectionPool = new DBConnectionPool();
		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));
		
		// 생성된 객체를 보관할 임시 저장소
		HashMap<String,Object> objPool = new HashMap<String,Object>();
		objPool.put("dbConnectionPool", dbConnectionPool);
		objPool.put("servletContext", sc);
		
		try {
			// .properties 파일을 읽어서 빈을 생성한다.
			prepareBeansFromProperties(objPool);
			
			// objPool에 들어 있는 빈에 대해 의존 객체를 찾아 주입한다.
			injectDependencies(objPool);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 임시 보관소에 저장된 객체들을 ServletContext에 복사한다.
		// DispatcherServlet이 페이지 컨트롤러를 찾을 수 있도록 하기 위해.
		for (Entry<String,Object> entry : objPool.entrySet()) {
			sc.setAttribute(entry.getKey(), entry.getValue());
		}
	}

	private void injectDependencies(HashMap<String, Object> objPool) 
			throws Exception {
		// objPool에서 빈을 꺼내어 setXXX() 메서드를 찾는다.
		Class<?> clazz = null;
		Object dependency = null;
		for (Object obj : objPool.values()) {
			clazz = obj.getClass(); // 객체의 클래스 정보를 가져온다.
			log.debug(clazz.getName());
			
			// 셋터 메서드를 찾는다.
			for (Method m : clazz.getMethods()) {
				if (m.getName().startsWith("set")) {
					log.debug("==>" + m.getName());
					// 셋터 메서드의 파라미터 타입을 알아낸다.-> 의존 객체 찾는다.
					dependency = findDependency(
							objPool, m.getParameterTypes()[0]);
					if (dependency != null) { // 의존 객체를 찾았다면,
						// 셋터 메서드 호출 => 의존 객체 주입
						m.invoke(obj, dependency);	
						log.debug("  :" + m.getName() + " 호출 성공!");
					}
				}
			}
		}
  }
	
	private Object findDependency(
			HashMap<String,Object> objPool, Class<?> clazz) 
			throws Exception {
		for (Object dependency : objPool.values()) {
			if (clazz.isInstance(dependency)) {
				return dependency;
			}
		}
		return null;
	}

	private void prepareBeansFromProperties(
			HashMap<String, Object> objPool) throws Exception {
		// properties 파일이 있는 경로 알아내기
		String path = sc.getRealPath("/WEB-INF/classes/beans.properties");
		FileReader propIn = new FileReader(path); // 읽기 준비
		
		// beans.properties 파일 읽기
	  Properties props = new Properties();
	  props.load(propIn);
	  
	  // 프로퍼티 파일에 적혀있는대로 빈을 생성한다.
	  Class<?> clazz = null;
	  for (Entry<Object,Object> entry : props.entrySet()) {
	  	clazz = Class.forName( (String)entry.getValue() );
	  	objPool.put( (String)entry.getKey(), clazz.newInstance());
	  }
  }
}
























