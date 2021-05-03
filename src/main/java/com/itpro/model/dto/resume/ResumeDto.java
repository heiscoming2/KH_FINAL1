package com.itpro.model.dto.resume;

import java.util.Date;

public class ResumeDto {
	//이력서 기본사항
	private int r_no;
	private String r_title;
	private String r_name;
	private Date r_birth;
	private String r_gender;
	private String r_phone;
	private String r_addr;
	
	//교육사항
	private String ca_title;
	private String ca_date;
	private String ca_content;
	
	//학력사항
	private String ed_date;
	private String ed_school;
	private String ed_graduation;
	
	//자격사항
	private String li_title;
	private String li_date;
	private String li_organ;
	
	public ResumeDto() {}

	public ResumeDto(int r_no, String r_title, String r_name, Date r_birth, String r_gender, String r_phone,
			String r_addr, String ca_title, String ca_date, String ca_content, String ed_date, String ed_school,
			String ed_graduation, String li_title, String li_date, String li_organ) {
		super();
		this.r_no = r_no;
		this.r_title = r_title;
		this.r_name = r_name;
		this.r_birth = r_birth;
		this.r_gender = r_gender;
		this.r_phone = r_phone;
		this.r_addr = r_addr;
		this.ca_title = ca_title;
		this.ca_date = ca_date;
		this.ca_content = ca_content;
		this.ed_date = ed_date;
		this.ed_school = ed_school;
		this.ed_graduation = ed_graduation;
		this.li_title = li_title;
		this.li_date = li_date;
		this.li_organ = li_organ;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public Date getR_birth() {
		return r_birth;
	}

	public void setR_birth(Date r_birth) {
		this.r_birth = r_birth;
	}

	public String getR_gender() {
		return r_gender;
	}

	public void setR_gender(String r_gender) {
		this.r_gender = r_gender;
	}

	public String getR_phone() {
		return r_phone;
	}

	public void setR_phone(String r_phone) {
		this.r_phone = r_phone;
	}

	public String getR_addr() {
		return r_addr;
	}

	public void setR_addr(String r_addr) {
		this.r_addr = r_addr;
	}

	public String getCa_title() {
		return ca_title;
	}

	public void setCa_title(String ca_title) {
		this.ca_title = ca_title;
	}

	public String getCa_date() {
		return ca_date;
	}

	public void setCa_date(String ca_date) {
		this.ca_date = ca_date;
	}

	public String getCa_content() {
		return ca_content;
	}

	public void setCa_content(String ca_content) {
		this.ca_content = ca_content;
	}

	public String getEd_date() {
		return ed_date;
	}

	public void setEd_date(String ed_date) {
		this.ed_date = ed_date;
	}

	public String getEd_school() {
		return ed_school;
	}

	public void setEd_school(String ed_school) {
		this.ed_school = ed_school;
	}

	public String getEd_graduation() {
		return ed_graduation;
	}

	public void setEd_graduation(String ed_graduation) {
		this.ed_graduation = ed_graduation;
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
