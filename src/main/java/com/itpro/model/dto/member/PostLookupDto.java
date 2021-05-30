package com.itpro.model.dto.member;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostLookupDto {
	
	private String name;
	private int bc_code;
	private int bd_no;
	private String bd_title;
	private int bd_replycount;
	private int bd_viewcount;
	private int bd_recommandcount;
	private String m_img_path;
	private String m_img;
	private String m_nickname;
	private Date bd_createddate;
	private String searchKey;

}
