package com.itpro.model.dto.member;

public class LoginDto {
	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_nickname;
	private String m_email;
	private String m_img_path;
	private String m_img;
	private String m_auth;
		
	public LoginDto() {
		super();
	}

	public LoginDto(int m_no, String m_id, String m_pw, String m_nickname, String m_email, String m_img_path,
			String m_img, String m_auth) {
		super();
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_nickname = m_nickname;
		this.m_email = m_email;
		this.m_img_path = m_img_path;
		this.m_img = m_img;
		this.m_auth = m_auth;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_img_path() {
		return m_img_path;
	}

	public void setM_img_path(String m_img_path) {
		this.m_img_path = m_img_path;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}

	public String getM_auth() {
		return m_auth;
	}

	public void setM_auth(String m_auth) {
		this.m_auth = m_auth;
	}

	
	
	

	
	
	

	
	
	
	
}
