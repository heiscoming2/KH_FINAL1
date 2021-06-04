package com.itpro.model.dto.ad;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KakaoPayDto {
	
	
	//결제
	private int pay_seq;
	private Date regdate;
	private int price;

	// 회원
	private String m_img_path; // 프로필 이미지 경로
	private String m_img; // 프로필 이미지
	private String m_nickname; // 닉네임
	private int m_no; // 회원 번호

}
