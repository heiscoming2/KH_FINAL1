package com.itpro.model.dto.resume;

import java.util.Date;

public class EducationDto {
	
	private int m_no;//회원번호
		
	//학력사항
	private int ed_no;
	private String ed_date;
	private String ed_schoolName;//학교명
	private String ed_graduation;//졸업, 휴학, 중퇴, 재학
	private String ed_major; //전공
	private String ed_school;//대학원, 대학교, 고등학교
	
	
	public EducationDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EducationDto(int m_no, int ed_no, String ed_date, String ed_schoolName, String ed_graduation,
			String ed_major, String ed_school) {
		super();
		this.m_no = m_no;
		this.ed_no = ed_no;
		this.ed_date = ed_date;
		this.ed_schoolName = ed_schoolName;
		this.ed_graduation = ed_graduation;
		this.ed_major = ed_major;
		this.ed_school = ed_school;
	}


	public int getM_no() {
		return m_no;
	}


	public void setM_no(int m_no) {
		this.m_no = m_no;
	}


	public int getEd_no() {
		return ed_no;
	}


	public void setEd_no(int ed_no) {
		this.ed_no = ed_no;
	}


	public String getEd_date() {
		return ed_date;
	}


	public void setEd_date(String ed_date) {
		this.ed_date = ed_date;
	}


	public String getEd_schoolName() {
		return ed_schoolName;
	}


	public void setEd_schoolName(String ed_schoolName) {
		this.ed_schoolName = ed_schoolName;
	}


	public String getEd_graduation() {
		return ed_graduation;
	}


	public void setEd_graduation(String ed_graduation) {
		this.ed_graduation = ed_graduation;
	}


	public String getEd_major() {
		return ed_major;
	}


	public void setEd_major(String ed_major) {
		this.ed_major = ed_major;
	}


	public String getEd_school() {
		return ed_school;
	}


	public void setEd_school(String ed_school) {
		this.ed_school = ed_school;
	}

	
	
	
	
	
	
	
}
