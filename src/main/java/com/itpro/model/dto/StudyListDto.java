package com.itpro.model.dto;

import java.util.Date;

public class StudyListDto {
	
	private int bd_no;
	private char st_status;
	private String st_addr1;
	private String st_addr2;
	private int st_nowperson;
	private int st_closeperson;
	private String bd_title;
	private int bd_replycount;
	private int bd_viewcount;
	private String m_img_path;
	private String m_img;
	private String m_name;
	private Date bd_createddate;
	
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	public char getSt_status() {
		return st_status;
	}
	public void setSt_status(char st_status) {
		this.st_status = st_status;
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
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
	public int getBd_replycount() {
		return bd_replycount;
	}
	public void setBd_replycount(int bd_replycount) {
		this.bd_replycount = bd_replycount;
	}
	public int getBd_viewcount() {
		return bd_viewcount;
	}
	public void setBd_viewcount(int bd_viewcount) {
		this.bd_viewcount = bd_viewcount;
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
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Date getBd_createddate() {
		return bd_createddate;
	}
	public void setBd_createddate(Date bd_createddate) {
		this.bd_createddate = bd_createddate;
	}
	
	
	
}
