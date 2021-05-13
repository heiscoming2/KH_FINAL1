package com.itpro.model.dao;

import java.util.HashMap;

import com.itpro.model.dto.like.LikeDto;
import com.itpro.model.dto.reply.ReplyUpdateDto;


public interface LikeDao {
	

	
	String NAMESPACE = "liketo.";
	

	public int like_check(LikeDto likeDto);

	public int like_delete(LikeDto likeDto);
	
	public int like_insert(LikeDto likeDto);
	

}
