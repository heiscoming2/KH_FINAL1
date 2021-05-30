package com.itpro.model.dto.study;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyListDto {
	
	private int bd_no;
	private String st_status;
	private String st_addr1;
	private String st_addr2;
	private int st_nowperson;
	private int st_closeperson;
	private String bd_title;
	private int bd_replycount;
	private int bd_viewcount;
	private int bd_recommandcount;
	private int m_no;
	private String m_img_path;
	private String m_img;
	private String m_nickname;
	private Date bd_createddate;
	
	
}
