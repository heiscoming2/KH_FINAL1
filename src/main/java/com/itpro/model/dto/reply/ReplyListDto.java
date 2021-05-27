package com.itpro.model.dto.reply;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyListDto {
	
	private int re_no;
	private Date re_createddate;
	private Date re_modifydate;
	private String re_content;
	private String re_writerip;
	private int re_depth;
	private String re_ishidden;
	private String targetid;
	private int m_no;
	private String m_img_path;
	private String m_img;
	private String m_nickname;
	private int bd_no;
	
	
	
	
	
}
