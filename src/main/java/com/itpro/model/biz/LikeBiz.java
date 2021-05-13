package com.itpro.model.biz;

import java.util.HashMap;

import com.itpro.model.dto.like.LikeDto;

public interface LikeBiz {


	public int like_check(LikeDto likeDto);
	public int like_delete(LikeDto likeDto);
	public int like_insert(LikeDto likeDto);
	
}
