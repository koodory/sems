package sems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import sems.annotations.Component;
import sems.vo.CourseVo;

@Component()
public class MysqlCourseDao implements CourseDao {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(CourseVo course) throws Throwable{
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"insert SE_COURS(TITLE, DEST, HOURS) values(?, ?, ?)");
			stmt.setString(1, course.getTitle());
			stmt.setString(2, course.getDescription());
			stmt.setInt(3, course.getHour());
			stmt.executeUpdate();
		}catch (Throwable e) {
			throw e;
		} finally {
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public List<CourseVo> list(int pageNo, int pageSize)
		throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"select CNO, TITLE, HOURS from SE_COURS"
							+ " order by CNO desc"
							+ " limit ?, ?");
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			ArrayList<CourseVo> list = new ArrayList<CourseVo>();
			while(rs.next()) {
				list.add(new CourseVo()
													.setNo(rs.getInt("CNO"))
													.setTitle(rs.getString("TITLE"))
													.setHour(rs.getInt("HOURS")));
			}
			return list;
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public CourseVo detail(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"select CNO, TITLE, DEST, HOURS from SE_COURS"
							+ " where CNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new CourseVo()
										.setNo(rs.getInt("CNO"))
										.setTitle(rs.getString("TITLE"))
										.setDescription(rs.getString("DEST"))
										.setHour(rs.getInt("HOURS"));
			} else {
				throw new Exception("해당 과정을 찾을 수 없습니다.");
			}
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public void update(CourseVo course) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"update SE_COURS set"
							+ " TITLE=?" 
							+ ", DEST=?"
							+ ", HOURS=?"
							+ " where CNO=?");
			stmt.setString(1, course.getTitle());
			stmt.setString(2, course.getDescription());
			stmt.setInt(3, course.getHour());
			stmt.setInt(4, course.getNo());
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public void delete(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"delete from SE_COURS where CNO=?"	);
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
}
