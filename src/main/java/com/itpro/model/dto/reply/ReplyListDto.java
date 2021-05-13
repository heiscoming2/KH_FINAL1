package com.itpro.model.dto.reply;

import java.util.Date;

public class ReplyListDto {
	
	private int re_no;
	private Date re_createddate;
	private Date re_modifydate;
	private String re_content;
	private String re_writerip;
	private int m_no;
	private String m_img_path;
	private String m_img;
	private String m_nickname;
	private int bd_no;
	
	
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

	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	
	
	
}
