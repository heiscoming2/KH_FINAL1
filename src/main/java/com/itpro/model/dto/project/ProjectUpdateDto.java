package com.itpro.model.dto.project;

import java.util.Date;

public class ProjectUpdateDto {

	
	//게시판
	private int bd_no; //게시글 번호
	private String bd_title; //제목
	private String bd_content; //글 내용
	private int bd_createddate; //작성일
	private Date bd_modifydate; //수정일
	private String bd_writerip; //작성시 ip
	private int bd_replycount; // 댓글수
	private int bd_viewcount; // 조회수
	private int bd_recommandcount; //추천수
	
	//프로젝트 dto
	private String pro_title; //프로젝트 제목
	private Date pro_start; //프로젝트 시작일
	private Date pro_end; //프로젝트 종료일
	private String pro_link; //프로젝트 링크(깃)
	private String pro_develop; //개발환경
	private String pro_goal; //개발 목표
	private String pro_function; //구현 기능
	private String pro_erd; //erd 링크
	
	
	public ProjectUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getBd_createddate() {
		return bd_createddate;
	}
	public void setBd_createddate(int bd_createddate) {
		this.bd_createddate = bd_createddate;
	}
	public Date getBd_modifydate() {
		return bd_modifydate;
	}
	public void setBd_modifydate(Date bd_modifydate) {
		this.bd_modifydate = bd_modifydate;
	}
	public String getBd_writerip() {
		return bd_writerip;
	}
	public void setBd_writerip(String bd_writerip) {
		this.bd_writerip = bd_writerip;
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
	public int getBd_recommandcount() {
		return bd_recommandcount;
	}
	public void setBd_recommandcount(int bd_recommandcount) {
		this.bd_recommandcount = bd_recommandcount;
	}
	public String getPro_title() {
		return pro_title;
	}
	public void setPro_title(String pro_title) {
		this.pro_title = pro_title;
	}
	public Date getPro_start() {
		return pro_start;
	}
	public void setPro_start(Date pro_start) {
		this.pro_start = pro_start;
	}
	public Date getPro_end() {
		return pro_end;
	}
	public void setPro_end(Date pro_end) {
		this.pro_end = pro_end;
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
