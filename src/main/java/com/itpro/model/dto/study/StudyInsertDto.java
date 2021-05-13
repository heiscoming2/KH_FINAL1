package com.itpro.model.dto.study;

import java.util.Date;

public class StudyInsertDto {
	
	
	private int bd_no;
	private String bd_title;
	private String bd_content;
	private Date bd_createddate;
	private Date bd_modifydate;
	private int bd_viewcount;
	private int bd_recommandcount;
	private String bd_writerip;
	private int bc_code;
	private int m_no;
	private int bd_replycount;
	private String st_status;
	private String st_addr1;
	private String st_addr2;
	private String st_addrdetail;
	private int st_nowperson;
	private int st_closeperson;
	
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
	public int getBd_viewcount() {
		return bd_viewcount;
	}
	public void setBd_viewcount(int bd_viewcount) {
		this.bd_viewcount = bd_viewcount;
	}
	public int getBd_recommandcount() {
		return bd_recommandcount;
	}
	public void setBd_recommandcount(int bd_recommandcount) {
		this.bd_recommandcount = bd_recommandcount;
	}
	public String getBd_writerip() {
		return bd_writerip;
	}
	public void setBd_writerip(String bd_writerip) {
		this.bd_writerip = bd_writerip;
	}
	public int getBc_code() {
		return bc_code;
	}
	public void setBc_code(int bc_code) {
		this.bc_code = bc_code;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getBd_replycount() {
		return bd_replycount;
	}
	public void setBd_replycount(int bd_replycount) {
		this.bd_replycount = bd_replycount;
	}
	public String getSt_status() {
		return st_status;
	}
	public void setSt_status(String st_status) {
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
	@Override
	public String toString() {
		return "StudyDto [bd_no=" + bd_no + ", bd_title=" + bd_title + ", bd_content=" + bd_content
				+ ", bd_createddate=" + bd_createddate + ", bd_modifydate=" + bd_modifydate + ", bd_viewcount="
				+ bd_viewcount + ", bd_recommandcount=" + bd_recommandcount + ", bd_writerip=" + bd_writerip
				+ ", bc_code=" + bc_code + ", m_no=" + m_no + ", st_status=" + st_status + ", st_addr1=" + st_addr1
				+ ", st_addr2=" + st_addr2 + ", st_addrdetail=" + st_addrdetail + ", st_nowperson=" + st_nowperson
				+ ", st_closeperson=" + st_closeperson + "]";
	}
	
	
}
