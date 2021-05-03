package com.itpro.model.dto;

import java.util.Date;

public class ReplyDto {
	
	private int re_no;
	private Date re_createddate;
	private Date re_modifydate;
	private String re_content;
	private String re_writerip;
	private int m_no;
	private int re_recommandcount;
	private int bd_no;
	
	public int getRe_no() {
		return re_no;
	}
	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}
	public Date getRe_createddate() {
		return re_createddate;
	}
	public void setRe_createddate(Date re_createddate) {
		this.re_createddate = re_createddate;
	}
	public Date getRe_modifydate() {
		return re_modifydate;
	}
	public void setRe_modifydate(Date re_modifydate) {
		this.re_modifydate = re_modifydate;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_writerip() {
		return re_writerip;
	}
	public void setRe_writerip(String re_writerip) {
		this.re_writerip = re_writerip;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getRe_recommandcount() {
		return re_recommandcount;
	}
	public void setRe_recommandcount(int re_recommandcount) {
		this.re_recommandcount = re_recommandcount;
	}
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}

}
