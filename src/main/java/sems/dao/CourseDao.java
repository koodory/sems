package sems.dao;

import java.util.List;

import sems.vo.CourseVo;

public interface CourseDao {
	void insert(CourseVo course) throws Throwable;
	List<CourseVo> list(int pageNo, int pageSize) throws Throwable;
	CourseVo detail(int no) throws Throwable;
	void update(CourseVo Course) throws Throwable;
	void delete(int no) throws Throwable;
}
