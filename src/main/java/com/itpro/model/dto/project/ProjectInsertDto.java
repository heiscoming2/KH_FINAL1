package com.itpro.model.dto.project;

import java.util.Date;

public class ProjectInsertDto {
	// 게시판
	public int bd_no; // 게시글 번호
	
	
	/*
	 * public String bd_title; // 제목 public String bd_content; // 글 내용 public Date
	 * bd_createddate; // 작성일 public Date bd_modifydate; // 수정일 public String
	 * bd_writerip; // 작성시 ip public int bc_code; // 게시판 코드 public int
	 * bd_replycount; // 댓글수
	 * 
	 * public int bd_viewcount; // 조회수 public int bd_recommandcount; // 추천수 - 없
	 * public String m_no; // 작성자 id
	 */
	
	
	// 프로젝트 dto
	public int pro_no; // 프로젝트 번호
	public String pro_title; // 프로젝트 제목
	public String pro_start; // 프로젝트 시작일
	public String pro_end; // 프로젝트 종료일
	public String pro_link; // 프로젝트 링크(깃)
	public String pro_develop; // 개발환경
	public String pro_goal; // 개발 목표
	public String pro_function; // 구현 기능
	public String pro_erd; // erd 링크
	

	public ProjectInsertDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getBd_no() {
		return bd_no;
	}

	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}


	public String getPro_title() {
		return pro_title;
	}

	public void setPro_title(String pro_title) {
		this.pro_title = pro_title;
	}

	public String getPro_link() {
		return pro_link;
	}

	public void setPro_link(String pro_link) {
		this.pro_link = pro_link;
	}

	public String getPro_develop() {
		return pro_develop;
	}

	public void setPro_develop(String pro_develop) {
		this.pro_develop = pro_develop;
	}

	public String getPro_goal() {
		return pro_goal;
	}

	public void setPro_goal(String pro_goal) {
		this.pro_goal = pro_goal;
	}

	public String getPro_function() {
		return pro_function;
	}

	public void setPro_function(String pro_function) {
		this.pro_function = pro_function;
	}

	public String getPro_erd() {
		return pro_erd;
	}

	public void setPro_erd(String pro_erd) {
		this.pro_erd = pro_erd;
	}


}
