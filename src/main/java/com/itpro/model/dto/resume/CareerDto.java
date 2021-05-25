package com.itpro.model.dto.resume;

import java.util.Date;

public class CareerDto {
	
	private int m_no;//회원번호
	
	//경력 및 교육 사항
	private int ca_no;
	private String ca_title;
	private String ca_content;
	private String ca_start_date;
	private String ca_end_date;
	
	
	public CareerDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CareerDto(int m_no, int ca_no, String ca_title, String ca_content, String ca_start_date,
			String ca_end_date) {
		super();
		this.m_no = m_no;
		this.ca_no = ca_no;
		this.ca_title = ca_title;
		this.ca_content = ca_content;
		this.ca_start_date = ca_start_date;
		this.ca_end_date = ca_end_date;
	}


	public int getM_no() {
		return m_no;
	}


	public void setM_no(int m_no) {
		this.m_no = m_no;
	}


	public int getCa_no() {
		return ca_no;
	}


	public void setCa_no(int ca_no) {
		this.ca_no = ca_no;
	}


	public String getCa_title() {
		return ca_title;
	}


	public void setCa_title(String ca_title) {
		this.ca_title = ca_title;
	}


	public String getCa_content() {
		return ca_content;
	}


	public void setCa_content(String ca_content) {
		this.ca_content = ca_content;
	}


	public String getCa_start_date() {
		return ca_start_date;
	}


	public void setCa_start_date(String ca_start_date) {
		this.ca_start_date = ca_start_date;
	}


	public String getCa_end_date() {
		return ca_end_date;
	}


	public void setCa_end_date(String ca_end_date) {
		this.ca_end_date = ca_end_date;
	}

	
	
	
	
	
	
	
}
