package sems.dao;

import java.util.List;
import java.util.Map;

import sems.vo.CourseVo;

public interface CourseDao {
	void insert(CourseVo course) throws Throwable;
	List<CourseVo> list(Map<String,Integer> params) throws Throwable;
	CourseVo detail(int no) throws Throwable;
	void update(CourseVo Course) throws Throwable;
	void delete(int no) throws Throwable;
}
