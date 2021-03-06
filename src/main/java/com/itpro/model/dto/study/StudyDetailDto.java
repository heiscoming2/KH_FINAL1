package com.itpro.model.dto.study;

import java.util.Date;

public class StudyDetailDto {
	
	private int m_no;
	private String m_img_path;
	private String m_img;
	private String m_nickname;
	private String bd_writerip;
	private Date bd_createddate;
	private Date bd_modifydate;
	private int bd_no;
	private String bd_title;
	private String bd_content;
	private String bd_recommandcount;
	private String st_addr1;
	private String st_addr2;
	private String st_addrdetail;
	private int st_nowperson;
	private String st_status;
	private int st_closeperson;
	
	
	
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getSt_status() {
		return st_status;
	}
	public void setSt_status(String st_status) {
		this.st_status = st_status;
	}
	public String getBd_writerip() {
		return bd_writerip;
	}
	public void setBd_writerip(String bd_writerip) {
		this.bd_writerip = bd_writerip;
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
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public Date getBd_createddate() {
		return bd_createddate;
	}
	public void setBd_createddate(Date bd_createddate) {
		this.bd_createddate = bd_createddate;
	}
	public Date getBd_modifydate() {
		return bd_modifydate;
	}
	public void setBd_modifydate(Date bd_modifydate) {
		this.bd_modifydate = bd_modifydate;
	}
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
	public String getBd_content() {
		return bd_content;
	}
	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}
	public String getBd_recommandcount() {
		return bd_recommandcount;
	}
	public void setBd_recommandcount(String bd_recommandcount) {
		this.bd_recommandcount = bd_recommandcount;
	}
	public String getSt_addr1() {
		return st_addr1;
	}
	public void setSt_addr1(String st_addr1) {
		this.st_addr1 = st_addr1;
	}
	public String getSt_addr2() {
		return st_addr2;
	}
	public void setSt_addr2(String st_addr2) {
		this.st_addr2 = st_addr2;
	}
	public String getSt_addrdetail() {
		return st_addrdetail;
	}
	public void setSt_addrdetail(String st_addrdetail) {
		this.st_addrdetail = st_addrdetail;
	}
	public int getSt_nowperson() {
		return st_nowperson;
	}
	public void setSt_nowperson(int st_nowperson) {
		this.st_nowperson = st_nowperson;
	}
	public int getSt_closeperson() {
		return st_closeperson;
	}
	public void setSt_closeperson(int st_closeperson) {
		this.st_closeperson = st_closeperson;
	}
	
	
	
}
