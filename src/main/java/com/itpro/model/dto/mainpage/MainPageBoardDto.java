package com.itpro.model.dto.mainpage;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MainPageBoardDto {
	
	private String name;
	private int bd_no;
	private String bd_title;
	private String m_nickname;
	private Date bd_createddate;
	private int bd_viewcount;
	private int re_recommandcount;
	
}
