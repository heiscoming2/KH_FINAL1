package com.itpro.model.dto.study;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudyInsertDto {
	
	
	private int bd_no;
	private String bd_title;
	private String bd_content;
	private Date bd_createddate;
	private Date bd_modifydate;
	private int bd_viewcount;
	private int bd_recommandcount;
	private String bd_writerip;
	private int bc_code;
	private int m_no;
	private int bd_replycount;
	private String st_status;
	private String st_addr1;
	private String st_addr2;
	private String st_addrdetail;
	private int st_nowperson;
	private int st_closeperson;
	
	
	
}
