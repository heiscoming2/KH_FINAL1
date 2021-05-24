package com.itpro.model.dto.qna;

import java.sql.Clob;
import java.util.Date;

public class QnaInsertDto {
	// 게시판
	public int bd_no; // 게시글 번호
	public String bd_title; // 게시글 제목
	public String bd_content; // 게시글 내용
	public String bd_writerip; // 작성시 ip

	private Date bd_createddate;
	private Date bd_modifydate;
	private int bd_viewcount;
	private int bc_code;
	private int m_no;
	private int bd_recommandcount;
	private int bd_replycount;
	private String m_img_path;
	private String m_img;
	private String m_nickname;
	
	
	// 첨부 파일
	private String bf_originname; // 파일 저장명

	public QnaInsertDto() {
		super();
		// TODO Auto-generated constructor stub
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




	public int getBd_recommandcount() {
		return bd_recommandcount;
	}




	public void setBd_recommandcount(int bd_recommandcount) {
		this.bd_recommandcount = bd_recommandcount;
	}




	public int getBd_replycount() {
		return bd_replycount;
	}




	public void setBd_replycount(int bd_replycount) {
		this.bd_replycount = bd_replycount;
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




	public String getBd_writerip() {
		return bd_writerip;
	}




	public void setBd_writerip(String bd_writerip) {
		this.bd_writerip = bd_writerip;
	}




	public String getBd_title() {
		return bd_title;
	}

	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}

	public int getBd_no() {
		return bd_no;
	}

	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}

	public String getBd_content() {
		return bd_content;
	}

	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}

	public String getBf_originname() {
		return bf_originname;
	}

	public void setBf_originname(String bf_originname) {
		this.bf_originname = bf_originname;
	}

}
