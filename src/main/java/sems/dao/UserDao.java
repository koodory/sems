package sems.dao;

import java.util.List;
import java.util.Map;

import sems.vo.UserVo;

public interface UserDao {
	void insert(UserVo user) throws Throwable;
	List<UserVo> list(Map<String,Integer> params) throws Throwable;
	UserVo detail(int no) throws Throwable;
	void update(UserVo user) throws Throwable;
	void delete(int no) throws Throwable;
	UserVo getUser(Map<String,String> params);
}
