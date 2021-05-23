package com.itpro.model.dto.member;

import java.util.Date;

public class ProfileDto {
	private int m_no; // 회원번호
	private String m_img_path; // 이미지경로
	private String m_img; // 이미지
	
	public ProfileDto() {
		super();
	}

	public ProfileDto(int m_no, String m_img_path, String m_img) {
		super();
		this.m_no = m_no;
		this.m_img_path = m_img_path;
		this.m_img = m_img;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
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

	
	

}
