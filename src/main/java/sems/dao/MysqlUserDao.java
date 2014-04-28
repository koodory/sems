package sems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import sems.annotations.Component;
import sems.vo.UserVo;

@Component()
public class MysqlUserDao implements UserDao {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
}
	
	public void insert(UserVo user) throws Throwable{
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"insert SE_USERS(EMAIL, PWD, NAME, TEL, FAX, POSTNO, ADDR, PHOT_PATH)"
					+ " values(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPasswd());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getTel());
			stmt.setString(5, user.getFax());
			stmt.setString(6, user.getPostno());
			stmt.setString(7, user.getAddress());
			stmt.setString(8, user.getPhoto());
			stmt.executeUpdate();
		}catch (Throwable e) {
			throw e;
		} finally {
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public List<UserVo> list(int pageNo, int pageSize)
		throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"select UNO, EMAIL, NAME, TEL from SE_USERS"
							+ " order by UNO desc"
							+ " limit ?, ?");
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			ArrayList<UserVo> list = new ArrayList<UserVo>();
			while(rs.next()) {
				list.add(new UserVo()
													.setNo(rs.getInt("UNO"))
													.setEmail(rs.getString("EMAIL"))
													.setName(rs.getString("NAME"))
													.setTel(rs.getString("TEL")));
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
	
	public UserVo detail(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"select UNO, EMAIL, NAME, TEL, FAX, POSTNO, ADDR, PHOT_PATH"
					+ " from SE_USERS"
							+ " where UNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new UserVo()
										.setNo(rs.getInt("UNO"))
										.setEmail(rs.getString("EMAIL"))
										.setName(rs.getString("NAME"))
										.setTel(rs.getString("TEL"))
										.setFax(rs.getString("FAX"))
										.setPostno(rs.getString("POSTNO"))
										.setAddress(rs.getString("ADDR"))
										.setPhoto(rs.getString("PHOT_PATH"));
			} else {
				throw new Exception("해당 사용자를 찾을 수 없습니다.");
			}
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public void update(UserVo user) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"update SE_USERS set"
							+ " EMAIL=?" 
							+ ", PWD=?"
							+ ", NAME=?"
							+ ", TEL=?"
							+ ", FAX=?"
							+ ", POSTNO=?"
							+ ", ADDR=?"
							+ ", PHOT_PATH=?"
							+ " where uNO=?");
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPasswd());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getTel());
			stmt.setString(5, user.getFax());
			stmt.setString(6, user.getPostno());
			stmt.setString(7, user.getAddress());
			stmt.setString(8, user.getPhoto());
			stmt.setInt(9, user.getNo());
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
					"delete from SE_USERS where UNO=?"	);
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}

	@Override
  public UserVo getUser(String email, String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"select UNO, NAME, EMAIL, TEL from SE_USERS"
					+ " where EMAIL=? and PWD=?");
			
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new UserVo()
										.setNo(rs.getInt("UNO"))
										.setName(rs.getString("NAME"))
										.setEmail(rs.getString("EMAIL"))
										.setTel(rs.getString("TEL"));
			} else {
				throw new Exception("아이디와 암호가 일치하는 사용자가 없습니다.");
			}
		} catch (Throwable e) {
			throw new DaoException(e);
			
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
  }
}

