package com.itpro.model.dto.member;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDto {
	private int m_no; // 회원번호
	private String m_id;// 아이디
	private String m_pw;// 비밀번호
	private String m_nickname;// 닉네임,기업명
	private String m_phone;// 전화번호
	private String m_email;// 이메일
	private String m_used;// 탈퇴여부
	private String m_act;// 활동여부
	private String m_mail_cert;// 메일인증
	private String m_type;// 회원타입
	private String m_auth;// 권한
	private String m_img_path; // 이미지경로
	private String m_img; // 이미지
	private Date m_regdate;// 등록일
	private String m_name; // 이름
	private Date m_birth; // 생년월일
	private String m_gender; // 성별
	private String m_resumechk; // 이력서 작성여부(Y,N)

	// 기업 회원 추가정보
	private String m_regno;// 사업자번호
	private String m_admin_cert;// 기업회원승인여부


}
