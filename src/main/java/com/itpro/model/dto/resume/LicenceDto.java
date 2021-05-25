package com.itpro.model.dto.resume;

import java.util.Date;

public class LicenceDto {
	
	private int m_no;//회원번호
	
	
	//자격사항
	private int li_no;
	private String li_title;
	private String li_date;
	private String li_organ;
	
	
	
	public LicenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LicenceDto(int m_no, int li_no, String li_title, String li_date, String li_organ) {
		super();
		this.m_no = m_no;
		this.li_no = li_no;
		this.li_title = li_title;
		this.li_date = li_date;
		this.li_organ = li_organ;
	}



	public int getM_no() {
		return m_no;
	}



	public void setM_no(int m_no) {
		this.m_no = m_no;
	}



	public int getLi_no() {
		return li_no;
	}



	public void setLi_no(int li_no) {
		this.li_no = li_no;
	}



	public String getLi_title() {
		return li_title;
	}



	public void setLi_title(String li_title) {
		this.li_title = li_title;
	}



	public String getLi_date() {
		return li_date;
	}



	public void setLi_date(String li_date) {
		this.li_date = li_date;
	}



	public String getLi_organ() {
		return li_organ;
	}



	public void setLi_organ(String li_organ) {
		this.li_organ = li_organ;
	}


	
	
	
	
	
	
}
