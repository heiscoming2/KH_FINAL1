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
	private int ad_no;
	private String ad_comtype;
	private String ad_comname;
	private String ad_startdate;
	private String ad_enddate;
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
	private String file_path;  // 파일 저장명

	// 회원
	private String m_img_path; // 프로필 이미지 경로
	private String m_img; // 프로필 이미지
	private String m_nickname; // 닉네임
	private int m_no; // 회원 번호

}
