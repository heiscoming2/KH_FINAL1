package com.itpro.model.dto.ad;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class AdDto {
	
	//ad 게신판
	public int ad_no;
	private String ad_comtype;
	private String ad_comname;
	private java.sql.Date ad_startdate;
	private java.sql.Date ad_enddate;
	private String ad_url;
	private String ad_price;
	private String ad_status;
	
	//게시판
	private int bd_no; // 게시글 번호
	private String bd_title; // 제목
	private String bd_content; // 글 내용
	private Date bd_createddate; // 작성일
	private Date bd_modifydate; // 수정일
	private String bd_writerip; // 작성시 ip
	private int bd_replycount; // 댓글수
	private int bd_viewcount; // 조회수
	private int bd_recommandcount; // 추천수

	// 첨부 파일
	private String ad_file_path;  // 파일 저장명

	//이미지 업로드
	private String ad_img_no; // 광고 이미지 경로
	private String ad_img; // 광고 이미지
	private String ad_img_path; // 저장 경로
	
	//회원
	private int m_no; // 회원 번호
	private String m_nickname;//회원이름 별명
	private String m_img_path;
	private String m_img;
}
