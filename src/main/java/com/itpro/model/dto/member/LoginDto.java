package com.itpro.model.dto.member;

public class LoginDto {
	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_nickname;
		
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDto(int m_no, String m_id, String m_pw, String m_nickname) {
		super();
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_nickname = m_nickname;
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

	
	
	

	
	
	
	
}
