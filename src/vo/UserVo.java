package vo;

import java.io.Serializable;

public class UserVo implements Serializable {
  private static final long serialVersionUID = 1L;
	private int 			no;
	private String 	email;
	private String 	passwd;
	private String 	name;
	private String 	tel;

	private String 	fax;
	private String 	postno;
	private String 	address;
	private String 	photo;
	
	public int getNo() {
		return no;
	}
	public UserVo setNo(int no) {
		this.no = no;
		return this;
	}

	public String getEmail() {
		return email;
	}
	public UserVo setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPasswd() {
		return passwd;
	}
	public UserVo setPasswd(String passwd) {
		this.passwd = passwd;
		return this;
	}

	public String getName() {
		return name;
	}
	public UserVo setName(String name) {
		this.name = name;
		return this;
	}

	public String getTel() {
		return tel;
	}
	public UserVo setTel(String tel) {
		this.tel = tel;
		return this;
	}

	public String getFax() {
		return fax;
	}
	public UserVo setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public String getPostno() {
		return postno;
	}
	public UserVo setPostno(String postno) {
		this.postno = postno;
		return this;
	}

	public String getAddress() {
		return address;
	}
	public UserVo setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhoto() {
		return photo;
	}
	public UserVo setPhoto(String photo) {
		this.photo = photo;
		return this;
	}

}
